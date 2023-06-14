/*
 * ITEC 120 Assignment 10 - Base Class
 */

/**
 * In this class, we create the base object which we will use for the next 
 * assignment. We create class variables, attributes and methods.
 *
 * @author Jeffrey LaMarche
 *
 * @version 1.0 2022-04-18
 * Initial Version
 *
 * @author Abby Ramos Cortez
 *
 * @version 19.0.1 2023-04-21
 */
public class Base
{
    /*
     * Initials for the six known nucleobases.
     */
    public static final char ADE = 'A';
    public static final char CYT = 'C';
    public static final char GUA = 'G';
    public static final char PYR = 'P';
    public static final char THY = 'T';
    public static final char ZER = 'Z';

    /*
     * Used when the base is currently unknown.
     */
    public static final char UNK = '?';

    /*
     * Used when the base is currently empty.
     */
    public static final char EMP = ' ';

    /*
     * String names of the known nucleobases.
     */
    public static final String ADENINE = "Adenine";
    public static final String CYTOSINE = "Cytosine";
    public static final String GUANINE = "Guanine";
    public static final String PYROZINE = "Pyrozine";
    public static final String THYMINE = "Thymine";
    public static final String ZERAMINE = "Zeramine";

    /*
     * Used when the base is currently unknown.
     */
    public static final String UNKNOWN = "???";

    /*
     * Used when the base is currently empty.
     */
    private static final String EMPTY = "Empty";

    private char baseInitial;
    private String baseName;

    /** 
     * The default constructor sets the baseInitial to a single space character
     * and the baseName to empty status.
    */
    public Base()
    {
        this.baseInitial = EMP;
        this.baseName = EMPTY;

    }

    /** 
     * The value constructor allows setting the baseInitial attribute to a 
     * specific value. The baseName is set to empty status. 
     * 
     * @param baseInitial a single character the user specifies
    */
    public Base(char baseInitial)
    {
        this.baseInitial = baseInitial;
        this.baseName = EMPTY;
    }

    /** 
     * The value constructor allows setting the baseInitial attribute to
     * a specific value and the baseName to a specific value.
     * 
     * @param baseInitial a single character the user specifies
     * @param baseName a string the user specifies
    */
    public Base(char baseInitial, String baseName)
    {
        this.baseInitial = baseInitial;
        this.baseName = baseName;
    }

    /** 
     * Since the baseInitial attribute of the Base object is private, we cannot
     * access it without either changing it to public or creating a method to 
     * access it. We utilize this method to return the baseInitial attribute of
     * the Base object.
     * 
     * @return the baseInitial attribute of the Base object
    */
    public char getBaseInitial()
    {
        return this.baseInitial;
    }

    /** 
     * Since the baseName attribute of the Base object is private, we cannot
     * access it without either changing it to public or creating a method to 
     * access it. We utilize this method to return the baseName attribute of
     * the Base object.
     * 
     * @return the baseName attribute of the Base object
    */
    public String getBaseName()
    {
        return this.baseName;
    }

    /** 
     * This method attempts to auto-assign what the Base object name is from 
     * the initial letter value. If the initial matches one of the known names,
     * including being empty, the name is set to that value. If it cannot find 
     * a match, then the name is set to the unknown status (question marks). 
    */
    public void autoAssignBaseName()
    {
        /*
        Using the switch statement to determine if the baseInitial of this 
        Base object matches an initial of the six nucleotides. If it does,
        then the corresponding baseName is set to that.
        */
        switch (this.baseInitial)
        {
            case ADE:
                this.baseName = ADENINE;
                break;
            case CYT:
                this.baseName = CYTOSINE;
                break;
            case GUA:
                this.baseName = GUANINE;
                break;
            case PYR:
                this.baseName = PYROZINE;
                break;
            case THY:
                this.baseName = THYMINE;
                break;
            case ZER:
                this.baseName = ZERAMINE;
                break;
            case EMP:
                this.baseName = EMPTY;
                break;
            default:
                this.baseName = UNKNOWN;
                break;
        }
    }

    /** 
     * This method attempts to determine if the Base object is valid. A valid 
     * Base object (true) has an initial (A, C, G, P, T, Z, and ?) that 
     * corresponds to the correct matching name. Empty bases, and initials and 
     * names that do not match correctly are both considered invalid bases 
     * (false). 
     * 
     * @return true if it is a valid base, false otherwise.
    */
    public boolean isBaseValid() 
    {
        this.autoAssignBaseName();
        if ((this.baseInitial == ADE && this.baseName.equals(ADENINE)) ||
            (this.baseInitial == CYT && this.baseName.equals(CYTOSINE)) ||
            (this.baseInitial == GUA && this.baseName.equals(GUANINE)) ||
            (this.baseInitial == PYR && this.baseName.equals(PYROZINE)) ||
            (this.baseInitial == THY && this.baseName.equals(THYMINE)) ||
            (this.baseInitial == ZER && this.baseName.equals(ZERAMINE)) ||
            (this.baseInitial == UNK && this.baseName.equals(UNKNOWN)))
        {
            return true;
        }
        return false;
    }


    /** 
     * This method determines if two Base objects are equal. This means that 
     * both the baseInitialattribute and the baseName attribute are equal in 
     * both objects. (This base object versus that base oject.)
     * 
     * @param that a base object we are comparing against
     * @return true if the two objects are equal, false otherwise
    */
    public boolean equals(Base that)
    {
        return this.baseInitial == that.baseInitial && 
            this.baseName == that.baseName;
    }

    /** 
     * This method provides a String representation of a single Base object. 
     * There is no newline added to the end of the string that this method 
     * produces.
     * 
     * @return a String representation of a single Base object
    */
    public String toString()
    {
        return String.format("{ %c : %-8s }", baseInitial, baseName);
    }
}
