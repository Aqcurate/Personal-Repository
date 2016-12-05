#!/usr/bin/python3

import hashlib

def main():
    doorid = "reyedfim"
    password = ['0','0','0','0','0','0','0','0']
    index = 0
    used_password_index = []
    while len(used_password_index) != 8:
        hashed_string = hashlib.md5((doorid+str(index)).encode('utf-8')).hexdigest()
        if hashed_string[:5] == "00000":
            if (hashed_string[5].isdigit()) and (0 <= int(hashed_string[5]) <= 7) and (hashed_string[5] not in used_password_index):
                password[int(hashed_string[5])] = hashed_string[6]
                used_password_index.append(hashed_string[5])
        index+=1

    print(''.join(password))

main()
