/**
 * Using loops and String methods to write some custom methods that operate on Strings.
 *
 * @author Abby Ramos Cortez
 * @version 19.0.1 2023-03-05
 */
public class PowerWords
{
    // **** Create your five methods here. ****
    /** 
    * Removes the first occurance of the given character from a provided string.
    * The method is case sensitive.
    * 
    * @param word A string that represents the word
    * @param character The character that is to be removed
    * @return An updated string with the removed character
    */
    public static String removeChar(String word, char character)
    {
        int firstCharOcc = word.indexOf(character);
        if (firstCharOcc != -1) // -1 indicates that the character is not in the string
        {
            word = word.substring(0, firstCharOcc) + 
                word.substring(firstCharOcc + 1);
        }
        return word;
    }

    /** 
    * Counts the number of times a target character occuers in the provided string.
    * The method is case sensitive.
    * 
    * @param word A string that represents the search string
    * @param character The target charcacter that is to be counted
    * @return The number of times the target character occurs in the provided string
    */
    public static int countChar(String word, char character)
    {
        int count = 0;
        for (int i = 0; i < word.length(); i++)
        {
            if (word.charAt(i) == character)
            {
                count++;
            }
        }
        return count;
    }

    /** 
    * Tests to see if a word can be made from the letters on a set of tiles. Each
    * tile can only be used once. This method is not case sensitive.
    *
    * @param tiles A string that represents the letters/tiles we can use. Note each
    * tile can only be used once.
    * @param word A string that represents the word to be spelt.
    * @return true if the word can be made from the letters. False otherwise.
    */
    public static boolean canSpell(String tiles, String word) 
    {
        tiles = tiles.toLowerCase();
        word = word.toLowerCase();

        for (int i = 0; i < word.length(); i++) 
        {
            char currentChar = word.charAt(i);
            if (tiles.indexOf(currentChar) == -1) { // cannot spell the word if one of
            // its characters is not available in the tiles list
                return false;
            } else {
                tiles = removeChar(tiles, currentChar);
            }
        }
        return true;
    }

    /** 
    * Determines if the letters in the word are in alphabetical order.
    * This method is not case sensitive.
    *
    * @param word a string containing the word
    * @return true if the the letters are in alphabetical order. False otherwise
    */
    public static boolean isAbecedarian(String word)
    {
        String alphabet = "";
        for (char c = 'A'; c <= 'Z'; c++) 
        {
            alphabet += "" + c;
        }

        word = word.toUpperCase();
        int index = 0;
        int nextIndex = 0;

        if (word.equals(""))
        {
            return false;
        }

        for (int i = 0; i < word.length() - 1; i++)
        {
            index = alphabet.indexOf(word.charAt(i));
            nextIndex = alphabet.indexOf(word.charAt(i + 1));
            if (index > nextIndex)
            {
                return false;
            }
        }
        return true;
    }

    /** 
    * Determines if all the characters in the given string occur excatly twice in 
    * the given string. This method is not case sensitive.
    * 
    * @param word the string to examine
    * @return true if all the characters in the given string occur exactly twice.
    * False otherwise.
    */
    public static boolean isDoubloon(String word)
    {
        word = word.toUpperCase();
        if (word.equals(""))
        {
            return false;
        }
        for (int i = 0; i < word.length(); i++)
        {
            if (countChar(word, word.charAt(i)) != 2) // could also do 
            // if (!(countChar(word, word.charAt(i) % 2 == 0)) for pairs of twos
            {
                return false;
            }
        }
        return true;
    }

    /** 
    * Tests the removeChar method given a character, word, the expected string the 
    * method must return and what is returned. 
    * @param ch the character to test
    * @param word the word to test
    * @param expectedStr a string that represents what must be returned
    * @param actualStr a string that represents what is returned
    */
    public static void testRemoveChar(char ch, String word, String expectedStr,
        String actualStr)
    {
        if (expectedStr.equals(actualStr))
        {
            System.out.println("Pass - removeChar(" + word + ", " + ch + ")");
        }
        else
        {
            System.out.println("FAIL - removeChar(" + word + ", " + ch + ") returned: "
                + actualStr + ", should be: " + expectedStr);
        }
    }

