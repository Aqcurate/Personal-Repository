#!/usr/bin/python3

import os, random, hashlib, sys, binascii

def sha256hash(salt=str(binascii.b2a_hex(os.urandom(12))).replace("'","").replace("b",""), password=None):
   
     password_hash = hashlib.sha256((salt+password).encode()).hexdigest()

     return salt, password_hash


def open_account(salt, username, password_hash):
    with open("account.txt", "a") as account:
        account.write(salt + "," + username + "," + password_hash + "\n")
        account.close()

def login(username, password):
    with open("account.txt", "r") as account:
        for line in account:
            if username in line:
                line_array = line.split(",")
                db_password_hash = line_array[2].replace("\n","")
                salt, password_hash = sha256hash(line_array[0], password)
                if db_password_hash ==  password_hash:
                    print("Login successful.")
                    return True
                else:
                    print("Login failed.")
                    return False
        print("Login failed.")
        return False
        account.close()

def main():
    try:
        menu = int(input("What do you want to do?\n1. Create an account\n2. Login\n> "))

        username = input("Please enter a username.\n> ")
        password = input("Please enter a password.\n> ")

        assert "," not in username
        assert "," not in password
        assert username is not ""
        assert password is not ""

        if menu is 1:
            salt, password_hash = sha256hash(password=password)
            open_account(salt, username, password_hash)
        
        elif menu is 2:
            if(login(username, password)):
                print("Good Job.")
            else:
                sys.exit()

    except SystemExit:
        print("Try Again.")
    except:
        print("Invalid input")

main()
