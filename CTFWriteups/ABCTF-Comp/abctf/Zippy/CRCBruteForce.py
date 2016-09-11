#!/usr/bin/python3

import itertools,string,binascii,base64


def crc_dictionary():
    character_set = string.ascii_letters + string.digits + "+/="
    crc_dictionary = {}

    for k in itertools.product(list(character_set), repeat=4):
        possible_string = ''.join(k)
        possible_crc_int = binascii.crc32(bytes(possible_string,'UTF-8'))
        possible_crc_byte = possible_crc_int.to_bytes(4, byteorder='little')
        possible_crc_hex = binascii.hexlify(possible_crc_byte)
        crc_dictionary[possible_crc_hex] = possible_string
    
    return crc_dictionary

def crc_match(crc_dict):
    string = ""
    crc_dictionary = crc_dict

    for k in range(54):
        chunk = 'chunk' + str(k) + '.zip'
        f = open(chunk, 'rb')
        f.seek(14)
        chunk_crc = binascii.hexlify(f.read(4))
        f.close()

        if chunk_crc in crc_dictionary:
            string += crc_dictionary[chunk_crc]

    return string

def file_write(file_data):
    data = base64.b64decode(file_data)
    f = open('flag.zip', 'wb')
    f.write(data)
    f.close()

def main():
    print("Generating a dictionary of all CRCs\n")
    crc_dict = crc_dictionary()
    print("Dictionary generated. Proceeding to next step.\n")

    print("Matching dictionary with files\n")
    file_data = crc_match(crc_dict)
    print("The data is: " + str(file_data) + "\n")
    print("Matching complete. Proceeding to next step.\n")

    print("Outputing data into flag.zip\n")
    file_write(file_data)
    print("Writing complete.\n")


main()
