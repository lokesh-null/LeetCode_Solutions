import urllib.request
import json

url = 'https://leetcode.com/graphql'
data = {
    'operationName': 'questionData',
    'variables': {'titleSlug': 'two-sum'},
    'query': 'query questionData($titleSlug: String!) { question(titleSlug: $titleSlug) { topicTags { name } } }'
}

req = urllib.request.Request(url, data=json.dumps(data).encode('utf-8'), headers={'Content-Type':'application/json'})
res = urllib.request.urlopen(req)
print(res.read().decode('utf-8'))
