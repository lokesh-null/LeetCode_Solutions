const fs = require('fs');
const path = require('path');

// Constants
const LEETCODE_API_ENDPOINT = 'https://leetcode.com/graphql';

// Language extension mapping
const LANGUAGE_MAP = {
  '.java': 'Java',
  '.py': 'Python',
  '.cpp': 'C++',
  '.c': 'C',
  '.js': 'JavaScript',
  '.ts': 'TypeScript',
  '.cs': 'C#',
  '.go': 'Go',
  '.rb': 'Ruby',
  '.swift': 'Swift',
  '.rs': 'Rust',
  '.kt': 'Kotlin',
  '.php': 'PHP',
};

// Function to fetch topics from LeetCode
async function fetchTopics(titleSlug) {
  const query = `
    query questionData($titleSlug: String!) {
      question(titleSlug: $titleSlug) {
        topicTags {
          name
        }
      }
    }
  `;
  
  try {
    const response = await fetch(LEETCODE_API_ENDPOINT, {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify({
        operationName: 'questionData',
        variables: { titleSlug },
        query,
      }),
    });
    
    const data = await response.json();
    if (data && data.data && data.data.question && data.data.question.topicTags) {
      return data.data.question.topicTags.map(tag => tag.name);
    }
  } catch (error) {
    console.error(`Error fetching topics for ${titleSlug}:`, error);
  }
  return [];
}

// Function to deduce language from files in directory
function getLanguageFromDir(dirPath) {
  const files = fs.readdirSync(dirPath);
  for (const file of files) {
    const ext = path.extname(file);
    if (LANGUAGE_MAP[ext]) {
      return LANGUAGE_MAP[ext];
    }
  }
  return 'Unknown';
}

async function main() {
  const rootDir = __dirname;
  const dirs = fs.readdirSync(rootDir, { withFileTypes: true })
    .filter(dirent => dirent.isDirectory() && !dirent.name.startsWith('.') && dirent.name !== 'node_modules')
    .map(dirent => dirent.name);

  const problems = [];

  for (const dir of dirs) {
    const readmePath = path.join(rootDir, dir, 'README.md');
    if (!fs.existsSync(readmePath)) continue;

    const readmeContent = fs.readFileSync(readmePath, 'utf8');
    
    // Extract title slug and name
    // Example: <h2><a href="https://leetcode.com/problems/two-sum">1. Two Sum</a></h2>
    const linkRegex = /<a href="https:\/\/leetcode\.com\/problems\/([^/"]+)">([^<]+)<\/a>/;
    const match = readmeContent.match(linkRegex);
    
    if (match) {
      const titleSlug = match[1];
      const name = match[2];
      
      const numMatch = name.match(/^(\d+)\.\s+(.*)$/);
      let number = '';
      let problemName = name;
      if (numMatch) {
        number = numMatch[1];
        problemName = numMatch[2];
      }

      const language = getLanguageFromDir(path.join(rootDir, dir));
      const topics = await fetchTopics(titleSlug);

      problems.push({
        dir,
        number,
        problemName,
        language,
        topics: topics.length > 0 ? topics : ['Uncategorized']
      });
      
      console.log(`Processed: ${problemName} (${topics.join(', ')})`);
    }
  }

  // Group by topic
  const topicMap = {};
  for (const problem of problems) {
    for (const topic of problem.topics) {
      if (!topicMap[topic]) {
        topicMap[topic] = [];
      }
      topicMap[topic].push(problem);
    }
  }

  // Build new README.md
  let newReadme = `# LeetCode Solutions\n\nA collection of LeetCode questions to ace the coding interview! - Created using [LeetHub v2](https://github.com/arunbhardwaj/LeetHub-2.0)\n\nThis repository contains my solutions to LeetCode problems, categorized by **Topic**.\n\n`;

  // Sort topics alphabetically
  const sortedTopics = Object.keys(topicMap).sort();

  for (const topic of sortedTopics) {
    newReadme += `## ${topic}\n\n`;
    newReadme += `| # | Problem | Language |\n`;
    newReadme += `| :---: | :--- | :---: |\n`;
    
    // Sort problems by number
    const sortedProblems = topicMap[topic].sort((a, b) => {
      return parseInt(a.number || '0') - parseInt(b.number || '0');
    });

    for (const problem of sortedProblems) {
      newReadme += `| ${problem.number} | [${problem.problemName}](./${problem.dir}) | ${problem.language} |\n`;
    }
    newReadme += `\n`;
  }

  // Write to README.md
  fs.writeFileSync(path.join(rootDir, 'README.md'), newReadme, 'utf8');
  console.log('README.md successfully updated!');
}

main().catch(console.error);
