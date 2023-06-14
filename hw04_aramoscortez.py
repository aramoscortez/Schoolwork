"""
Author      : Abby Ramos Cortez
Date        : 2022.10.04
Email       : aramoscortez@radford.edu
Assignment  : Lab 05
Version     : 0.1.0
Description : 

As a Highlander, I will conduct myself with honor and integrity at all times. I will not lie, cheat, or steal, nor
will I accept the actions of those who do. This program is solely my work, or proper attribution has been given to 
code that I did not write. If I am found to violate this policy, I realize I will receive an F for this course with 
no exceptions.
"""
import sys
import math

def mathComputation():
    print("""
    Input a math equation in the following format: 
    (number) (space) (operator) (space) (number) (space) (equal sign)
    ex: 2 + 6 =
    Operators you may use: +,-,*,/
    """)
    math_eq_ui = str(input("Enter in a math equation: ").strip())
    split_math_eq_ui = math_eq_ui.split(" ")
    if len(split_math_eq_ui) == 4:
        if split_math_eq_ui[1] == "+":
            ans = int(split_math_eq_ui[0])+int(split_math_eq_ui[2])
            print("Your answer is: {0}".format(ans))
        elif split_math_eq_ui[1] == "-":
            ans = int(split_math_eq_ui[0])-int(split_math_eq_ui[2])
            print("Your answer is: {0}".format(ans))
        elif split_math_eq_ui[1] == "*":
            ans = int(split_math_eq_ui[0])*int(split_math_eq_ui[2])
            print("Your answer is: {0}".format(ans))
        elif split_math_eq_ui[1] == "/":
            try:
                ans = int(split_math_eq_ui[0])/int(split_math_eq_ui[2])
                print("Your answer is: {0}".format(ans))
            except ZeroDivisionError:
                print("Error: You cannot divide by zero. The answer is undefined.")
        else:
            sys.exit("Invalid Input")
    else:
        sys.exit("Failed to input the math equation in the correct format.")


def convertToDecimal():
    ui= input("Please enter in binary string: ").strip()
    l = len(ui)
    exp,a,sum = l-1,0,0
    while a<l:
        v = int(ui[a])
        sum+=v*math.pow(2,exp)
        exp-=1
        a+=1
    print("answer is:",sum)

def convertToBinary():
    b,ans = "",""
    mess = int(input("Enter in a integer value?").strip())
    while mess>=1:
        b+=str(mess%2)
        mess = int(mess/2)
    print("answer is: ", str(b[::-1]))


def main():
    #=============================================================== Problem 1 ============================================================
    convertToDecimal()

    convertToBinary()
    #=============================================================== Problem 2 ============================================================
    mathComputation()



if __name__ == "__main__":
    main()
