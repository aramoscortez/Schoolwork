/*
 * ITEC 120 - Assignment 9
 */

/**
 *  This class simulates playing the Dice Souls dice game. The Soul Reaver
 *  reaves souls, day-in and day-out, until it dies and becomes a soul to be
 *  reaved by another reaver. This is really pretty dark stuff.
 *
 * @author Jeffrey LaMarche
 *
 * @version 1.0 2022-04-10
 * Initial Template Version
 *
 * @author Abby Ramos Cortez
 *
 * @version 19.0.1 2023-04-19
 */

import java.util.Arrays;

public class DiceSouls  // yeah, this just got dark...
{
    /**
     * The main method for the Dice Souls game.
     *
     * @param args a reference to a String array for the command line arguments
     */
    public static void main(String[] args)
    {
        System.out.println();
        int size = 0;
        if (args.length == 1 && isStringPositiveInteger(args[0]) == true)
        {
            size = Integer.parseInt(args[0]);
        }
        else
        {
            size = 8;
        }
        Dice[] diceArray = createPlayerDice(size);
        int roundNumber = 0;
        int collectedSoulsThisRound = 0;
        int totalSoulsCollected = 0;
        boolean didPlayerSurvive = true; 
        while (didPlayerSurvive == true)
        {
            rollAllDice(diceArray);
            didPlayerSurvive = playerSurvives(diceArray);
            roundNumber++;
            System.out.printf("Round:   %d\n", roundNumber);
            System.out.println("--- Soul Reaver's Roll ---");
            displayDice(diceArray);
            System.out.println("--------------------------");
            collectedSoulsThisRound = collectedSouls(diceArray);
            totalSoulsCollected += collectedSoulsThisRound;
            playerSurvives(diceArray);
            System.out.printf("Souls Reaved: %d\n", collectedSoulsThisRound);
            System.out.printf("Total Souls Reaved: %d\n", totalSoulsCollected);
            System.out.println();
        }
        displayGameOver(roundNumber, totalSoulsCollected);
        System.out.println();
    }

    /** 
     * This method iterates through all of the Dice objects in the array, 
     * determining if they are all valid. For this program, a Dice object is 
     * considered valid if it is not null, has a valid number of sides, and a 
     * valid value number. If any individual Dice object is invalid, this 
     * method returns false.
     * 
     * @param dice An array of Dice objects
     * @return true if all dice objects are valid, false otherwise
     * 
    */
    public static boolean allDiceValid(Dice[] dice)
    {
        for (Dice die: dice)
        {
            if (die != null && die.isValidDice() == true) // the isValidDice()
            // method checks to see if both sides and values of the dice are valid
            {
                return true;
            }
        }
        return false;
    }

    /** 
     * This method adds a single Dice object into the Dice array at a specified
     * index position. If the index position is not valid, the dice array will 
     * not be modified. This method will overwrite anything already contained 
     * at an index, which includes changing an element to null. 
     * 
     * @param dice An array of Dice objects
     * @param die A Dice object 
     * @param position An integer representing a position/index that is either 
     * in the array indices or not
     * @return Returns true if the add operation was successful, false otherwise
    */
    public static boolean addDie(Dice[] dice, Dice die, int position)
    {
        if (position >= 0 && position < dice.length)
        {
            dice[position] = die; 
            return true;
        }
        return false;
    }

    /** 
     * This method rolls all of the Dice objects in the array. However, rolling
     * all of the Dice objectsonly occurs if every Dice object in the array is
     * valid.
     * 
     * @param dice An array of Dice objects
    */
    public static void rollAllDice(Dice[] dice)
    {
        if (allDiceValid(dice) == true)
        {
            for (Dice die: dice)
            {
                die.rollDice();
            }
        }
    }