    /** 
    * Tests the countChar method given a character, word, the expected count the 
    * method must return and what is returned. 
    * @param ch the character to test
    * @param word the word to test
    * @param expectedCount an int that represents what must be returned
    * @param actualCount an int that represents what is returned
    */
    public static void testCountChar(char ch, String word, int expectedCount, 
        int actualCount)
    {
        if (expectedCount == actualCount)
        {
            System.out.println("Pass - countChar(" + word + ", " + ch + ")");
        }
        else
        {
            System.out.println("FAIL - countChar(" + word + ", " + ch + ") returned: "
                + actualCount+ ", should be: " + expectedCount);
        }
    }

    /** 
    * Tests the canSpell method given the tiles, word, the expected boolean the
    * method must return and what is returned. 
    * @param tiles String that represents the tiles(the letters we can use to 
    * spell the word)
    * @param word String that represents the word to spell
    * @param expectedBool a boolean that represents what must be returned
    * @param actualBool a boolean that represents what is returned
    */
    public static void testCanSpell(String tiles, String word, boolean expectedBool, 
        boolean actualBool)
    {
        if (actualBool == expectedBool)
        {
            System.out.println("Pass - canSpell(" + tiles + ", " + word + ")");
        }
        else
        {
            System.out.println("FAIL - canSpell(" + tiles + ", " + word + ") returned: "
                + actualBool + ", should be: " + expectedBool);
        }
    }

    /** 
    * Tests the isAbecedarian method given a word, the expected boolean the 
    * method must return and what is returned. 
    * @param word the word to test
    * @param expectedBool a boolean that represents what must be returned
    * @param actualBool a boolean that represents what is returned
    */
    public static void testIsAbecedarian(String word, boolean expectedBool, 
        boolean actualBool)
    {
        if (actualBool == expectedBool)
        {
            System.out.println("Pass - isAbecedarian(" + word + ")");
        }
        else
        {
            System.out.println("FAIL - isAbecedarian(" + word + ") returned: "
                + actualBool + ", should be: " + expectedBool);
        }
    }

    /** 
    * Tests the isDoubloon method given a word, the expected boolean the 
    * method must return and what is returned. 
    * @param word the word to test
    * @param expectedBool a boolean that represents what must be returned
    * @param actualBool a boolean that represents what is returned
    */
    public static void testIsDoubloon(String word, boolean expectedBool, 
        boolean actualBool)
    {
        if (actualBool == expectedBool)
        {
            System.out.println("Pass - isDoubloon(" + word + ")");
        }
        else
        {
            System.out.println("FAIL - isDoubloon(" + word + ") returned: "
                + actualBool + ", should be: " + expectedBool);
        }
    }

