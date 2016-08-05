#!/usr/bin/python3

import sys

def force_calculation():
    mass = float(input("What is the mass of the object?\n> "))
    acceleration = float(input("What is the acceleration of the object?\n> "))

    force = mass * acceleration

    return force

def mass_calculation():
    force = float(input("What is the force of the object?\n> "))
    acceleration = float(input("What is the acceleration of the object?\n> "))

    mass = force / acceleration

    return mass

def acceleration_calculation():
    force = float(input("What is the force of the object?\n> "))
    mass = float(input("What is the mass of the object?\n> "))

    acceleration = force / mass

    return acceleration

def main():
    try:
        menu = int(input("What do you want to calculate?\n1. Force\n2. Mass\n3. Acceleration\n> "))
        assert menu < 4 and menu > 0

        if menu is 1:
            print("The force is " + str(force_calculation()))
        elif menu is 2:
            print("The mass is " + str(mass_calculation()))
        elif menu is 3:
            print("The acceleration is " + str(mass_calculation()))
        elif menu is 4:
            print("Goodbye")
    except:
        print("Invalid input")
        sys.exit()

main()


