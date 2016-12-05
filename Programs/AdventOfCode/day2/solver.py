#!/usr/bin/python3

def parse_input():
    return open("input.txt").read().rstrip("\n").split("\n")

def decode_instructions(instructions, start_position):
    pin = ""
    position = start_position

    for instruction in instructions:
        for k in instruction:
            if 'U' in k:
                if position not in [1, 2, 3]:
                    position -= 3
            elif 'D' in k:
                if position not in [7, 8, 9]:
                    position += 3
            elif 'L' in k:
                if position not in [1, 4, 7]:
                    position -= 1
            elif 'R' in k:
                if position not in [3, 6, 9]:
                    position += 1

        pin += str(position)

    return pin

def main():
    instructions = parse_input()
    print(decode_instructions(instructions, 5))

main()

