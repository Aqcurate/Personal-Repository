#!/usr/bin/python3

import string, hashlib, sys

first_char = string.ascii_uppercase
second_char = string.ascii_lowercase
third_char = string.digits
fourth_char = string.digits
fifth_char = "?%$@#^*()[];:"
real_hash = "c7e83c01ed3ef54812673569b2d79c4e1f6554ffeb27706e98c067de9ab12d1a"

test_pass = ['a','a','a','a','a']

for i in first_char:
    test_pass[0] = i
    for j in second_char:
        test_pass[1] = j
        for k in third_char:
            test_pass[2] = k
            for l in fourth_char:
                test_pass[3] = l
                for m in fifth_char:
                    test_pass[4] = m
                    test_string = ''.join(test_pass)
                    test_sha256 = hashlib.sha256(test_string.encode()).hexdigest()

                    if test_sha256 == real_hash:
                        print(test_string)
                        sys.exit()
                    


