#!/usr/bin/python3

import hashlib

def main():
    doorid = "reyedfim"
    password = ""
    index = 0
    while len(password) != 8:
        hashed_string = hashlib.md5((doorid+str(index)).encode('utf-8')).hexdigest()
        if hashed_string[:5] == "00000":
            print(hashed_string)
            password += hashed_string[5]
        index+=1

    print(password)

main()
