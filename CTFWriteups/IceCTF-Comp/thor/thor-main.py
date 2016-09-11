#!/usr/bin/python3

import array

with open("thor-objdump.txt", "r") as thor:
    for line in thor:
        hexline = line[10:51]
        with open("thor-lz.lz", "ab") as thorhex:
            hexstring = hexline.replace(" ","")
            hexdata = bytearray.fromhex(hexstring)
            thorhex.write(hexdata)
            thorhex.close()
    thor.close()

        