    /** 
     * This method calculates the sum of all Dice object values in the array.
     * This operation only occurs if all of the objects in the array are valid.
     * If some of the Dice objects are invalid, the method will return zero.
     * 
     * @param dice An array of Dice objects
     * @return The sum of all values in the array if all dice objects are valid,
     * 0 otherwise
    */
    public static int sumDice(Dice[] dice)
    {
        int sum = 0;
        if (allDiceValid(dice) == true)
        {
            for (Dice die: dice)
            {
                sum += die.getValue();
            }
        }
        return sum;
    }

    /** 
     * This method counts the number of times a target value occurs in the Dice
     * array. This operation only occurs if all of the objects in the array are
     * valid. If some of the Dice objects are invalid, the method will return 
     * zero.
     * 
     * @param dice An array of Dice objects
     * @param target An integer that represents the target value to be counted
     * @return The number of times the value occurs in the Dice array
    */
    public static int countDiceValue(Dice[] dice, int target)
    {
        int countofTarget = 0;
        if (allDiceValid(dice) == true)
        {
            for (Dice die: dice)
            {
                if (die.getValue() == target)
                {
                    countofTarget++;
                }
            }
        }
        return countofTarget;
    }

    /** 
     * This method determines whether the player has survived to gather mice 
     * souls on another day. A player survives if they have at least one Dice 
     * object with the value four, two Dice objects with the value eight, or 
     * three Dice objects with the value three. These operations only occur if 
     * all of the objects in the array are valid. If some of the Dice objects 
     * are invalid, the method will return false.
     * 
     * @param dice An array of Dice objects 
     * @return true if the player survives, false otherwise
    */
    public static boolean playerSurvives(Dice[] dice)
    {
        int countOfFour = countDiceValue(dice, 4); // uses the countDiceValue()
        // method to determine how many times the value four appears in the array
        int countOfEight = countDiceValue(dice, 8);
        int countOfThree = countDiceValue(dice, 3);
        if (allDiceValid(dice) == true)
        {
            if (countOfFour >= 1 || countOfEight >= 2 || countOfThree >= 3) 
            {
                return true;
            }
        }
        return false;
    }

    /** 
     * This method determines the number of souls collected by the player 
     * (zero, if there are invalid Dice objects). The base amount of collected
     * souls is the sum of the Dice object values. There are two types of “bad”
     * souls that might be collected, which impact the total collected souls. 
     * There is a cat soul that has the value 13. For each cat soul rolled, 
     * that value is not included in the summation and also subtracted out two
     * more times. 
     * There is also a rat soul that has the value 6. This means 
     * that for each rat soul encountered, that value is not included in the 
     * total souls collected for that round (it is subtracted out).
     * 
     * @param dice An array of Dice objects 
     * @return returns the amount of collected souls which factors in the 
     * "bad" souls, returns 0 if the dices are not valid
    */
    public static int collectedSouls(Dice[] dice)
    {
        int soulsCount = 0;
        int twoTimes = 2;
        if (allDiceValid(dice) == true)
        {
            for (Dice die: dice)
            {
                if (die.getValue() == 13)
                {
                    soulsCount -= twoTimes * die.getValue();
                }
                else if (die.getValue() == 6)
                {
                    soulsCount = soulsCount; 
                }
                else
                {
                    soulsCount += die.getValue();
                }
            }
        }
        return soulsCount;
    }

    /** 
     * This method will display to standard output all of the Dice objects in 
     * the array with one object per line. Additionally, when there is a cat 
     * or rat soul encountered, this is additionally labeled next to the 
     * corresponding Dice toString value.
     * 
     * @param dice An array of Dice objects
    */
    public static void displayDice(Dice[] dice)
    {
        for (Dice die: dice)
        {
                if (die.getValue() == 13)
                {
                    System.out.println(die.toString() + " : cat soul");
                    /* The toString method for a Dice object will create and 
                    return a properly formatted String object with the 
                    label cat soul, rat soul, or nothing printed next to it. */
                }
                else if (die.getValue() == 6)
                {
                    System.out.println(die.toString() + " : rat soul");
                }
                else
                {
                    System.out.println(die.toString() + " :");
                }
        }
    }

