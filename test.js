fetch('https://leetcode.com/graphql', {
  method: 'POST',
  headers: {
    'Content-Type': 'application/json',
  },
  body: JSON.stringify({
    operationName: 'questionData',
    variables: { titleSlug: 'two-sum' },
    query: 'query questionData($titleSlug: String!) { question(titleSlug: $titleSlug) { topicTags { name } } }'
  })
})
.then(res => res.json())
.then(console.log)
.catch(console.error);
