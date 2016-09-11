#!/usr/bin/python3

import binascii

hex_string_1 = "1c0111001f010100061a024b53535009181c"
hex_string_2 = "686974207468652062756c6c277320657965"
byte_string_1 = binascii.unhexlify(hex_string_1) 
byte_string_2 = binascii.unhexlify(hex_string_1)

print(byte_string_1[0:1])

def xor(byte1, byte2):

    encrypted = ''

    for k in range(len(byte_string_1)):
        encrypted += chr(int(byte_string_1[k],16) ^ int(byte_string_1[k],16))

    return encrypted


encrypted = xor(hex_string_1, hex_string_2)
print(encrypted)
