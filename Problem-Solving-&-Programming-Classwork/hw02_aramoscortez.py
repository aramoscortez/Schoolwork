"""
Author      : Abby Ramos Cortez
Date        : 2022.09.11
Email       : aramoscortez@radford.edu
Version     : 0.1.0
Assignment  : Homework 2
Description : 

As a Highlander, I will conduct myself with honor and integrity at all times. I will not lie, cheat, or steal, nor
will I accept the actions of those who do. This program is solely my work, or proper attribution has been given to 
code that I did not write. If I am found to violate this policy, I realize I will receive an F for this course with 
no exceptions.
"""
import math
import sys

def distance_formula(x1, y1, x2, y2):
    d = math.sqrt((x2 - x1)**2 + (y2 - y1)**2)
    return d

def change(amount):
    if amount > 0:
        five_dollar = print("Five Dollars Bills: ",str(amount // 5.00))
        amount = amount%5.00
        one_dollar = print("One Dollar Bills:",amount // 1.00)
        amount = amount%1.00
        quarters = print("Quarters:",amount // 0.25)
        amount = amount%0.25
        dimes = print("Dimes: ",amount // 0.10)
        amount = amount%0.10
        nickels = print("Nickels: ",amount // 0.05)
        amount = amount%0.05
        pennies = print("Pennies:",amount // 0.01+1)
        amount = amount%0.01
    else:
        print("Invalid Input")

def main():
    print("""
    1) Distance Formula
    2) Coin Change
    3) Quit
    """)
    choice = str(input("Which option would you like to choose? Type in the option number to select(1-2). Otherwise, type 3 to quit. ").strip())
    while choice!= "3":
        if choice == "1":
            x1_ui = float(input("What is x1?").strip())
            y1_ui = float(input("What is y1?").strip())
            x2_ui = float(input("What is x2?").strip())
            y2_ui = float(input("What is y2?").strip())
            print("The distance is equal to ",distance_formula(x1_ui, y1_ui, x2_ui, y2_ui))
            break
        
        elif choice == "2":
            ui_dollar_amount = float(input("Input the dollar amount:"))
            change(ui_dollar_amount)
            break
            
        else:
            sys.exit("Invalid Input")
    if choice == "3":
        sys.exit("Okay, thank you for using my program.")
    else:
        sys.exit()



if __name__ == "__main__":
    main()
