#!/usr/bin/python3

def parse_input():
    return open("input.txt").read().rstrip("\n").split("\n")

def decode_instructions(instructions, start_position):
    pin = ""
    position = start_position

    for instruction in instructions:
        for k in instruction:
            if 'U' in k:
                if position not in [1, 2, 4, 5, 9]:
                    if position in [3, 13]:
                        position -= 2
                    else:
                        position -= 4
            elif 'D' in k:
                if position not in [5, 9, 10, 12, 13]:
                    if position in [1, 11]:
                        position += 2
                    else:
                        position += 4
            elif 'L' in k:
                if position not in [1, 2, 5, 10, 13]:
                    position -= 1
            elif 'R' in k:
                if position not in [1, 4, 9, 12, 13]:
                    position += 1
        
        pin += str(format(position,'x'))

    return pin

def main():
    instructions = parse_input()
    print(decode_instructions(instructions, 5))

main()

