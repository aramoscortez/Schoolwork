/**
 * We create the Dice class/object, specify its attributes, create constructors,
 * getters and setters, toString and other instance methods. We also test object
 * equality and validate objects.
 * 
 * @author Abby Ramos Cortez
 * 
 * @version 19.0.1 2023-04-07
*/
import java.util.Random;

public class Dice
{
    private int sides;
    private int value;

    /** 
     * The default constructor creates a new Dice object with six sides and it
     * has a starting value of one.
    */
    public Dice()
    {
        this.sides = 6;
        this.value = 1;
    }

    /** 
     * The value constructor creates a new Dice object with specific number of
     * sides and it has a starting value of one.
    */
    public Dice(int sides)
    {
        this.sides = sides;
        this.value = 1;
    }

    /** 
     * Since the sides attribute of the dice object is private, we cannot access
     * it without either changing it to public or creating a method to access it.
     * We utilize this method to return the number of sides of the Dice object.
     * 
     * @return the number of sides of the Dice object
    */
    public int getSides()
    {
        return this.sides;
    }

    /** 
     * Since the values attribute of the dice object is private, we cannot access
     * it without either changing it to public or creating a method to access it.
     * We utilize this method to return the number of sides of the Dice object.
     * 
     * @return the value of the Dice object
    */
    public int getValue()
    {
        return this.value;
    }

    /** 
     * Invoking this method on a Dice object will change the sides attribute
     * of the Dice object to the number inputted as an argument(passed in as 
     * the parameter)
     * 
     * @param sides an integer that represents the number of sides of the Dice 
     * object
    */
    public void setSides(int sides)
    {
        this.sides = sides;
    }

    /** 
     * Invoking this method on a Dice object will change the value attribute of
     * the Dice object to the number inputted as an argument(passed in as the parameter)
     * 
     * @param value an integer that represents the value of the Dice object
    */
    public void setValue(int value)
    {
        this.value = value;
    }

    /** 
     * This method randomly assigns the Dice value to a new number between 1 
     * and the number of sides, both inclusive [1, sides].
    */
    public void rollDice()
    {
        Random random = new Random();
        this.value = random.nextInt(this.sides) + 1; // Range is between 1 and
        //the number of sides
    }

    /** 
     * This method determines if the number of sides for this object is 
     * considered valid. For the sides to be valid, the sides must equal 
     * 4, 6, 8, 10, 12 or 20.
     * 
     * @return true if the number of sides is valid, false otherwise.
    */
    public boolean isValidSides()
    {
        if (this.sides == 4 || this.sides == 6 || this.sides == 8 || 
            this.sides == 10 || this.sides == 12 || this.sides == 20)
        {
            return true;
        }
        return false;
    }

    /** 
     * This method determines if the value for this object is considered valid.
     * For the value to be valid, it must be within the range [1, sides]. 
     * (Both inclusive.)
     * 
     * @return true if the value is valid, false otherwise.
    */
    public boolean isValidValue()
    {
        if (this.value >= 1 && this.value <= this.sides)
        {
            return true;
        }
        return false;
    }

    /** 
     * This method determines if the entire object is considered valid. 
     * For a Dice object to be considered valid, it must have a valid number 
     * of sides and a valid value.
     * 
     * @return true if the object's attributes are valid, false otherwise.
    */
    public boolean isValidDice()
    {
        if (isValidSides() == true && isValidValue() == true)
        {
            return true;
        }
        return false;
    }

    /** 
     * This method determines if this object's value is equal to a target value
     * specified as a parameter
     * 
     * @param targetValue an integer representing the target value
     * @return true if the object's value attribute is equal to the target value,
     * false otherwise
    */
    public boolean equalsTargetValue(int targetValue)
    {
        if (this.value == targetValue)
        {
            return true;
        }
        return false;
    }

    /** 
     * This method determines if two Dice objects each have the same values. 
     * (This Dice object value versus that Dice object value.)
     * 
     * @param thatDice Dice object to compare against 
     * @return true if this Dice object(the dice object we're invoking the method on)
     * is equal to that Dice object(the argument which is passed in as the 
     * parameter), false otherwise.
    */
    public boolean equalsValue(Dice thatDice)
    {
        if (this.value == thatDice.value)
        {
            return true;
        }
        return false;
    }

    /** 
     * This method determines strict equality for two Dice objects. 
     * Both Dice objects are considered equal if they have the same number
     * of sides and the same value. (This versus that.)
     * 
     * @param thatDice Dice object to compare against 
     * @return true if Dice objects attributes are equal to each other, false 
     * otherwise.
    */
    public boolean equals(Dice thatDice)
    {
        if (this.sides == thatDice.sides && this.value == thatDice.value)
        {
            return true;
        }
        return false;
    }
    
    /** 
     * The toString method for a Dice object will create and return a properly 
     * formatted String object (i.e., reference). The format starts with the 
     * letter 'd' followed by the number of sides, then a colon, and finally 
     * the current value.
     * 
     * @return a string that is properly formatted 
    */
    public String toString()
    {
        return String.format("%3s : %2d","d" + this.sides, this.value);
        // %3s represents a string with a width of 3 with d in front of the
        // number of sides and right aligned.
    }

}
