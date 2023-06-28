"""
Author      : Abby Ramos Cortez
Date        : 2022.10.17
Email       : aramoscortez@radford.edu
Assignment  : Homework 5
Version     : 0.1.0
Description :  

As a Highlander, I will conduct myself with honor and integrity at all times. I will not lie, cheat, or steal, nor
will I accept the actions of those who do. This program is solely my work, or proper attribution has been given to 
code that I did not write. If I am found to violate this policy, I realize I will receive an F for this course with 
no exceptions.
"""
import sys
morse_code = {
    'A':'.-', 'B':'-...',
    'C':'-.-.', 'D':'-..', 'E':'.','F':'..-.', 'G':'--.', 'H':'....',
    'I':'..', 'J':'.---', 'K':'-.-','L':'.-..', 'M':'--', 'N':'-.',
    'O':'---', 'P':'.--.', 'Q':'--.-','R':'.-.', 'S':'...', 'T':'-',
    'U':'..-', 'V':'...-', 'W':'.--','X':'-..-', 'Y':'-.--', 'Z':'--..',
    '1':'.----', '2':'..---', '3':'...--','4':'....-', '5':'.....', '6':'-....',
    '7':'--...', '8':'---..', '9':'----.','0':'-----', ', ':'--..--', '.':'.-.-.-',
    '?':'..--..', '/':'-..-.', '-':'-....-','(':'-.--.', ')':'-.--.-'
    }
def EN2MC():
    phrase_ui = str(input("Enter Phrase: ").strip().upper())
    output = ''
    for i in phrase_ui:
        if i != ' ':
            output += morse_code[i] + ' '
        else:
            output += '|'
    return output
    
def MC2EN():
    mc_phrase_ui = str(input("Enter Morse Code: ").strip())
    mc_phrase_ui += ' ';output = '';citext = ''
    for i in mc_phrase_ui:
        if (i != ' '):
            j = 0
            citext += i
        else:
            j += 1
            if j == 2:
                output += ' '
            else:
                output += list(morse_code.keys())[list(morse_code.values()).index(citext)]
                citext = ''
    return output

def menu():
    print("""
    Menu:
    1) English to Morse Code
    2) Morse Code to English
    3) Quit
    """)    

def main():
    menu()
    choice = int(input("Enter in the number of the option: ").strip())
    while choice != 3:
        if choice == 1:
            print("Morse Code is: ",EN2MC())
            menu()
            choice = int(input("Enter in the number of the option: ").strip())
        elif choice == 2:
            print("English phrase is: ",MC2EN())
            menu()
            choice = int(input("Enter in the number of the option: ").strip())
        else:
            sys.exit("Invalid Input")
        continue
    if choice == 3:
        sys.exit("Okay thank you for using my program! :)")



if __name__ == "__main__":
    main()
