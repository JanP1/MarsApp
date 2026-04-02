import requests

all_titles = []
limit = 50
offset = 0

while True:
    print(offset)
    url = f"https://api.spaceflightnewsapi.net/v4/articles/?title_contains=Mars&limit={limit}&offset={offset}"
    response = requests.get(url)
    data = response.json()
    
    results = data['results']
    if not results or offset>200:
        if not len(all_titles):
            print("No matching results")
        else:
            print("Finished : ")

        break
    
    for article in results:
        all_titles.append({"title": article['title'], "date": article['published_at']})
    
    offset += limit

for title in all_titles:
    print(title)
