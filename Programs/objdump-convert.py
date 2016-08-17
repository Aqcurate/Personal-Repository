#!/usr/bin/python3

import array

#---#

file_input = "thor-objdump.txt"
file_output = "thor-lz.lz"

#---#

with open(file_input, "r") as input_file:
    for line in input_file:
        hexline = line[10:51]
        with open(file_output, "ab") as output_file:
            hexstring = hexline.replace(" ","")
            hexdata = bytearray.fromhex(hexstring)
            output_file.write(hexdata)
            output_file.close()
    input_file.close()

        
