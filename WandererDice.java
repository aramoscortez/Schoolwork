/** 
* In this program, we are creating methods that serve different purposes and 
* invoking them in the main method and even within another method. We are also 
* making use of conditional expressions, conditional statements, and boolean 
* values(creating boolean methods as well). We are also adding Javadoc comments.
*
* @author Abby Ramos Cortez
*
* @version 19.0.1 2023-02-22
*
*/
import java.util.Random;

public class WandererDice
{
    /**
    * The main method, which runs the program when executed.
    *
    * @param args The command line arguments.
    */
    public static void main(String[] args)
    {
        System.out.println();
        System.out.println("----=== Wanderer Dice Status ===----");

        int die1 = rollDie();
        int die2 = rollDie();
        int die3 = rollDie();
        displayDice(die1, die2, die3);

        int countTwosAns = countTwos(die1, die2, die3);
        int countFoursAns = countFours(die1, die2, die3);
        int countEightsAns = countEights(die1, die2, die3);
        displayCounts(countTwosAns, countFoursAns, countEightsAns);

        int sumOfDice = sumDice(die1, die2, die3);
        displaySum(sumOfDice);

        boolean hordeDefeatedAns = hasFoughtOffHorde(die1, die2, die3);
        boolean hasFoundFoodAns = hasFoundFood(die1, die2, die3);
        boolean hasFoundShelterAns = hasFoundShelter(die1, die2, die3);
        boolean isInjuredAns = isInjured(die1, die2, die3);
        displayStates(hordeDefeatedAns, hasFoundFoodAns, hasFoundShelterAns, 
            isInjuredAns);
        
        boolean isAliveAns = isAlive(die1, die2, die3);
        boolean isDeadAns = isDead(die1, die2, die3);
        displayAliveDead(isAliveAns, isDeadAns);
    }

    /** 
    * To simulate rolling an eight-sided die, we use the random class in 
    * java.util.Random to generate a random number between 1-8(both inclusive).
    * 
    * @return returns an int representing the random die roll number
    */
    public static int rollDie()
    {
        Random randnum = new Random();
        int die = randnum.nextInt(8) + 1; // added one so the range is 1-8 not 0-7.
        return die;
    }

    /** 
    * Displays a table of three random numbers between 1 and 8 which represent 
    * the values of the three rolled dice.
    * 
    * @param die1 an int representing the first die roll number
    * @param die2 an int representing the second die roll number
    * @param die3 an int representing the third die roll number
    */
    public static void displayDice(int die1, int die2, int die3)
    {
        System.out.println();
        System.out.println("Rolled Dice");
        System.out.println("-------------------");
        System.out.printf("Die 1: %d\n", die1);
        System.out.printf("Die 2: %d\n", die2);
        System.out.printf("Die 3: %d", die3);
        System.out.println();
    }

    /** 
    * Displays a table thats lists out how many twos, fours, and eights that 
    * there are between the three rolled dice.
    *
    * @param count2 an int representing the number of twos upon rolling three dice
    * @param count4 an int representing the number of fours upon rolling three dice
    * @param count8 an int representing the number of eights upon rolling three dice
    */
    public static void displayCounts(int count2, int count4, int count8)
    {
        System.out.println();
        System.out.println("Dice Value Counts");
        System.out.println("-------------------");
        System.out.printf("2 Count: %d\n", count2);
        System.out.printf("4 Count: %d\n", count4);
        System.out.printf("8 Count: %d", count8);
        System.out.println();
    }

    /** 
    * Displays a table that displays various states that are based on the rolled 
    * dice.
    *
    * @param hordeDefeated a boolean indicating whether the horde was defeated or not
    * @param foodFound a boolean indicating whether the wanderer found food or not
    * @param shelterFound a boolean indicating whether the wanderer found shelter or not
    * @param haveInjuries a boolean indicating whether the wanderer has injuries or not
    */
    public static void displayStates(boolean hordeDefeated, boolean foodFound, 
        boolean shelterFound, boolean haveInjuries)
    {
        String horseDefeatedyn = translation(hordeDefeated); // translated from
        // true --> "Yes" or false --> "No". And assigned to a string variable.
        String foodFoundyn = translation(foodFound);
        String shelterFoundyn = translation(shelterFound);
        String haveInjuriesyn = translation(haveInjuries);

        System.out.println();
        System.out.println("Game States");
        System.out.println("-------------------");
        System.out.printf("Horde Defeated: %s\n", horseDefeatedyn);
        System.out.printf("    Food Found: %s\n", foodFoundyn);
        System.out.printf(" Shelter Found: %s\n", shelterFoundyn);
        System.out.printf(" Have Injuries: %s", haveInjuriesyn);
        System.out.println();
    }

