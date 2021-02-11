# wykorzystane API: https://api.abalin.net/

import requests
import json

country = 'pl'
month = '01'
day = '30'

url = "https://api.abalin.net/namedays?country={0}&month={1}&day={2}".format(country, month, day)
head = {'content-type': 'application/json'}
response = requests.request("GET", url)
data = json.loads(response.text)


# sprawdzanie statusu odpowiedzi (kod 200 - poprawne)
assert response.status_code == 200


# sprawdzanie kluczy
expected = ['dates', 'namedays']
current = []

expected2 = ['day', 'month', country]
current2 = []

for key, value in data.items():
    for k, v in value.items():
        if k in expected:
            current.append(k)
        for x, y in v.items():
            if x in expected2:
                current2.append(x)

assert expected == current
assert expected2 == current2


# sprawdzanie wartosci (czy zwraca poprawny dzien oraz wartosci imion)
for key, value in data.items():
    for k, v in value.items():
        if k == 'namedays':
            for x, y in v.items():
                names = y
        else:
            for x, y in v.items():
                if x == 'day':
                    day_y = y
                    day_str = str(day_y)

assert day == day_str
assert day_y == 30
assert names == 'Feliks, Gerard, Maciej, Marcin, Martyna, Sebastian'
assert 'Maciej' in names  # sprawdzenie czy imie Maciej zawiera sie w zwracanych imionach


# sprawdzanie niepoprawnego zapytania (kod 404 - not found)
url = "https://api.abalin.net/nam?country={0}&month={1}&day={2}".format(country, month, day)  # zmiana endpointu z namedays na nam
response = requests.request("GET", url)
assert response.status_code == 404