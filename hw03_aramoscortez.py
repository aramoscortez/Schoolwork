"""
Author      : Abby Ramos Cortez
Date        : 2022.09.28
Email       : aramoscortez@radford.edu
Assignment  : Homework 3 - Bank
Version     : 0.1.0
Description : Bank Simulation/Password Generator 

As a Highlander, I will conduct myself with honor and integrity at all times. I will not lie, cheat, or steal, nor
will I accept the actions of those who do. This program is solely my work, or proper attribution has been given to 
code that I did not write. If I am found to violate this policy, I realize I will receive an F for this course with 
no exceptions.
"""
import sys
import random
import string

def password_generator(length, lowercase, uppercase, digits, special_characters, num_of_passwords,total_chars):
    if length>=6 and length<=20:
        if length == total_chars:
            special_characters1 = '!@#$%^&*?()<>/\|'
            lower_letters = string.ascii_lowercase
            upper_letters = string.ascii_uppercase
            digits1 = string.digits
            for i in range(1,num_of_passwords+1):
                password = []
                for j in range(lowercase):
                    password.append(random.choice(lower_letters))
                for k in range(uppercase):
                    password.append(random.choice(upper_letters))
                for l in range(digits):
                    password.append(random.choice(digits1))
                for m in range(special_characters):
                    password.append(random.choice(special_characters1))
                shuffle = random.shuffle(password)
                list_to_str = ''.join(password)
                print("Password #{0}: {1}\n".format(i,list_to_str))
        elif length != total_chars:
            sys.exit("Error: The length you entered and the sum of characters do not match. Make sure they match.")
        else:
            sys.exit()
    elif length<6:
        sys.exit("Password length is less than 6. Input a number between 6 and 20.")
    elif length>20:
        sys.exit("Password length is greater than 20. Input a number between 6 and 20.")
    else: 
        sys.exit("Invalid Input")

def main():
    #=============================================================== Task 1 ============================================================
    print('''
    BANK ACCOUNT OPERATIONS:
    1. Deposit money into Savings Account
    2. Withdraw money from Savings Account
    3. Check balance on Savings Account
    4. Quit
    ''')

    choice = int(input("Type in the number of the choice(1-4): ").strip())
    while choice != 4:
        acctnum_ui = int(input("What is your Account Number? ").strip())
        password = str(input("What is your password? ").strip())
        acct_password = "Password1234"
        acctnum = 12450009
        checking_acct_bal = 500
        savings_acct_bal = 200
        if acctnum_ui == acctnum and password == acct_password:
            if choice == 1:
                dep_ui = float(input("How much money would you like to deposit into your savings account? $").strip())
                savings_acct_bal = dep_ui+savings_acct_bal
                print("Success, you now have ${0} in your savings account.".format(savings_acct_bal))
                print('''
                BANK ACCOUNT OPERATIONS:
                1. Deposit money into Savings Account
                2. Withdraw money from Savings Account
                3. Check balance on Savings Account
                4. Quit
                ''')
                choice = int(input("Type in the number of the choice(1-4): ").strip())
            elif choice == 2:
                withdraw_ui = float(input("How much money would you like to withdraw? $").strip())
                if withdraw_ui<=savings_acct_bal and withdraw_ui>0:
                    savings_acct_bal = savings_acct_bal - withdraw_ui
                    print("Success, you now have ${0} in your savings account.".format(savings_acct_bal))
                    print('''
                    BANK ACCOUNT OPERATIONS:
                    1. Deposit money into Savings Account
                    2. Withdraw money from Savings Account
                    3. Check balance on Savings Account
                    4. Quit
                    ''')
                    choice = int(input("Type in the number of the choice(1-4): ").strip())
                elif withdraw_ui>savings_acct_bal:
                    sys.exit("The amount entered exceeds the amount available({0})".format(savings_acct_bal))
                else:
                    sys.exit("Invalid Input")
            elif choice == 3:
                print("Savings Account = ${0}".format(savings_acct_bal))
                print('''
                BANK ACCOUNT OPERATIONS:
                1. Deposit money into Savings Account
                2. Withdraw money from Savings Account
                3. Check balance on Savings Account
                4. Quit
                ''')
                choice = int(input("Type in the number of the choice(1-4): ").strip())
            else:
                sys.exit("Invalid Input")
        elif acctnum_ui != acctnum and password == acct_password:
            sys.exit("Your account number is incorrect.")
        elif acctnum_ui == acctnum and password != acct_password:
            sys.exit("Your password is incorrect.")
        elif acctnum_ui != acctnum and password != acct_password:
            sys.exit("Your account number and password are incorrect.")
        else:
            sys.exit("Invalid Input")
        continue
    
    if choice == 4:
        messages = ["Until tomorrow!","Until next time!","Farewell!","Have a great day or night!", "Thank you for banking with us!"]
        print('''
        Account {0}
        Balance: ${1}
        {2}
        '''.format(acctnum_ui,savings_acct_bal,random.choice(messages)))
    else:
        sys.exit("Invalid Input")

    #=============================================================== Task 2 ============================================================
    print('''
    To generate a random password:
    1) type in the length of the pasword (must be between 6 and 20)
    2) type in the amount of lowercase letters (must type in a number greater than or equal to two)
    3) type in the amount of uppercase letters (must type in a number greater than or equal to two)
    4) type in the amount of digits (must type in a number greater than or equal to one)
    5) type in the amount of special characters (must type in a number greater than or equal to one)
    
    NOTE: The amount of lowercase letters, uppercase letters, digits and special characters must add up to the length of the password.
    ''')

    length_of_input = int(input("How long would you like the password to be? Input must be between 6 and 20 characters. ").strip())
    lowercase_letters = int(input("How many lowercase letters would you like the password to have? ").strip())
    a = length_of_input - lowercase_letters
    print("You have {0} remaining characters. ".format(a))
    uppercase_letters = int(input("How many uppercase letters would you like the password to have? ").strip())
    b = a - uppercase_letters
    print("NOTE: You have {0} remaining characters. ".format(b))
    digits = int(input("How many digits would you like the password to have? ").strip())
    c = b - digits
    print("NOTE: You have {0} remaining characters. ".format(c))
    special_characters = int(input("How many special characters would you like the password to have? ").strip())
    d = c - special_characters
    print("NOTE: You have {0} remaining characters. ".format(d))
    total_chars = lowercase_letters+uppercase_letters+digits+special_characters
    num_of_passwords = int(input("How many different passwords would you like to have? Choose a number between 1 and 5. ").strip())
    password_generator(length_of_input,lowercase_letters,uppercase_letters,digits,special_characters,num_of_passwords,total_chars)



if __name__ == "__main__":
    main()
