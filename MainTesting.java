/*
 * ITEC 120 Assignment 10 - Testing Class
 */

/**
 * This is our test driver class. We are testing the Base, Chain, and Helix 
 * classes from this class. 
 *
 * @author Jeffrey LaMarche
 *
 * @version 1.0 2022-04-18
 * Initial Version
 *
 * @author Abby Ramos Cortez
 *
 * @version 19.0.1 2023-04-29
 */

public class MainTesting
{
    /**
     * The main method that runs tests on the Base, Chain, and Helix classes.
     *
     * @param args the command line arguments.
     */
    public static void main(String[] args)
    {
        
        System.out.println();
        System.out.println("Starting Base testing...");
        System.out.println();
        testBase();
        System.out.println();

        System.out.println("Starting Chain testing...");
        System.out.println();
        testChain();
        System.out.println();
        
        System.out.println("Starting Helix testing...");
        testHelix();
        System.out.println();

        System.out.println();

    }

    /**
     * We are testing the Base class using this method. We create new bases 
     * to test different scenarios and then output the results to see if the 
     * methods are working properly. 
     */
    public static void testBase()
    {
        Base defaultBase = new Base();

        Base base1 = new Base('A');
        Base base2 = new Base('Q');
        Base base3 = new Base('1');
        Base base4 = new Base(' ');
        Base base5 = new Base('?');

        Base base6 = new Base('A', "Adenine");
        Base base7 = new Base(' ', "Empty");
        Base base8 = new Base('Z', "Zer");
        Base base9 = new Base('Q', "UNK");
        Base base10 = new Base('?', "???");

        
        System.out.println("Testing the getBaseInitial method:");
        System.out.printf("%-8s | %-12s\n", "Base Created", "Base Initial");
        System.out.println("-----------------------------");
        printBaseInitial1(defaultBase);
        printBaseInitial1(base1);
        printBaseInitial1(base2);
        printBaseInitial1(base3);
        printBaseInitial1(base4);
        printBaseInitial1(base5);
        printBaseInitial2(base6);
        printBaseInitial2(base7);
        printBaseInitial2(base8);
        printBaseInitial2(base9);
        printBaseInitial2(base10);
        System.out.println();
        
        System.out.println("Testing the getBaseName method:");
        System.out.println("*** NOTE: We have NOT assigned Base Initials to their" +
            " respective Base Name yet. ***");
        System.out.printf("%-8s | %-12s\n", "Base Created", "Base Name");
        System.out.println("-----------------------------");
        printBaseName1(defaultBase);
        printBaseName1(base1);
        printBaseName1(base2);
        printBaseName1(base3);
        printBaseName1(base4);
        printBaseName1(base5);
        printBaseName2(base6);
        printBaseName2(base7);
        printBaseName2(base8);
        printBaseName2(base9);
        printBaseName2(base10);
        System.out.println();
        
        System.out.println("Testing the autoAssignBaseName method:");
        System.out.printf("%-30s | %-30s | %-30s |\n", "Before", "Expected",
            "Actual");
        System.out.println("---------------------------------------------------" +
            "-----------------------------------------------");
        printRow(defaultBase);
        printRow(base1);
        printRow(base2);
        printRow(base3);
        printRow(base4);
        printRow(base5);
        printRow(base6);
        printRow(base7);
        printRow(base8);
        printRow(base9);
        printRow(base10);
        System.out.println("---------------------------------------------------" +
            "-----------------------------------------------");
        System.out.println();
        
        System.out.println("Testing the isBaseValid method:");
        System.out.printf("%-22s | %-22s\n", "Base Created", "Base Valid?");
        System.out.println("----------------------------------------------");
        printIsBaseValid(defaultBase);
        printIsBaseValid(base1);
        printIsBaseValid(base2);
        printIsBaseValid(base3);
        printIsBaseValid(base4);
        printIsBaseValid(base5);
        printIsBaseValid(base6);
        printIsBaseValid(base7);
        printIsBaseValid(base8);
        printIsBaseValid(base9);
        printIsBaseValid(base10);
        System.out.println();
        
        System.out.println("Testing the equals method:");
        System.out.printf("%-21s | %-21s | %-21s |\n", "Base 1", "Base 2",
            "Are they equal to each other?");
        System.out.println("---------------------------------------------------" +
            "----------------------------");
        printEquals(base4, base7);
        printEquals(defaultBase, base7);
        printEquals(base2, base5);
        printEquals(base6, base10);
        System.out.println("---------------------------------------------------" +
            "----------------------------");
        System.out.println();
    }

