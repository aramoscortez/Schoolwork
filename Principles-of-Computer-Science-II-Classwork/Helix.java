/*
 * ITEC 120 Assignment 10 - Helix Class
 */

/**
 * We create the Helix object. This class builds on from the Chain class. 
 * We implement methods from the chain class. And continue to learn about 
 * object-oriented design concepts and how to create classes containing arrays 
 * as attributes. 
 *
 * @author Jeffrey LaMarche
 *
 * @version 1.0 2022-04-18
 * Initial Version
 *
 * @author Abby Ramos Cortez
 *
 * @version 19.0.1 2023-04-27
 */
public class Helix
{
    private Chain chainOne;
    private Chain chainTwo;

    /** 
     * The first value constructor allows creating a Helix object where the 
     * first chain is the sequence of bases provided in the string passed to 
     * the method. This means that a new Chain object is created based on the 
     * String object, which is then assigned to the chainOne attribute. The 
     * constructor then creates the second chain based on the first one.
     * 
     * @param chainOne a String that represents a sequence of bases for the 
     * first chain. The second chain is to be created using the method 
     * createChainTwo
    */
    public Helix(String chainOne)
    {
        Chain chainOneObj = new Chain(chainOne);
        this.chainOne = chainOneObj;
    }

    /** 
     * The second value constructor allows creating a Helix object where the 
     * first chain is the sequence of bases provided in the first string passed
     * to the method, and the second chain is the sequence of bases provided in
     * the second string passed to the method.
     * 
     * @param chainOne a String that represents a sequence of bases for the 
     * first chain.
     * @param chainTwo a String that represents a sequence of bases for the 
     * second chain.
    */
    public Helix(String chainOne, String chainTwo)
    {
        Chain chainOneObj = new Chain(chainOne);
        Chain chainTwoObj = new Chain(chainTwo);

        this.chainOne = chainOneObj;
        this.chainTwo = chainTwoObj;
    }

    /** 
     * This method creates an appropriate chain for chainTwo that is based off 
     * of chainOne. This means that both chains will be the same length. The 
     * mapping of bases inside the chains is listed in the table below. This is 
     * also known as the complementary base pairs. 
    */
    public void createChainTwo()
    {
        this.chainTwo = new Chain(this.chainOne.getLength());
        for (int i = 0; i < this.chainOne.getLength(); i++)
        {
            char initialOne = this.chainOne.getBase(i).getBaseInitial(); 
            // obtaining the initial of each base in the chain
            char initialTwo = Base.EMP;
            switch (initialOne)
            {
                case Base.ADE: // if the initial for the base in the first chain is
                // 'A', then the initial for the second base in the chain is 'T'
                    initialTwo = Base.THY;
                    break;
                case Base.CYT:
                    initialTwo = Base.GUA;
                    break;
                case Base.GUA:
                    initialTwo = Base.CYT;
                    break;
                case Base.PYR:
                    initialTwo = Base.ZER;
                    break;
                case Base.THY:
                    initialTwo = Base.ADE;
                    break;
                case Base.ZER:
                    initialTwo = Base.PYR;
                    break;
                case Base.UNK:
                    initialTwo = Base.UNK;
                    break;
                case Base.EMP:
                    initialTwo = Base.EMP;
                    break;
            }
            Base complementaryBase = new Base(initialTwo);
            complementaryBase.autoAssignBaseName();
            this.chainTwo.setBase(i, complementaryBase); // setBase is a method
            // in the chain class
        }
    }

    /** 
     * This method determines if the Helix object is valid. A valid helix has 
     * two chains that are the same lengths, it only contains known or unknown 
     * bases, and the chains have the correct mappings of base pairs listed in 
     * the table for the createChainTwo method (e.g., A goes to T). If the helix
     * is valid, this method returns true, otherwise false.
     * 
     * @return true if the helix is valid, false otherwise.
    */
    public boolean isHelixValid()
    {
        boolean basePairsMatch = true;
        for (int i = 0; i < this.chainOne.getLength(); i++) 
        {
            char initialOne = this.chainOne.getBase(i).getBaseInitial();
            char initialTwo = this.chainTwo.getBase(i).getBaseInitial();

            if ((initialOne == Base.ADE && initialTwo != Base.THY) ||
                (initialOne == Base.CYT && initialTwo != Base.GUA) ||
                (initialOne == Base.GUA && initialTwo != Base.CYT) ||
                (initialOne == Base.PYR && initialTwo != Base.ZER) ||
                (initialOne == Base.THY && initialTwo != Base.ADE) ||
                (initialOne == Base.ZER && initialTwo != Base.PYR) ||
                (initialOne == Base.UNK && initialTwo != Base.UNK) ||
                (initialOne == Base.EMP && initialTwo != Base.EMP)) 
            {
                basePairsMatch = false;
            }
        }

        return (this.chainOne.getLength() == this.chainTwo.getLength()) && 
            this.chainOne.isChainValid() && this.chainTwo.isChainValid() &&
            basePairsMatch;
    }

    /** 
     * This method determines if two helixes are equal to each other. This 
     * means that the two chains inside of one helix must be equal to the two 
     * chains inside of another helix. However, the order that the chains occur
     * within a helix does not matter. Then, test chainOne of "this" helix 
     * against chainTwo of "that" helix, and then chainTwo of "this" helix 
     * against chainOne of "that" helix. 
     * 
     * @param that the helix to compare against
     * @return true if the two chains are equal, false otherwise    
    */
    public boolean equals(Helix that)
    {
        return this.chainOne.equals(that.chainOne) &&
            this.chainTwo.equals(that.chainTwo);
    }

    /** 
     * This method provides a String representation of a single Helix object. 
     * The string contains the two chain base pairs, separated by hyphens, 
     * each on a separate line. For simplicity, there is a newline added at the
     * end of the final string produced. 
     * 
     * @return a properly formatted Helix to be outputted
    */
    public String toString()
    {
        if (this.chainOne.getLength() != this.chainTwo.getLength())
        {
            return "ERROR: HELIX CHAINS ARE EQUAL LENGTH";
        }

        StringBuilder output = new StringBuilder();
        String chainOneString = chainOne.toString(); // uses the toString() method
        // from the Chain class
        String chainTwoString = chainTwo.toString();

        String[] chainOneStringSplit = chainOneString.split("\n"); // splits 
        // the string whenever we see \n in the string. Places these strings 
        // into an array of strings
        String[] chainTwoStringSplit = chainTwoString.split("\n");

        for (int i = 0; i < chainOneStringSplit.length; i++)
        {
            output.append(chainOneStringSplit[i]);
            output.append(" ---- ");
            output.append(chainTwoStringSplit[i]);
            output.append("\n");
        }

        return output.toString();
    }
}
