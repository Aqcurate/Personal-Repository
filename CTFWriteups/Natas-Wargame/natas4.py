#!usr/bin/python

import requests

URL = "http://natas4.natas.labs.overthewire.org/"
USER = "natas4"
PASS = "Z9tkRkWmpt9Qr7XrR5jWRkgOU901swEZ"
HEADER = {'referer':'http://natas5.natas.labs.overthewire.org/'}
s = requests.session()
s.headers.update(HEADER)

r = s.get(URL, auth=(USER,PASS))
print(r.text)