    /** 
    * Displays the sum of the three dice that were rolled.
    *
    * @param sum the sum of the three dice that were rolled
    */
    public static void displaySum(int sum)
    {
        System.out.println();
        System.out.println("Dice Value Sum");
        System.out.println("-------------------");
        System.out.printf("Dice Sum: %d", sum);
        System.out.println();
    }

    /** 
    * Displays a table that indicates whether a player is alive or dead.
    *
    * @param alive a boolean indicating whether the player is alive or not
    * @param dead a boolean indicating whether the player is dead or not
    */
    public static void displayAliveDead(boolean alive, boolean dead)
    {
        String aliveyn = translation(alive);
        String deadyn = translation(dead);
        System.out.println();
        System.out.println("Alive or Dead Status");
        System.out.println("-------------------");
        System.out.printf("Alive: %2s\n", aliveyn);
        System.out.printf(" Dead: %3s\n", deadyn);
        System.out.println();
    }

    /** 
    * Translates boolean values (true/false) to string values ("Yes"/"No").
    *
    * @param nameOfBoolean a boolean variable with true/false values that 
    * will be translated to "Yes" or "No" (string value) using an if-else statement
    * @return a string value with "Yes" or "No" as an answer
    */
    public static String translation(boolean nameOfBoolean)
    {
        String nameOfBooleanyn;
        if (nameOfBoolean == true)
        {
            nameOfBooleanyn = "Yes";
            return nameOfBooleanyn;
        }
        else
        {
            nameOfBooleanyn = "No";
            return nameOfBooleanyn;
        }
    }

    /** 
    * Counts the number of twos that occur among the three dice
    * 
    * @param die1 an int representing the first die roll number
    * @param die2 an int representing the second die roll number
    * @param die3 an int representing the third die roll number
    * @return an int representing the total number of times the number of twos
    * occurs among the three die roll numbers
    */
    public static int countTwos(int die1, int die2, int die3)
    {
        int number = 2;
        int die1Count = counting(die1, number); // returns 0 if die1 is not equal
        // to number(2) or returns 1 if die1 is equal to number(2)
        int die2Count = counting(die2, number);
        int die3Count = counting(die3, number);
        int sumDieCounts = die1Count + die2Count + die3Count;
        return sumDieCounts;
    }

    /** 
    * Determines whether the random die number is the same as the given number
    * (2, 4, or 8). If it is, it increases the count by one increment. If not, 
    * the count stays at zero.
    * 
    * @param die an int that represents the random die number
    * @param number an int that represents the number we are trying to count
    * @return an int that returns either 0 (die did not match number) 
    * or 1 (die did match number)
    */
    public static int counting(int die, int number)
    {
        int count = 0;
        if (die == number)
        {
            count = count + 1;
            return count;
        }
        else 
        {
            count = count;
            return count;
        }
    }

    /** 
    * Counts the number of fours that occur among the three dice.
    * 
    * @param die1 an int representing the first die roll number
    * @param die2 an int representing the second die roll number
    * @param die3 an int representing the third die roll number
    * @return an int representing the total number of times the number of fours
    * occurs among the three die roll numbers
    */ 
    public static int countFours(int die1, int die2, int die3)
    {
        int number = 4;
        int die1Count = counting(die1, number);
        int die2Count = counting(die2, number);
        int die3Count = counting(die3, number);
        int sumDieCounts = die1Count + die2Count + die3Count;
        return sumDieCounts;
    }

    /** 
    * Counts the number of eights that occur among the three dice
    * 
    * @param die1 an int representing the first die roll number
    * @param die2 an int representing the second die roll number
    * @param die3 an int representing the third die roll number
    * @return an int representing the total number of times the number of eights
    * occurs among the three die roll numbers
    */
    public static int countEights(int die1, int die2, int die3)
    {
        int number = 8;
        int die1Count = counting(die1, number);
        int die2Count = counting(die2, number);
        int die3Count = counting(die3, number);
        int sumDieCounts = die1Count + die2Count + die3Count;
        return sumDieCounts;
    }

