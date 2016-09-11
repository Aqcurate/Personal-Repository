#!/usr/bin/python3

import string, sys

def ceaser_shift(shift, message):
    cipher = message.upper()
    output = ""

    # Iterate through characters
    for char in range(len(cipher)):
        dec = ord(cipher[char])
        # Check if it is a letter
        if 64 < dec < 91:
            # Check if it is still later after shifts
            # If it isn't, simply wrap around
            if (dec + shift) > 64:
                if (dec + shift) < 91:
                    output += chr(dec + shift)
                else: 
                    output += chr(dec + shift - 26)
            else:
                output += chr(dec + shift + 26)
        else:
            output += chr(dec)

    return output

def main():

    try:
        menu = int(input("Do you want to encrypt or decrypt?\n1. Encrypt\n2. Decrypt\n> "))
        assert menu > 0 and menu < 3
        message = input("Enter the message\n> ")
        shift = int(input("Enter the shift\n> "))

        # Making shift negative for decrypt
        if menu is 2:
            shift *= -1

        output = ceaser_shift(shift, message)

        print("The output is " + output)

    except:
        print("Invalid input")
        sys.exit()

main()
