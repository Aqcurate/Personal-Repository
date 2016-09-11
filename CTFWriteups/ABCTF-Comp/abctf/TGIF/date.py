#!/usr/bin/python

from datetime import date
from dateutil import parser

# Add year function
def add_years(dates, years):
    try:
        # Adds a year
        return dates.replace(year = dates.year + years)
    except ValueError:
        # Adds a year and day if it errors (Feb 29)
        return dates + (date(dates.year + years, 1 , 1) - date(dates.year, 1, 1))

# Calculate fridays function
def fridays():
    fridays = 0

    with open("date.txt","r") as dates:
        for line in dates:
            date = parser.parse(line)
            nextyr = add_years(date, 1)
            day = nextyr.weekday()
            if day == 4:
                fridays += 1
        return fridays

def main():
    print(fridays())

main()