    /** 
    * Adds up the values of the three rolled dice
    * 
    * @param die1 an int representing the first die roll number
    * @param die2 an int representing the second die roll number
    * @param die3 an int representing the third die roll number
    * @return an int representing the sum of the three dice values
    */
    public static int sumDice(int die1, int die2, int die3)
    {
        int sumOfDice = die1 + die2 + die3;
        return sumOfDice;
    }

    /** 
    * Determines if the gopher horde has been successfully faught off. The horde
    * has been fought off if the values of the three dice contain a two, a four, 
    * and an eight value.
    * 
    * @param die1 an int representing the first die roll number
    * @param die2 an int representing the second die roll number
    * @param die3 an int representing the third die roll number
    * @return a boolean value indicating whether or not the wanderer has fought 
    * off the mutant gopher horde.
    */
    public static boolean hasFoughtOffHorde(int die1, int die2, int die3)
    {
        int countOf2 = countTwos(die1, die2, die3);
        int countOf4 = countFours(die1, die2, die3);
        int countOf8 = countEights(die1, die2, die3);
        if (countOf2 == 1 && countOf4 == 1 && countOf8 == 1)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    /** 
    * Determines if the wanderer has located food. Food is found if there is a
    * pair of twos, a pair of fours, or a pair of eights. 
    * 
    * @param die1 an int representing the first die roll number
    * @param die2 an int representing the second die roll number
    * @param die3 an int representing the third die roll number
    * @return a boolean value indicating whether or not the wanderer has found
    * food
    */
    public static boolean hasFoundFood(int die1, int die2, int die3)
    {
        int countOf2 = countTwos(die1, die2, die3);
        int countOf4 = countFours(die1, die2, die3);
        int countOf8 = countEights(die1, die2, die3);
        if (countOf2 == 2 || countOf4 == 2 || countOf8 == 2)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    /** 
    * Determines if the wanderer has found shelter. Shelter is found if there is at
    * least two values rolled that are the value two, four, or eight. 
    * 
    * @param die1 an int representing the first die roll number
    * @param die2 an int representing the second die roll number
    * @param die3 an int representing the third die roll number
    * @return a boolean value indicating whether or not the wanderer has found
    * shelter
    */
    public static boolean hasFoundShelter(int die1, int die2, int die3)
    {
        int countOf2 = countTwos(die1, die2, die3);
        int countOf4 = countFours(die1, die2, die3);
        int countOf8 = countEights(die1, die2, die3);
        int sumOfCount248 = countOf2 + countOf4 + countOf8;
        if (sumOfCount248 >= 2)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    /** 
    * Determines if the wanderer has been injured. Injuries occur when the total 
    * of the three dice is between seven and 13 (both inclusive).
    * 
    * @param die1 an int representing the first die roll number
    * @param die2 an int representing the second die roll number
    * @param die3 an int representing the third die roll number
    * @return a boolean value indicating whether injury has occurred
    */
    public static boolean isInjured(int die1, int die2, int die3)
    {
        int sumOfDice = sumDice(die1, die2, die3);
        if (sumOfDice >= 7 && sumOfDice <= 13)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    /** 
    * Determines if the wanderer is still alive. The wanderer is still alive if
    * the total of the three dice is greater than the value six.
    * 
    * @param die1 an int representing the first die roll number
    * @param die2 an int representing the second die roll number
    * @param die3 an int representing the third die roll number
    * @return a boolean value indicating whether the wanderer is alive
    */
    public static boolean isAlive(int die1, int die2, int die3)
    {
        int sumOfDice = sumDice(die1, die2, die3);
        if (sumOfDice > 6)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    /** 
    * Determines if the wanderer is dead. The wanderer is dead if
    * the total of the three dice is less than or equal to the value six.
    * 
    * @param die1 an int representing the first die roll number
    * @param die2 an int representing the second die roll number
    * @param die3 an int representing the third die roll number
    * @return a boolean value indicating whether the wanderer is dead
    */
    public static boolean isDead(int die1, int die2, int die3)
    {
        int sumOfDice = sumDice(die1, die2, die3);
        return sumOfDice <= 6;
        /*
        if (sumOfDice <= 6)
        {
            return true;
        }
        else
        {
            return false;
        }
        */
    }
}