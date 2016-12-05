#!/usr/bin/python3

import operator
import collections

def parse_input():
    return open("input.txt").read().rstrip("\n").split("\n")

def get_sector_id(x):
    return int(''.join(element for element in x if element.isdigit()))


def caeser_shift(message, shift):
    cipher = message.upper()
    output = ""
    shift = shift%26

    for char in range(len(cipher)):
        dec = ord(cipher[char])

        if 64 < dec < 91:
            if (dec + shift) > 64:
                if (dec + shift) < 91:
                    output += chr(dec + shift)
                else:
                    output += chr(dec + shift - 26)
            else:
                output += chr(dec + shift + 26)
        elif dec == 45:
            output += " "
        else:
            output += chr(dec)

    return output

def print_reals(rooms):    
    id_sum = 0

    for room in rooms:
        encrypted_name = ''.join(filter(str.isalpha, room[:-7]))
        counts = collections.Counter(encrypted_name)
        sorted_counts = sorted(counts, key=lambda letter: (-counts[letter], letter))

        if room[-6:-1] == ''.join(sorted_counts[0:5]):
                print(caeser_shift(room[:-7], get_sector_id(room)))

def main():
    rooms = parse_input()
    print_reals(rooms)

main()

# python3 solver2.py | grep OBJECT    