    /** 
     * This method will display the game over screen when the player does not 
     * obtain the correct types of souls in a round (i.e., player did not 
     * survive). This screen displays game over messages and also displays some
     * end game statistics for the total number of rounds, the total number of 
     * collected souls, and the average number of collected souls per round 
     * (displayed to two decimal places). 
     * 
     * @param totalRounds An integer representing the amount of rounds the player
     * survived(i.e., total)
     * @param totalSouls An integer representing the total amount of souls the
     * player collected from each round
    */
    public static void displayGameOver(int totalRounds, int totalSouls)
    {
        System.out.println("--- GAME OVER ---");
        System.out.println();
        System.out.println("Your soul joins the pile to be reaved!");
        System.out.println();
        System.out.println("Final Game Stats");
        System.out.println("--------------------");
        System.out.printf("Total Rounds: %d\n", totalRounds);
        System.out.printf("Total Souls: %d\n", totalSouls);
        System.out.printf("Average Souls: %.2f\n", (float) totalSouls / 
            (float) totalRounds);
    }

    // ---- PROVIDED METHODS BELOW ---- //

    /**
     * Creates an array of Dice objects, with random sides for each dice
     *  selected from 4, 6, 8, 10, 12, or 20 sides.
     *
     * @param numberDice the number of Dice objects that the array can hold
     *
     * @return an array of Dice objects with length numberDice
     */
    public static Dice[] createPlayerDice(int numberDice)
    {
        Dice[] playerDice;

        /*
         * If the number of dice is not positive, setup an array with no
         *  elements that will be returned at the end.
         */
        if( numberDice < 0 )
        {
            playerDice = new Dice[0];
        }
        else
        {
            /*
             * Represents the valid number of sides for a Dice object. The first
             *  element is junk and never used. This makes mapping simpler.
             */
            final int[] SIDE_VALUES = { -1, 4, 6, 8, 10, 12, 20 };

            Dice d6 = new Dice();
            playerDice = new Dice[numberDice];
            int sides = 0;
            boolean addSuccess = false;

            /*
             * Hopefully the Dice validity test is correct.
             */
            if( d6.isValidDice() )
            {
                /*
                 * Iterate through the array of Dice, creating a new Dice object
                 *  for each element, having a random number of valid sides.
                 */
                for( int index = 0; index < playerDice.length; index++ )
                {
                    // Randomly select a value between 1 and 6 inclusive.
                    d6.rollDice();

                    // Get the value of the Dice object.
                    int diceValue = d6.getValue();

                    // Obtain the number of sides that the 1 to 6 maps to.
                    sides = SIDE_VALUES[diceValue];

                    // Add the new Dice object to the array of Dice.
                    addSuccess = addDie(playerDice, new Dice(sides), index);

                    /*
                     * If the Dice object was not added successfully,
                     *  stop execution.
                     */
                    if( !addSuccess )
                    {
                        System.err.println("ERROR: ");
                        System.err.println("addDie did not work correctly!");
                        System.err.println(" Program terminating...");
                        System.exit(1);
                    }
                }
            }
            else
            {
                System.err.println("ERROR: Dice is not valid!");
                System.err.println("Program terminating...");
                System.exit(1);
            }
        }

        return playerDice;
    }

    /**
     * Determines if a string is a positive integer value.
     *
     * @return true if the string is an integer greater or equal to zero,
     *         false otherwise
     */
    public static boolean isStringPositiveInteger(String str)
    {
        boolean isNumber = false;

        /*
         * A null or empty string cannot be positive.
         */
        if( str != null && str.length() > 0 )
        {
            isNumber = true;

            /*
             * Get each character out of a character array.
             */
            for( char ch : str.toCharArray() )
            {
                /*
                 * If the character is not a digit (i.e., 0 to 9), then
                 *  the string is not a positive integer value.
                 */
                if( !Character.isDigit(ch) )
                {
                    isNumber = false;
                }
            }
        }

        return isNumber;
    }
}