    /** 
     * Prints out the baseInitial for a constructor that takes in only one 
     * argument - baseInitial
     * 
     * @param base base we created and want the base initial from
    */
    public static void printBaseInitial1(Base base) 
    {
        System.out.printf("Base('%c')    | %-12c\n", 
            base.getBaseInitial(), base.getBaseInitial());
    }

    /** 
     * Prints out the baseInitial for a constructor that takes in two 
     * argument - baseInitial and baseName
     * 
     * @param base base we created and want the base initial from
    */
    public static void printBaseInitial2(Base base) 
    {
        System.out.printf("Base('%c', %-10s) | %-12c\n", base.getBaseInitial(), 
            base.getBaseName(), base.getBaseInitial());
    }

    /** 
     * Prints out the baseName for a constructor that takes in only one argument
     * - baseInitial
     * 
     * @param base base we created and want the base name from
    */
    public static void printBaseName1(Base base)
    {
        System.out.printf("Base('%c')    | %-12s\n", base.getBaseInitial(), 
            base.getBaseName());
    }

    /** 
     * Prints out the baseName for a constructor that takes in two arguments
     * - baseInitial and baseName
     * 
     * @param base base we created and want the base name from
    */
    public static void printBaseName2(Base base)
    {
            System.out.printf("Base('%c', %-10s) | %-12s\n", base.getBaseInitial(), 
            base.getBaseName(), base.getBaseName());
    }

    /** 
     * Prints out before, expected and after the autoAssignBaseName method is 
     * called for a given base
     * 
     * @param base base that is to be tested using the autoAssignBaseName method
    */
    public static void printRow(Base base)
    {
        System.out.printf("%-30s | ", base.toString());
        System.out.printf("%-30s | ", expected(base.getBaseInitial()));
        base.autoAssignBaseName();
        System.out.printf("%-30s |\n", base.toString());
    }

    /** 
     * We're comparing what we obtain in this method against the output we obtain
     * from the autoAssignBaseName method. This method tells us what we should 
     * expect for the autoAssignBaseName method to return.
     * 
     * @param baseInitial the baseInitial which we will use to determine the 
     * baseName
     * @return a String representation of what we expect for the autoAssignBaseName
     * to return
    */
    public static String expected(char baseInitial)
    {
        String output = "";
        switch (baseInitial)
        {
            case Base.ADE:
                output = String.format("{ %c : %-8s }", Base.ADE, Base.ADENINE);
                break;
            case Base.CYT:
                output = String.format("{ %c : %-8s }", Base.CYT, Base.CYTOSINE);
                break;
            case Base.GUA:
                output = String.format("{ %c : %-8s }", Base.GUA, Base.GUANINE);
                break;
            case Base.PYR:
                output = String.format("{ %c : %-8s }", Base.PYR, Base.PYROZINE);
                break;
            case Base.THY:
                output = String.format("{ %c : %-8s }", Base.THY, Base.THYMINE);
                break;
            case Base.ZER:
                output = String.format("{ %c : %-8s }", Base.ZER, Base.ZERAMINE);
                break;
            case Base.EMP:
                output = String.format("{ %c : %-8s }", Base.EMP, "Empty");
                break;
            default:
                output = String.format("{ %c : %-8s }", baseInitial, Base.UNKNOWN);
                break;
        }
        return output;
    }

    /** 
     * Prints out base we created and if the base is valid 
     * 
     * @param base the base we would like to determine if it is valid
    */
    public static void printIsBaseValid(Base base)
    {
        System.out.printf("Base('%c', %-10s)  |  %-12b\n", base.getBaseInitial(),
            base.getBaseName(), base.isBaseValid());
    }

    /** 
     * Prints out the bases we created and if they equal each other
     * 
     * @param base1 a base object we're comparing another base object to 
     * @param base2 a base object we're comparing another base object to 
    */
    public static void printEquals(Base base1, Base base2)
    {
        System.out.printf("Base('%c', %-10s) | Base('%c', %-10s) | %-10b\n", 
            base1.getBaseInitial(), base1.getBaseName(), base2.getBaseInitial(),
            base2.getBaseName(), base1.equals(base2));
    }

    
    
