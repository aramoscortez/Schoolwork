/**
* In this program, we declare and assign variables, set up methods to perform particular 
* calculations or tasks, and invoke them in the main(and even in another method).
*
* @author Abby Ramos Cortez
*
* @version 19.0.1 2023-02-09
*
*/
import java.util.Scanner;

public class TipperatorV2
{
    /**
    * The main method, which runs the program when executed.
    *
    * @param args The command line arguments.
    */
    public static void main(String[] args)
    {
        final int TEN = 10;
        final int TWELVE = 12;
        final int FIFTEEN = 15;
        final int EIGHTEEN = 18;
        final int TWENTY = 20;
        final int TWENTY_TWO = 22;
        final int TWENTY_FIVE = 25;
        final int TWENTY_EIGHT = 28;
        final int THIRTY = 30;
        final String VERSION = "2.0";
        double tenPercent = (double) TEN / 100.00;
        double twelvePercent = (double) TWELVE / 100.00;
        double fifteenPercent = (double) FIFTEEN / 100.00;
        double eighteenPercent = (double) EIGHTEEN / 100.00;
        double twentyPercent = (double) TWENTY / 100.00;
        double twentyTwoPercent = (double) TWENTY_TWO / 100.00;
        double twentyFivePercent = (double) TWENTY_FIVE / 100.00;
        double twentyEightPercent = (double) TWENTY_EIGHT / 100.00;
        double thirtyPercent = (double) THIRTY / 100.00;
        double checkAmountUI;

        displayWelcomeMessage(VERSION);
        checkAmountUI = getCheckAmount();
        displayTableHeadingLabels();
        displayTableHyphenLine();

        // calcuting the tip percent using the calculateTipAmount method and
        // assigning the return value to a variable
        double tipAmount10Percent = calculateTipAmount(tenPercent,checkAmountUI);
        double tipAmount12Percent = calculateTipAmount(twelvePercent,checkAmountUI);
        double tipAmount15Percent = calculateTipAmount(fifteenPercent,checkAmountUI);
        double tipAmount18Percent = calculateTipAmount(eighteenPercent,checkAmountUI);
        double tipAmount20Percent = calculateTipAmount(twentyPercent,checkAmountUI);
        double tipAmount22Percent = calculateTipAmount(twentyTwoPercent,checkAmountUI);
        double tipAmount25Percent = calculateTipAmount(twentyFivePercent,checkAmountUI);
        double tipAmount28Percent = calculateTipAmount(twentyEightPercent,checkAmountUI);
        double tipAmount30Percent = calculateTipAmount(thirtyPercent,checkAmountUI);

        double checkTotalFor10 = calculateNewCheckAmount(tipAmount10Percent, checkAmountUI);
        double checkTotalFor12 = calculateNewCheckAmount(tipAmount12Percent, checkAmountUI);
        double checkTotalFor15 = calculateNewCheckAmount(tipAmount15Percent, checkAmountUI);
        double checkTotalFor18 = calculateNewCheckAmount(tipAmount18Percent, checkAmountUI);
        double checkTotalFor20 = calculateNewCheckAmount(tipAmount20Percent, checkAmountUI);
        double checkTotalFor22 = calculateNewCheckAmount(tipAmount22Percent, checkAmountUI);
        double checkTotalFor25 = calculateNewCheckAmount(tipAmount25Percent, checkAmountUI);
        double checkTotalFor28 = calculateNewCheckAmount(tipAmount28Percent, checkAmountUI);
        double checkTotalFor30 = calculateNewCheckAmount(tipAmount30Percent, checkAmountUI);

        // invoking the displayTableRow method and passing three arguments for the 
        // method to run properly
        displayTableRow(TEN, tipAmount10Percent, checkTotalFor10);
        displayTableRow(TWELVE, tipAmount12Percent, checkTotalFor12);
        displayTableRow(FIFTEEN, tipAmount15Percent, checkTotalFor15);
        displayTableRow(EIGHTEEN, tipAmount18Percent, checkTotalFor18);
        displayTableRow(TWENTY, tipAmount20Percent, checkTotalFor20);
        displayTableRow(TWENTY_TWO, tipAmount22Percent, checkTotalFor22);
        displayTableRow(TWENTY_FIVE, tipAmount25Percent, checkTotalFor25);
        displayTableRow(TWENTY_EIGHT, tipAmount28Percent, checkTotalFor28);
        displayTableRow(THIRTY, tipAmount30Percent, checkTotalFor30);

        displayTableHyphenLine();
        System.out.println();
    }

    /**
    * Displays a welcome message to the user on the command prompt
    *
    * @param version the version of the Tipperator which is stored as a string
    */
    public static void displayWelcomeMessage(String version)
    {
        System.out.println();
        System.out.println("------ Welcome to the Tipperator Calculator Version " + 
            version + " ------\n"); 
    }

    /** 
    * Displays the heading information for the table
    */
    public static void displayTableHeadingLabels()
    {
        System.out.println(" Tip Percent    Tip Amount    Check Total");
    }
    
    /** 
    * Displays the hyphenated line on the table
    */
    public static void displayTableHyphenLine()
    {
        System.out.println("------------------------------------------");
    }

    /** 
    * Displays a full line of valies within the table(tip percent, tip amount, 
    * check total)
    * 
    * @param value a constant/integer value(10, 12, 15, 18, 20, 22, 25, 28, 30). 
    * These are the tip percentages , we just need to attach a (%) sign. 
    * @param tipAmount a float value which represents the tip amount and is 
    * calculated by multiplying the tip percent and check amounts accordingly.
    * @param checkTotals a float value which represents the check totals and 
    * is calculated by adding the tip amount to the check amount.
    */
    public static void displayTableRow(int value, double tipAmount, double checkTotals)
    {
        System.out.printf("%5d%%%16.2f%15.2f\n", value, tipAmount, checkTotals);
    }

    /** 
    * prompts the user to enter the check amount
    *
    * @return returns what the user entered as a floating point number
    */
    public static double getCheckAmount()
    {
        Scanner input;
        input = new Scanner(System.in);
        double checkAmount;

        System.out.print("Enter the check amount: ");
        checkAmount = input.nextDouble();
        System.out.println();
        return checkAmount;
    }

    /** 
    * calculates the amount for the tip given the percentage and check amount
    *
    * @param tipPercent the percentage in decimal format(0.10,0.12,0.15,...,0.30)
    * and is in the form of a floating value
    * @param checkAmount the amount user entered as a floating point number
    *
    * @return returns the tip amount as a floating point number
    */
    public static double calculateTipAmount(double tipPercent, double checkAmount)
    {
        double tipAmount = tipPercent * checkAmount;
        return tipAmount;
    }

    /** 
    * calculates the updated check amount after the tip is added to the original amount
    *
    * @param tipAmount represents the tip amount as a floating point number
    * @param checkAmount the amount user entered as a floating point number
    *
    * @return returns the updated check amount as a floating point number
    */
    public static double calculateNewCheckAmount(double tipAmount, double checkAmount)
    {
        double newCheckAmount = checkAmount + tipAmount;
        return newCheckAmount;
    }

}