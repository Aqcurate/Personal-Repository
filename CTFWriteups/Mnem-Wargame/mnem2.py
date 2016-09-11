#!usr/bin/python3

import requests

URL = "http://mnem.us/cyberpdx/p1"
USER = "p1"
PASS = "6"

r = requests.get(URL, auth=(USER,PASS))
print(r.text)