    /**
     * We are testing the Chain class using this method.
     */
    public static void testChain()
    {
        Chain defaultChain = new Chain();
        Chain chain1 = new Chain(-2);
        Chain chain2 = new Chain(0);
        Chain chain3 = new Chain(5);
        Chain chain4 = new Chain("gattaca");
        Chain chain5 = new Chain("acattag");
        Chain chain6 = new Chain("19dcnje");
        Base base6 = new Base('A', "Adenine");

        
        System.out.println("Testing the getLength method:");
        System.out.printf("%-30s | %-30s\n", "Chain Created", "Length");
        System.out.println("---------------------------------------------------" +
            "-----------");
        printGetLength("", defaultChain);
        printGetLength("-2",chain1);
        printGetLength("0", chain2);
        printGetLength("5", chain3);
        printGetLength("gattaca", chain4);
        printGetLength("acattag", chain5);
        printGetLength("19dcnje", chain6);
        System.out.println();

        System.out.println("Testing the getBase method:");
        printGetBase(chain3, 2);
        printGetBase(chain4, 3);
        printGetBase(chain5, 4);
        System.out.println();
        
        System.out.println("Testing the setBase method:");
        printSetBase(chain4, 3, base6);
        printSetBase(chain5, 6, base6);
        printSetBase(chain6, 0, base6);
        System.out.println();
        
        System.out.println("Testing the isChainValid method:");
        printIsChainValid(chain3);
        printIsChainValid(chain4);
        printIsChainValid(chain5);
        System.out.println();
        
        System.out.println("Testing the equals method:");
        printEquals(defaultChain, chain2);
        printEquals(chain1, chain5);
        printEquals(chain3, chain4);
        
    }

    /** 
     * Prints out the chain object we created and the length of the chain object
     * 
     * @param input a string that represents either a string(created a chain 
     * object using this string ) or an integer (created a chain object using 
     * this integer as the length of the chain object)
     * @param chain the chain object we created with the given input
    */
    public static void printGetLength(String input, Chain chain)
    {
        System.out.printf("Chain(%-23s) | %-5d\n", input, chain.getLength());
    }
    
    /** 
     * Prints out the chain we created, index, and the base at the given index
     * 
     * @param chain the chain object we created
     * @param index representes the index of the base we are interested in 
     * in the chain object
    */
    public static void printGetBase(Chain chain, int index)
    {
        System.out.println("============ Testing New Chain ============");
        System.out.println("Chain Created: ");
        System.out.print(chain.toString());
        System.out.printf("%-20s | %-20s\n", "Index", "Base");
        System.out.println("------------------------------------------");
        System.out.printf("%-20d | %-20s\n", index, chain.getBase(index));
        System.out.println("=================== End ===================");
        System.out.println();
    }

    /** 
     * Prints out the chain object, index, and the base we want to set the base
     * that is at the given index to.
     * 
     * @param chain the chain object
     * @param index the index of the chain object we would like to set the 
     * given base to
     * @param base the base we want to set the base at the given index to
    */
    public static void printSetBase(Chain chain, int index, Base base)
    {
        System.out.println("============ Testing New Chain ============");
        System.out.println("Chain Created: ");
        System.out.print(chain.toString());
        System.out.println();
        System.out.printf("%-20s | %-20s | %-20s\n", "Index", "Current Base", 
            "New Base");
        System.out.println("------------------------------------------------" +
            "---------------");
        System.out.printf("%-20d | %-20s | %-20s\n", index, chain.getBase(index),
            base);
        chain.setBase(index, base);
        System.out.println();
        System.out.println("New Chain Created: ");
        System.out.print(chain.toString());
        System.out.println("=================== End ===================");
        System.out.println();
    }

    /** 
     * prints out the chain we created and if it is valid
     * 
     * @param chain the chain object to test
    */
    public static void printIsChainValid(Chain chain)
    {
        System.out.println("============ Testing New Chain ============");
        System.out.println("Chain Created: ");
        System.out.print(chain.toString());
        System.out.println();
        System.out.printf("Valid?: %b\n", chain.isChainValid());
        System.out.println();
        System.out.println("=================== End ===================");
        System.out.println();
    }

    /** 
     * Prints out the two chain objects and if they are equal to each other
     * 
     * @param chainOne the first chain object to be compared against the second
     * chain object
     * @param chainTwo the second chain object to be compared against the first
     * chain object
    */
    public static void printEquals(Chain chain1, Chain chain2)
    {
        System.out.println("============ Testing New Chains ============");
        System.out.println("Chain 1 Created: ");
        System.out.print(chain1.toString());
        System.out.println();
        System.out.println("Chain 2 Created: ");
        System.out.print(chain2.toString());
        System.out.println();
        System.out.printf("Do the chains equal each other?: %b\n", 
            chain1.equals(chain2));
        System.out.println();
        System.out.println("=================== End ===================");
        System.out.println();
    }
    
