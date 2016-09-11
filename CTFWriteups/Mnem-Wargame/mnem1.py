#!usr/bin/python3

import requests

URL = "http://mnem.us/cyberpdx/p0"
USER = "p0"
PASS = "p0"

r = requests.get(URL, auth=(USER,PASS))
print(r.text)
