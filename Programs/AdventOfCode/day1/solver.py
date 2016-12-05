#!/usr/bin/python3

def parse_input():
    return open("input.txt").read().rstrip('\n').replace(' ','').split(",")

def count_blocks(directions):
    blocks = [0,0,0,0]
    face = 0
    x = 0

    for k in directions:
        if 'R' in k:
            x += 1
        elif 'L' in k:
            x -= 1
        
        face = x % 4
        blocks[face] += int(k[1:])
        
    return blocks

def net_sum(blocks):
    return abs(blocks[0]-blocks[2])+abs(blocks[1]-blocks[3])

def main():
    directions = parse_input()
    blocks = count_blocks(directions)
    print(net_sum(blocks))

main()
    
