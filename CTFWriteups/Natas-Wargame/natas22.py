#!usr/bin/python

import requests

URL = "http://natas22.natas.labs.overthewire.org/index.php?revelio=true"
USER = "natas22"
PASS = "chG9fbe1Tq2eWVMgjYYD1MsfIvN461kJ"

r = requests.get(URL, auth=(USER,PASS), allow_redirects=False)
print(r.text)

