"""
Author      : Abby Ramos Cortez
Date        : 2022.11.13
Email       : aramoscortez@radford.edu
Assignment  : Homework 8
Version     : 0.1.0
Description : Print out some data 

As a Highlander, I will conduct myself with honor and integrity at all times. I will not lie, cheat, or steal, nor
will I accept the actions of those who do. This program is solely my work, or proper attribution has been given to 
code that I did not write. If I am found to violate this policy, I realize I will receive an F for this course with 
no exceptions.
"""
from datetime import datetime,timedelta


def bracketmatcher(data):
    brackets = '{[()}]'
    check = ''
    for i in data:
        if i in brackets:
            check += i
        else:
            pass
    open = '({['
    close = ')}]'
    map = dict(zip(open, close))
    check1 = []    
    for j in check:
        if j in open:
            check1.append(map[j])
        elif j in close:
            if not check1 or j != check1.pop():
                return 0
    print(check1)
    if not check1:
        return 1
    else:
        return 0

def timediff(times):
    times_lst_str = times.split(',')
    times_lst = []
    for i in times_lst_str:
        times_lst.append(datetime.strptime(i,'%I:%M %p'))
    sorted1 = sorted(times_lst)
    delta = [j-i for i, j in zip(sorted1[:-1], sorted1[1:])]
    lst_frst_diff = sorted1[-1]-sorted1[0]
    delta.append(timedelta(hours=24)-(lst_frst_diff))
    print('Shortest difference in minutes: ',(min(delta)).total_seconds()/60)


def main():
    #======================================================= Problem 1 ===============================================================
    print("""
    ======================================================================================================================
    BRACKET MATCHER: Type in a string that contains brackets (i.e., (),[],{}) to see if the brackets are correctly matched 
    and each one is accounted for. If they match/each one is accounted for, the program will return 1. 
    Otherwise, the program will return 0. You may type in letters, numbers, special characters, etc. 
    Try these examples:
    (coder)(byte)
    (c(oder))b(yte)
    """)
    ui1 = str(input('Enter in parens: ').strip())
    print(bracketmatcher(ui1))

    #======================================================= Problem 2 ===============================================================
    print("""
    ======================================================================================================================
    FIND TIME DIFFERENCE: Type in a list of different times to calculate the smallest difference
    in minutes between two of the two times in the list.
    Try these examples:
    02:10 PM,01:30 PM,10:30 AM,4:42 PM
    01:30 PM,04:40 AM,05:00 PM
    10:00 AM,11:45 PM,05:00 AM,12:01 AM
    NOTE: You must type the times in the following format: HH:MM AM/PM,HH:MM AM/PM, ...
    """)
    ui2 = str(input('Enter in a list of times (separated by commas) in the twelve hour format (HH:MM (AM/PM)): ').strip())
    timediff(ui2)



if __name__ == "__main__":
    main()
