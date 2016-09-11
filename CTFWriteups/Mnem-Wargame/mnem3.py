#!usr/bin/python3

import requests

URL = "http://mnem.us/cyberpdx/p2"
USER = "p2"

for k in range(10):
    PASS = k
    r = requests.get(URL, auth=(USER,PASS))
    if 'success' in r.text:
        print(r.text)
        break
