#!/usr/bin/python3

import operator
import collections

def parse_input():
    return open("input.txt").read().rstrip("\n").split("\n")

def get_sector_id(x):
    return int(''.join(element for element in x if element.isdigit()))

def check_real(rooms):    
    id_sum = 0

    for room in rooms:
        encrypted_name = ''.join(filter(str.isalpha, room[:-7]))
        counts = collections.Counter(encrypted_name)
        sorted_counts = sorted(counts, key=lambda letter: (-counts[letter], letter))

        if room[-6:-1] == ''.join(sorted_counts[0:5]):
            id_sum += get_sector_id(room)

    return id_sum

def main():
    rooms = parse_input()
    print(check_real(rooms))

main()

    