    /**
     * We are testing the Helix class using this method.
     */
    public static void testHelix()
    {
        Helix helix1 = new Helix("gattaca");
        Helix helix2 = new Helix("? cattac");
        Helix helix3 = new Helix("gattaca", "CTAATGT");
        Helix helix4 = new Helix("cat", "mouse");
        
        System.out.println("Testing the createChainTwo method:");
        printCreateChainTwo(helix1, helix2);
        
        helix1.createChainTwo();
        helix2.createChainTwo();
        
        System.out.println("Testing the isHelixValid method:");
        printIsHelixValid(helix1);
        printIsHelixValid(helix2);
        

        System.out.println("Testing the equals method:");
        printEquals(helix1, helix3);
        printEquals(helix2, helix4);
        printEquals(helix2, helix3);
    }

    /** 
     * Prints out what is expected and the actual output of the createChainTwo 
     * method
     * 
     * @param helix1 a helix object to test
     * @param helix2 a helix object to test
    */
    public static void printCreateChainTwo(Helix helix1, Helix helix2)
    {
        System.out.println("Expected: ");
        System.out.println("{ G : Guanine  } ---- { C : Cytosine }");
        System.out.println("{ A : Adenine  } ---- { T : Thymine  }");
        System.out.println("{ T : Thymine  } ---- { A : Adenine  }");
        System.out.println("{ T : Thymine  } ---- { A : Adenine  }");
        System.out.println("{ A : Adenine  } ---- { T : Thymine  }");
        System.out.println("{ C : Cytosine } ---- { G : Guanine  }");
        System.out.println("{ A : Adenine  } ---- { T : Thymine  }");

        helix1.createChainTwo();
        System.out.println();
        System.out.println("Actual: ");
        System.out.println(helix1.toString());
        System.out.println("--------------------------------------");
        System.out.println();

        System.out.println("Expected: ");
        System.out.println("{ ? : ???      } ---- { ? : ???      }");
        System.out.println("{   : Empty    } ---- {   : Empty    }");
        System.out.println("{ C : Cytosine } ---- { G : Guanine  }");
        System.out.println("{ A : Adenine  } ---- { T : Thymine  }");
        System.out.println("{ T : Thymine  } ---- { A : Adenine  }");
        System.out.println("{ T : Thymine  } ---- { A : Adenine  }");
        System.out.println("{ A : Adenine  } ---- { T : Thymine  }");
        System.out.println("{ C : Cytosine } ---- { G : Guanine  }");

        helix2.createChainTwo();
        System.out.println();
        System.out.println("Actual: ");
        System.out.println(helix2.toString());
        System.out.println("--------------------------------------");
        System.out.println();

        System.out.println("Expected: ");
        System.out.println("{ G : Guanine  } ---- { C : Cytosine }");
        System.out.println("{ A : Adenine  } ---- { T : Thymine  }");
        System.out.println("{ T : Thymine  } ---- { A : Adenine  }");
        System.out.println("{ T : Thymine  } ---- { A : Adenine  }");
        System.out.println("{ A : Adenine  } ---- { T : Thymine  }");
        System.out.println("{ C : Cytosine } ---- { G : Guanine  }");
        System.out.println("{ A : Adenine  } ---- { T : Thymine  }");
        System.out.println();
    }

    /** 
     * Prints out the helix we created and if it is valid
     * 
     * @param helix the helix we are checking to see it if it is valid
    */
    public static void printIsHelixValid(Helix helix)
    {
        System.out.println("---------- New Helix Being Tested ----------");
        System.out.println("Helix: ");
        System.out.println(helix.toString());
        System.out.printf("Is the Helix Valid?: %b\n", helix.isHelixValid());
        System.out.println();
    }

    /** 
     * Prints out the two helix's and checks if they're equal to each other
     * 
     * @param helix1 a helix object to compare against
     * @param helix2 a helix object to compare against
    */
    public static void printEquals(Helix helix1, Helix helix2)
    {
        System.out.println("============ Testing New Helix's ============");
        System.out.println("Helix 1: ");
        System.out.print(helix1.toString());
        System.out.println();
        System.out.println("Helix 2: ");
        System.out.print(helix2.toString());
        System.out.println();
        System.out.printf("Do the Helix's equal each other?: %b\n", 
            helix1.equals(helix2));
        System.out.println();
        System.out.println("=================== End ===================");
        System.out.println();
    }
}