    /**
     * The main method for the program. In this case it is merely providing tests
     *  for the static methods of the class.
     *
     * @param args The command line arguments.
     */
    public static void main(String[] args)
    {
        /*
         Six pass/fail tests have been created for you.
         Add 10 additional tests for each method:
          removeChar
          countChar
          canSpell
          isAbecedarian
          isDoubloon.
        */

        // variables used throughout the testing
        boolean expectedBool;
        boolean actualBool;
        char ch;
        int expectedCount;
        int actualCount;
        String tiles;
        String word;
        String expectedStr;
        String actualStr;

        System.out.println();

        /* START TESTING removeChar */

        ch = 'C';
        word = "COW";

        expectedStr = "OW";
        actualStr = removeChar(word, ch);

        testRemoveChar(ch,word,expectedStr,actualStr);
        // ------------------------------------------------------------------------------
        ch = 'n';
        word = "Noise";

        expectedStr = "Noise";
        actualStr = removeChar(word, ch);

        testRemoveChar(ch,word,expectedStr,actualStr);
        // ------------------------------------------------------------------------------
        ch = 'p';
        word = "racer";

        expectedStr = "racer";
        actualStr = removeChar(word, ch);

        testRemoveChar(ch,word,expectedStr,actualStr);
        // ------------------------------------------------------------------------------
        ch = 'i';
        word = "mississippi";

        expectedStr = "mssissippi";
        actualStr = removeChar(word, ch);

        testRemoveChar(ch,word,expectedStr,actualStr);
        // ------------------------------------------------------------------------------
        ch = 'r';
        word = "";

        expectedStr = "";
        actualStr = removeChar(word, ch);

        testRemoveChar(ch,word,expectedStr,actualStr);
        // ------------------------------------------------------------------------------
        ch = ' ';
        word = "";

        expectedStr = "";
        actualStr = removeChar(word, ch);

        testRemoveChar(ch,word,expectedStr,actualStr);
        // ------------------------------------------------------------------------------
        ch = ' ';
        word = "Yes or No?";

        expectedStr = "Yesor No?";
        actualStr = removeChar(word, ch);

        testRemoveChar(ch,word,expectedStr,actualStr);
        // ------------------------------------------------------------------------------
        ch = 'A';
        word = "A";

        expectedStr = "";
        actualStr = removeChar(word, ch);

        testRemoveChar(ch,word,expectedStr,actualStr);
        // ------------------------------------------------------------------------------
        ch = '.';
        word = "J.C. PENNY";

        expectedStr = "JC. PENNY";
        actualStr = removeChar(word, ch);

        testRemoveChar(ch,word,expectedStr,actualStr);
        // ------------------------------------------------------------------------------
        ch = 'o';
        word = "0000000o00000000";

        expectedStr = "000000000000000";
        actualStr = removeChar(word, ch);

        testRemoveChar(ch,word,expectedStr,actualStr);
        // ------------------------------------------------------------------------------
        ch = '>';
        word = "<<<<<<><>>>><<><";

        expectedStr = "<<<<<<<>>>><<><";
        actualStr = removeChar(word, ch);

        testRemoveChar(ch,word,expectedStr,actualStr);
        /* END TESTING removeChar */

        System.out.println();

        /* START TESTING countChar */

        ch = 'C';
        word = "COW";

        expectedCount = 1;
        actualCount = countChar(word, ch);

        testCountChar(ch,word,expectedCount,actualCount);
        // ------------------------------------------------------------------------------
        ch = 'A';
        word = "AABACDC";

        expectedCount = 3;
        actualCount = countChar(word, ch);

        testCountChar(ch,word,expectedCount,actualCount);
        // ------------------------------------------------------------------------------
        ch = 'C';
        word = "AABACDC";

        expectedCount = 2;
        actualCount = countChar(word, ch);

        testCountChar(ch,word,expectedCount,actualCount);
        // ------------------------------------------------------------------------------
        ch = 'A';
        word = "aabacdc";

        expectedCount = 0;
        actualCount = countChar(word, ch);

        testCountChar(ch,word,expectedCount,actualCount);
        // ------------------------------------------------------------------------------
        ch = 'T';
        word = "AABACDC";

        expectedCount = 0;
        actualCount = countChar(word, ch);

        testCountChar(ch,word,expectedCount,actualCount);
        // ------------------------------------------------------------------------------
        ch = 'A';
        word = "";

        expectedCount = 0;
        actualCount = countChar(word, ch);

        testCountChar(ch,word,expectedCount,actualCount);
        // ------------------------------------------------------------------------------
        ch = ' ';
        word = "   ";

        expectedCount = 3;
        actualCount = countChar(word, ch);

        testCountChar(ch,word,expectedCount,actualCount);
        // ------------------------------------------------------------------------------
        ch = ' ';
        word = "Python, Java and R are my favorite languages. ";

        expectedCount = 8;
        actualCount = countChar(word, ch);

        testCountChar(ch,word,expectedCount,actualCount);
        // ------------------------------------------------------------------------------
        ch = 'E';
        word = "SaLlY SeLlS SeA ShElLs bY ThE SeA ShOrE";

        expectedCount = 3;
        actualCount = countChar(word, ch);

        testCountChar(ch,word,expectedCount,actualCount);
        // ------------------------------------------------------------------------------
        ch = 'C';
        word = "aabacdc";

        expectedCount = 0;
        actualCount = countChar(word, ch);

        testCountChar(ch,word,expectedCount,actualCount);
        // ------------------------------------------------------------------------------
        ch = '-';
        word = "-1-2-3-4-5-6-7-8-9-10-11-12-13-14-15";

        expectedCount = 15;
        actualCount = countChar(word, ch);

        testCountChar(ch,word,expectedCount,actualCount);
        /* END TESTING countChar */

        System.out.println();

        /* START TESTING canSpell */

        tiles = "WQXOACW";
        word  = "COW";

        expectedBool = true;
        actualBool = canSpell(tiles, word);

        testCanSpell(tiles, word, expectedBool, actualBool);
        // ------------------------------------------------------------------------------
        tiles = "WQXOACW";
        word  = "cow";

        expectedBool = true;
        actualBool = canSpell(tiles, word);

        testCanSpell(tiles, word, expectedBool, actualBool);
        // ------------------------------------------------------------------------------
        tiles = "WQXOACW";
        word  = "PIG";

        expectedBool = false;
        actualBool = canSpell(tiles, word);

        testCanSpell(tiles, word, expectedBool, actualBool);
        // ------------------------------------------------------------------------------
        tiles = "";
        word  = "PIG";

        expectedBool = false;
        actualBool = canSpell(tiles, word);

        testCanSpell(tiles, word, expectedBool, actualBool);
        // ------------------------------------------------------------------------------
        tiles = "WESCQSI";
        word  = "";

        expectedBool = true;
        actualBool = canSpell(tiles, word);

        testCanSpell(tiles, word, expectedBool, actualBool);
        // ------------------------------------------------------------------------------
        tiles = "";
        word  = "";

        expectedBool = true;
        actualBool = canSpell(tiles, word);

        testCanSpell(tiles, word, expectedBool, actualBool);
        // ------------------------------------------------------------------------------
        tiles = "WQXOACW";
        word  = "COWS";

        expectedBool = false;
        actualBool = canSpell(tiles, word);

        testCanSpell(tiles, word, expectedBool, actualBool);
        // ------------------------------------------------------------------------------
        tiles = "JNDWDBANcbbeaklahuNCAJKSTD";
        word  = "BLANKET";

        expectedBool = true;
        actualBool = canSpell(tiles, word);

        testCanSpell(tiles, word, expectedBool, actualBool);
        // ------------------------------------------------------------------------------
        tiles = "hodnkirjjdjfnor jkusrcsa";
        word  = " HONDURAS ";

        expectedBool = false;
        actualBool = canSpell(tiles, word);

        testCanSpell(tiles, word, expectedBool, actualBool);
        // ------------------------------------------------------------------------------
        tiles = "NSIIFJFLELGL DMDOAKSLANFERV";
        word  = "El Salvador";

        expectedBool = true;
        actualBool = canSpell(tiles, word);

        testCanSpell(tiles, word, expectedBool, actualBool);
        // ------------------------------------------------------------------------------
        tiles = "NSIIFDMDOAKSLANFER";
        word  = "El Salvador";

        expectedBool = false;
        actualBool = canSpell(tiles, word);

        testCanSpell(tiles, word, expectedBool, actualBool);
        /* END TESTING canSpell */

        System.out.println();

        /* START TESTING isAbecedarian */

        word = "abort";

        expectedBool = true;
        actualBool = isAbecedarian(word);

        testIsAbecedarian(word, expectedBool, actualBool);
        // ------------------------------------------------------------------------------
        word = "floPy";

        expectedBool = true;
        actualBool = isAbecedarian(word);

        testIsAbecedarian(word, expectedBool, actualBool);
        // ------------------------------------------------------------------------------
        word = "cat";

        expectedBool = false;
        actualBool = isAbecedarian(word);

        testIsAbecedarian(word, expectedBool, actualBool);
        // ------------------------------------------------------------------------------
        word = "";

        expectedBool = false;
        actualBool = isAbecedarian(word);

        testIsAbecedarian(word, expectedBool, actualBool);
        // ------------------------------------------------------------------------------
        word = "AAaBbBbbbYyY";

        expectedBool = true;
        actualBool = isAbecedarian(word);

        testIsAbecedarian(word, expectedBool, actualBool);
        // ------------------------------------------------------------------------------
        word = " ABCDEF";

        expectedBool = true;
        actualBool = isAbecedarian(word);

        testIsAbecedarian(word, expectedBool, actualBool);
        // ------------------------------------------------------------------------------
        word = "ABCDEF ";

        expectedBool = false;
        actualBool = isAbecedarian(word);

        testIsAbecedarian(word, expectedBool, actualBool);
        // ------------------------------------------------------------------------------
        word = "ABC DEF";

        expectedBool = false;
        actualBool = isAbecedarian(word);

        testIsAbecedarian(word, expectedBool, actualBool);
        // ------------------------------------------------------------------------------
        word = "AlMoSt";

        expectedBool = true;
        actualBool = isAbecedarian(word);

        testIsAbecedarian(word, expectedBool, actualBool);
        // ------------------------------------------------------------------------------
        word = "ALLMOSST";

        expectedBool = true;
        actualBool = isAbecedarian(word);

        testIsAbecedarian(word, expectedBool, actualBool);
        // ------------------------------------------------------------------------------
        word = "abcDEFghi";

        expectedBool = true;
        actualBool = isAbecedarian(word);

        testIsAbecedarian(word, expectedBool, actualBool);
        /* END TESTING isAbecedarian */

        System.out.println();

        /* START TESTING isDoubloon */

        word = "Abba";

        expectedBool = true;
        actualBool = isDoubloon(word);

        testIsDoubloon(word, expectedBool, actualBool);
        // ------------------------------------------------------------------------------
        word = "abba";

        expectedBool = true;
        actualBool = isDoubloon(word);

        testIsDoubloon(word, expectedBool, actualBool);
        // ------------------------------------------------------------------------------
        word = "aBba";

        expectedBool = true;
        actualBool = isDoubloon(word);

        testIsDoubloon(word, expectedBool, actualBool);
        // ------------------------------------------------------------------------------
        word = "horseshoer";

        expectedBool = true;
        actualBool = isDoubloon(word);

        testIsDoubloon(word, expectedBool, actualBool);
        // ------------------------------------------------------------------------------
        word = "doggy";

        expectedBool = false;
        actualBool = isDoubloon(word);

        testIsDoubloon(word, expectedBool, actualBool);
        // ------------------------------------------------------------------------------
        word = "pop";

        expectedBool = false;
        actualBool = isDoubloon(word);

        testIsDoubloon(word, expectedBool, actualBool);
        // ------------------------------------------------------------------------------
        word = "";

        expectedBool = false;
        actualBool = isDoubloon(word);

        testIsDoubloon(word, expectedBool, actualBool);
        // ------------------------------------------------------------------------------
        word = "DISNEYdisneyDISNEY";

        expectedBool = false;
        actualBool = isDoubloon(word);

        testIsDoubloon(word, expectedBool, actualBool);
        // ------------------------------------------------------------------------------
        word = "TtrRoOuubBlLee";

        expectedBool = true;
        actualBool = isDoubloon(word);

        testIsDoubloon(word, expectedBool, actualBool);
        // ------------------------------------------------------------------------------
        word = "No No Way Way";

        expectedBool = false;
        actualBool = isDoubloon(word);

        testIsDoubloon(word, expectedBool, actualBool);
        // ------------------------------------------------------------------------------
        word = "NoNoWayWay";

        expectedBool = true;
        actualBool = isDoubloon(word);

        testIsDoubloon(word, expectedBool, actualBool);
        /* END TESTING isDoubloon */

        System.out.println();
    } //main

}
