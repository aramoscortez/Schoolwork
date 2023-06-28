"""

Author      : Abby Ramos Cortez
Date        : 2022.08.26
Email       : aramoscortez@radford.edu
Version     : 0.1.0
Assignment  : Homework 01
Description : 

"""

import sys

def main():
    print('''
    Choose one of the Following item for conversions? 
    1: USD to EURO  
    2: EURO to USD  
    3: USD to JPN 
    4: JPN to USD  ''')

    choice = str(input("Which selection would you like to choose? ").strip())
    print('''Company A charges 15%, while Company B charges a $30 flat fee for conversion.''')

    if choice == "1":
        ui_1 = str(input("Type in A for Company A or B for Company B: "))
        if ui_1 == "A":
            usd_1 = float(input("Type in USD amount: "))
            euro_1 = (usd_1*.8817)+.15*(usd_1*.8817)
            print("It is €",round(euro_1,1))
        elif ui_1 == "B":
            usd_2 = float(input("Type in USD amount: "))
            euro_2 = (usd_2*.8817)+30
            print("It is €",round(euro_2,1))
        else:
            print("Wrong Input")

    elif choice == "2":
        ui_2 = str(input("Type in A for Company A or B for Company B: "))
        if ui_2 == "A":
            euro_3 = float(input("Type in the Euro amount: "))
            usd_3 = (euro_3/.8817)+.15*(euro_3/.8817)
            print("It is €",round(usd_3,1))
        elif ui_2 == "B":
            euro_4 = float(input("Type in the Euro amount: "))
            usd_4 = (euro_4/.8817)+30
            print("It is €",round(usd_4,1))
        else:
            print("Wrong Input")
        
    elif choice == "3":
        ui_3 = str(input("Type in A for Company A or B for Company B: "))
        if ui_3 == "A":
            usd_5 = float(input("Type in the USD amount: "))
            jap_1 = (usd_5*109.556)+.15*(usd_5*109.556)
            print("It is ¥",round(jap_1,1))
        elif ui_3 == "B":
            usd_6 = float(input("Type in the USD amount: "))
            jap_2 = (usd_6*109.556)+30
            print("It is ¥",round(jap_2,1))
        else:
            print("Wrong Input")

    elif choice == "4":
        ui_4 = str(input("Type in A for Company A or B for Company B: "))
        if ui_4 == "A":
            jap_3 = float(input("Type in the Yen amount: "))
            usd_7 = (jap_3/109.556)+.15*(jap_3/109.556)
            print("It is ¥",round(usd_7,1))
        elif ui_4 == "B":
            jap_4 = float(input("Type in the Yen amount: "))
            usd_8 = (jap_4/109.556)+30
            print("It is ¥",round(usd_8,1))
        else:
            print("Wrong Input")
    else:
        print("There are not other cases")
        sys.exit(0)
        


if __name__ == "__main__":
    main()
