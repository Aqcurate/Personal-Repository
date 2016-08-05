#!/usr/bin/python3

def get_input():
    name = input("What is your name?\n> ") 
    age = input("What is your age?\n> ")
    username = input("What is your username?\n> ")

    return name, age, username

def main():
    name, age, username = get_input()
    print("Your name is " + name + ", you are " + age + " years old, and your username is " + username + ".")

main()
