#!/usr/bin/python3

import random, string

def random_gen(length, amount):
    
    password_list = {}
    
    for k in range(amount):
        password_list[k] = ''.join(random.choice((string.ascii_letters+string.digits)) for n in range(length))

    return password_list

def main():
    
    try:
        length = int(input("How long of a password do you want to generate?\n> "))
        amount = int(input("How many passwords do you want to generate?\n> "))
        
        password_list = random_gen(length, amount)

        for k in range(amount):
            print(password_list[k])
        
    except:
        print("Invalid input")

main()
