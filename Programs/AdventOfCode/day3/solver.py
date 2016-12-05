#!/usr/bin/python3

def parse_input():
    sentences = open("input.txt").read().rstrip("\n").split("\n")
    return [x.strip(" ") for x in sentences]

def count_possible(triangles):

    possible = 0

    for triangle in triangles:
        sorted_triangle = sorted(list(map(int, triangle.split())))
        if sorted_triangle[0]+sorted_triangle[1] > sorted_triangle[2]:
            possible += 1

    return possible

def main():
    triangles = parse_input()
    print(count_possible(triangles))

main()


