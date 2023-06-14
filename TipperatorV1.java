/**
* Assignment 3 - Tipperator
*
* @author Abby Ramos Cortez
*
* @version 19.0.1 2023-02-01
*
*/
import java.util.Scanner;

public class TipperatorV1
{
  public static void main(String[] args)
  {
    // Setting up Scanner, creating constants, and declaring variables
    Scanner input;
    input = new Scanner(System.in);
    final int TEN = 10;
    final int FIFTEEN = 15;
    final int TWENTY = 20;
    double tenPercentDecimal = (double) TEN / 100;
    double fifteenPercentDecimal = (double) FIFTEEN / 100;
    double twentyPercentDecimal = (double) TWENTY / 100;
    double checkAmount;
    double tipTenPercent;
    double tipFifteenPercent;
    double tipTwentyPercent;
    double totalTenPercent;
    double totalFifteenPercent;
    double totalTwentyPercent;

    // Welcome message, asking user for input for check amount, 
    // and setting up the table
    System.out.println();
    System.out.println("------ Welcome to the Tipperator Calculator Version 1.0 ------");
    System.out.println();
    System.out.print("Enter the check amount: ");
    checkAmount = input.nextDouble();
    System.out.println();
    System.out.println(" Tip Percent    Tip Amount    Check Total");
    System.out.println("------------------------------------------");

    // Calculating the tip amount
    tipTenPercent = checkAmount * tenPercentDecimal;
    tipFifteenPercent = checkAmount * fifteenPercentDecimal;
    tipTwentyPercent = checkAmount * twentyPercentDecimal;

    // Calculating the total amount
    totalTenPercent = checkAmount + tipTenPercent;
    totalFifteenPercent = checkAmount + tipFifteenPercent;
    totalTwentyPercent = checkAmount + tipTwentyPercent;

    // Outputting the tip amount and total amount 
    // Finsih setting up the table with proper formatting
    System.out.printf("    %d%%            %.2f          %.2f\n", TEN, 
      tipTenPercent, totalTenPercent);
    System.out.printf("    %d%%            %.2f          %.2f\n", FIFTEEN, 
      tipFifteenPercent, totalFifteenPercent);
    System.out.printf("    %d%%            %.2f          %.2f\n", TWENTY, 
      tipTwentyPercent, totalTwentyPercent);
    System.out.println("------------------------------------------");


    System.out.println();
  }
}