#!/usr/bin/python3

# L33T H4CK1NG SCR1PTZ

import random, string, time, shutil, signal, sys, os

def signal_handler(signal, frame):

    os.system('clear')
    columns, rows = os_size()

    print('\n' * round(rows/3))
    print(text_color(('*' * columns),'BLACK') * 3)

    end_string = '   H 4 C K 1 N G    C 0 M P L 3 T 3   '
    diff = columns - len(end_string)
    
    print(text_color(('*' * round(diff/2)), 'BLACK') + text_color(end_string, 'RED') + text_color(('*' * round(diff/2)),'BLACK'))
    print(text_color(('*' * columns), 'BLACK') * 3)

    print('\n' * round(rows/4))

    time.sleep(5)

    os.system('clear')

    sys.exit(0)

def text_color(string,color):

    ansi = {
        'BLACK':'\033[30m',
        'RED':'\033[31m',
        'GREEN':'\033[32m',
        'YELLOW':'\033[33m',
        'BLUE':'\033[34m',
        'PURPLE':'\033[35m',
        'CYAN':'\033[36m',
        'WHITE':'\033[37m'
    }

    ansi_end = '{}\033[00m'

    return (ansi[color]+ansi_end) .format(string)

def padding(large_string, small_string):

    if len(large_string) > len(small_string):
        difference = len(large_string) - len(small_string)
        padding = ''.join(random.choice(('0','1')) for i in range(difference))
    else:
        padding = ''

    return padding

def string_replacement(original_string, replaced_string, color, replacement):
    padding_for_replacement = padding(replaced_string, replacement)
    colored_text = text_color(replacement, color)
    padded_replacement = padding_for_replacement + colored_text
    new_string = original_string.replace(replaced_string, padded_replacement)

    return new_string

def randombinary(length):
    random_binary = ''.join(random.choice(('0','1')) for i in range(length))

    random_binary = string_replacement(random_binary, '00000000', 'RED', 'VIRUS')
    random_binary = string_replacement(random_binary, '11111111', 'RED', 'TROJAN')
    random_binary = string_replacement(random_binary, '10101010', 'GREEN', 'P4SSW0RD')

    return random_binary

def os_size():
    columns, rows = shutil.get_terminal_size()

    return columns, rows

def main():
    os.system('clear')
    while(True):
        columns, rows = os_size()
        print(randombinary(columns))
        time.sleep(.25)
        signal.signal(signal.SIGINT, signal_handler)

main()
