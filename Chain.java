/*
 * ITEC 120 Assignment 10 - Chain Class
 */

/**
 * In this class, we create the Chain object. This class builds on from the 
 * base class. We continue to learn about object-oriented design concepts and 
 * how to create classes containing arrays as attributes. 
 *
 * @author Jeffrey LaMarche
 *
 * @version 1.0 2022-04-18
 * Initial Version
 *
 * @author Abby Ramos Cortez
 *
 * @version 19.0.1 2023-04-28
 */
public class Chain
{
    /*
     * Constant bases that can be used for testing.
     */
    public final static Base ADENINE = new Base(Base.ADE, Base.ADENINE);
    public final static Base CYTOSINE = new Base(Base.CYT, Base.CYTOSINE);
    public final static Base GUANINE = new Base(Base.GUA, Base.GUANINE);
    public final static Base PYROZINE = new Base(Base.PYR, Base.PYROZINE);
    public final static Base THYMINE = new Base(Base.THY, Base.THYMINE);
    public final static Base ZERAMINE = new Base(Base.ZER, Base.ZERAMINE);
    public final static Base UNKNOWN = new Base(Base.UNK, Base.UNKNOWN);

    /*
     * Default length for a chain.
     */
    private final static int DEFAULT_LENGTH = 10;
    private Base[] chainBases;

    /** 
     * The default constructor creates a chain of the default length and fills 
     * it with empty Base objects. 
    */
    public Chain()
    {
        this.chainBases = new Base[DEFAULT_LENGTH];
        for (int i = 0; i < DEFAULT_LENGTH; i++)
        {
            this.chainBases[i] = new Base();
        }
    }

    /** 
     * The first value constructor allows setting the chain length to a 
     * specific value. The chain is then filled with empty Base objects. If 
     * the length is invalid, the default length should be used.
    */
    public Chain(int length)
    {
        int chainLength = 0;

        if (length > 0)
        {
            chainLength = length;
        }
        else
        {
            chainLength = DEFAULT_LENGTH;
        }

        this.chainBases = new Base[chainLength];
        for (int i = 0; i < chainLength; i++)
        {
            this.chainBases[i] = new Base();
        }
    }

    /** 
     * The second value constructor allows creating a chain based on a String 
     * parameter value that contains a sequence of bases.
     * 
     * @param chainBases a String that represents a sequence of bases
    */
    public Chain(String chainBases)
    {
        this.chainBases = new Base[chainBases.length()];
        for (int i = 0; i < chainBases.length(); i++)
        {
            char currentChar = Character.toUpperCase(chainBases.charAt(i));
            Base newBase = new Base(currentChar);
            newBase.autoAssignBaseName(); // bases class method
            this.chainBases[i] = newBase;
        }
    }

    /** 
     * This method returns the Base object found at the specified index of the 
     * chain. If the index is invalid, this method returns null to indicate the 
     * error. 
     * 
     * @return an integer that represents the length of the chain
     * (which is an array of bases)
    */
    public int getLength()
    {
        return this.chainBases.length;
    }

    /** 
     * This method returns the Base object found at the specified index of the 
     * chain. If the index is invalid, this method returns null to indicate the
     * error. 
     * 
     * @param index an integer that represents the index of the base to be 
     * returned
     * @return returns a base object found at a valid index. If the index is invalid,
     * null will get returned.
    */
    public Base getBase(int index)
    {
        if (index >= 0 && index < this.chainBases.length)
        {
            return this.chainBases[index];
        }
        return null;
    }

    /** 
     * This method will set the Base object to a new value for a specified 
     * index of the Chain. If the new base being set is null, make an empty 
     * base at the location instead. If the index is invalid, nothing is 
     * changed in the chain.
     * 
     * @param index the index we want to set a given base to
     * @param base the base to be set to at a valid index. No change will be 
     * made if the index is invalid
    */
    public void setBase(int index, Base base)
    {
        if (index >= 0 && index < this.chainBases.length)
        {
            if (base == null)
            {
                this.chainBases[index] = new Base();
            }
            else
            {
                this.chainBases[index] = base;
            }
        }
    }

    /** 
     * This method determines if the entire chain is valid. A valid chain only 
     * contains known and unknown bases with correct pairings, which results in
     * true being returned. This means that an empty base or a mismatched pair 
     * would return false.
     * 
     * @return returns true if the chain is valid, false otherwise.
    */
    public boolean isChainValid()
    {
        for (int i = 0; i < this.chainBases.length; i++)
        {
            if (this.chainBases[i].isBaseValid() == false) // chainBases is an 
            // array of bases which is why use [i] to check every base
            {
                return false;
            }
        }
        return true;
    }

    /** 
     * This method determines if two chains are equal to each other, which means
     * that they have exactly the same bases in the same order. 
     * 
     * @param that the chain to compare against
     * @return true if the chains are equal, false otherwise
    */
    public boolean equals(Chain that)
    {
        if (this.chainBases.length != that.chainBases.length)
        {
            return false;
        }

        for (int i = 0; i < this.chainBases.length; i++)
        {
            if (!(this.chainBases[i].equals(that.chainBases[i]))) // uses the 
            // bases class equals method
            {
                return false;
            }
        }
        return true;
    }

    /** 
     * This method provides a String representation of a single Chain object. 
     * The string contains each base contained in the chain on a separate line. 
     * If the length of the chain is zero, the string should contain "Empty 
     * Chain\n"
     * 
     * @return a properly formatted chain object to be displayed
    */
    public String toString()
    {
        if (this.chainBases.length == 0)
        {
            return "Empty Chain\n";
        }

        StringBuilder output = new StringBuilder();
        for (int i = 0; i < this.chainBases.length; i++)
        {
            output.append(this.chainBases[i].toString()); // uses the bases class
            // toString method
            output.append("\n");
        }
        return output.toString();
    }
}
