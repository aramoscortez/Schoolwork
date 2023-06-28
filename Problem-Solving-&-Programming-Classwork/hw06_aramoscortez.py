"""
Author      : Abby Ramos Cortez
Date        : 2022.10.31
Email       : aramoscortez@radford.edu
Assignment  : Homework 06
Version     : 0.1.0
Description : Print out some data 

As a Highlander, I will conduct myself with honor and integrity at all times. I will not lie, cheat, or steal, nor
will I accept the actions of those who do. This program is solely my work, or proper attribution has been given to 
code that I did not write. If I am found to violate this policy, I realize I will receive an F for this course with 
no exceptions.
"""
import json

def ibm1():
    print("Parsing Finance Data(IBM)")
    with open('ibm.json') as f:
        data = json.load(f)
    q1 = data['dataset']['data']
    price_lst = []
    for i in q1:
        price_lst.append(i[4])
    max_price = max(price_lst)
    print('The highest price by the end of the month for ibm is {0}'.format(max_price))


def ibm2():
    with open('ibm.json') as f:
        data = json.load(f)
    q1 = data['dataset']['data']

    open_lst = []
    for i in q1:
        open_lst.append(i[1])
    avg_open_lst = sum(open_lst)/len(open_lst)
    print('The average opening for ibm is {0}'.format(avg_open_lst))
    #===================================================================================================================================
    close_lst = []
    for i in q1:
        close_lst.append(i[4])
    avg_close_lst = sum(close_lst)/len(close_lst)
    print('The average closing for ibm is {0}'.format(avg_close_lst))

def fb1():
    print("\nParsing Finance Data(FB)")
    with open('fb.json') as f:
        data = json.load(f)
    q1 = data['dataset']['data']
    price_lst = []
    for i in q1:
        price_lst.append(i[4])
    max_price = max(price_lst)
    print('The highest price by the end of the month for fb is {0}'.format(max_price))

def fb2():
    with open('fb.json') as f:
        data = json.load(f)
    q1 = data['dataset']['data']

    open_lst = []
    for i in q1:
        open_lst.append(i[1])
    avg_open_lst = sum(open_lst)/len(open_lst)
    print('The average opening for fb is {0}'.format(avg_open_lst))
    #===================================================================================================================================
    close_lst = []
    for i in q1:
        close_lst.append(i[4])
    avg_close_lst = sum(close_lst)/len(close_lst)
    print('The average closing for fb is {0}'.format(avg_close_lst))


def main():
    ibm1()
    ibm2()
    fb1()
    fb2()



if __name__ == "__main__":
    main()
