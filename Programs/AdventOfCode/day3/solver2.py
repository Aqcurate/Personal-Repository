#!/usr/bin/python3

def parse_input():
    sentences = open("input.txt").read().rstrip("\n").split("\n")
    column_values = []
    for i in range(3):
        column_values += [x.split()[i] for x in sentences]

    for j in range(0, len(column_values), 3):
        yield column_values[j:j+3]

def count_possible(triangles):

    possible = 0

    for triangle in triangles:
        sorted_triangle = sorted(list(map(int, triangle)))
        if sorted_triangle[0]+sorted_triangle[1] > sorted_triangle[2]:
            possible += 1

    return possible

def main():
    triangles = parse_input()
    print(count_possible(triangles))

main()


