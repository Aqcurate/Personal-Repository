#!/usr/bin/python3

import sys

# Getting user input
def user_input():
    try:
        minimum = int(input("Please input the minimum for your range:\n> "))
        assert minimum > 0
        maximum = int(input("Please input the maximum for your range.\n> "))
        assert maximum > 0
        assert maximum > minimum
    except:
        print("Error: Invalid input(s)")
        sys.exit()

    return minimum, maximum

# Naive prime test
def is_prime(n):

    if n == 1: # 1 is not a prime
        return False
    elif n <= 3: # 2 and 3 are primes
        return True
    elif n % 2 == 0 or n % 3 == 0: # Numbers divisible by 2 and 3 are not primes
        return False

    i = 5 # Explained in loop below

    # Run only from 5 to the floor of sqrt(n) due to reflective property of factorization
    # EX: Factor of 20 is: 1, 2, 4, 5, 10, 20
    # If we checked if 20 is visible by 2, we don't need to check 10

    while i*i <= n:
        # All primes can be represented in the notation 6k-1 or 6k+1
        # Check divisible of n only by numbers 6k-1 or 6k+1
        # 6k + 5 is the same as 6k - 1 (property of modular arithmetic)
        # 6k + 7 is the same as 6k + 1 
        if n % i == 0 or n % (i+2) == 0: 
            return False
        i += 6

    return True

# Loops through the range given by user
def range_loop(minimum, maximum):
    for n in range(minimum, maximum+1):
        if is_prime(n):
            print(str(n) + " is prime.")
        else:
            # print(str(n) + " is not prime.\n") # Uncomment this out if you want to list non-primes.
            pass

# Main 
def main():
    minimum, maximum = user_input()
    range_loop(minimum, maximum)

main()


