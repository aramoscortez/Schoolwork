/**
* Assignment Two - Recipe Help
*
* @author Abby Ramos Cortez
*
* @version 19.0.1 2023-01-25
*
 */

public class Fizzoda
{
    public static void main(String[] args)
    {
        //=====================================================================
        System.out.println("");
        int birthDay = 16;
        int birthMonth = 11;
        int birthYear = 2000;
        int fizzbits = birthDay * birthMonth * 12;
        int bitterquarks = birthDay * birthYear;
        int hydrobytes = birthMonth * birthYear;
        int batchFizzbits = 22;
        int batchBitterquarks = 62;
        int batchHydrobytes = 122;

        //=====================================================================
        System.out.println(" Fizzbit Recipe");
        System.out.println(" --------------");
        System.out.println("  22 Fizzbits");
        System.out.println("  62 Bitterquarks");
        System.out.println(" 122 Hydrobytes");
        System.out.println("");

        //=====================================================================
        System.out.println("Total Fizzbits: " + fizzbits);
        System.out.println("Total Bitterquarks: " + bitterquarks);
        System.out.println("Total Hydrobytes: " + hydrobytes);
        System.out.println("");

        //=====================================================================
        int batchesOfFizzbitsMade = fizzbits / batchFizzbits; 
        // / - performs integer division
        int remainderFizzbits = fizzbits % batchFizzbits; // % - remainder operator
        System.out.println("There are enough fizzbits to make " + 
        batchesOfFizzbitsMade + " batches with " + remainderFizzbits + " leftover.");
        System.out.println("");

        //=====================================================================
        int batchesOfBitterquarksMade = bitterquarks / batchBitterquarks;
        int remainderBitterquarks = bitterquarks % batchBitterquarks;
        System.out.println("There are enough fizzbits to make " + 
        batchesOfBitterquarksMade + " batches with " + remainderBitterquarks + 
        " leftover.");
        System.out.println("");

        //=====================================================================
        int batchesOfHydrobytesMade = hydrobytes / batchHydrobytes;
        int remainderHydrobytes = hydrobytes % batchHydrobytes;
        System.out.println("There are enough fizzbits to make " + 
        batchesOfHydrobytesMade + " batches with " + remainderHydrobytes + 
        " leftover.");
        System.out.println("");
    }
}