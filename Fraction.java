/*
 * PROJECT 0
 *
 * This file is a SKELETON file. That means that a number of functions have
 * not been implemented. Your task is to complete the class by filling in the
 * missing methods.
 * 
 * Tasks:
 * 
 * 1) First an important note. This file contains names of public methods
 *    which you should NOT change. Each method is already "preprogrammed" so
 *    the interface (the functions, their parameters and what should be
 *    returned) is fixed and you should NOT change it. Every function has a
 *    description, which outlines:
 *
 *    - The purpose of the function, and intended use;
 *    - The parameters it accepts (if any) indicated by @param;
 *    - What it returns (if anything) indicated by @return.
 *
 * 2) CAREFULLY read through the class definition.
 *
 * 3) Define the methods that are not implemented. They are indicated by a
 *    comment reading "Fill in this method", but for reference, they are:
 * 
 *    - The Fraction(m,n) constructor.
 *    - Convertors: toDouble(), toString()
 *    - Operations with fractions: add(), divide() and multiply()
 * 
 * 4) Add to the class two methods, which are private and accept no
 * parameters:
 *      
 *    - gcd():    computes and returns the greatest common divisor of the
 *                numerator and denominator for this fraction.
 *    - reduce(): uses gcd() to reduce the fraction to irreducible form. e.g.
 *                a fraction 10/20 is simplified to 1/2.
 *
 * 5) The BOSS system will perform specific tests with your class. It will
 *    test: constructor, operators and simplification to irreducible form. So
 *    even if you do not complete all of the methods you will obtain some
 *    credit if others are completed satisfactorily.
 *
 * 6) Finally, fillie in the following fields:
 *
 * NAME: Naglis Jonas Kazlauskas
 * UNIVERSITY ID: u1733125 
 * DEPARTMENT: WBS
 */

/**
 * Classname: Fraction
 * Description: This class implements a new type for fractions
 *              and corresponding arithmetic.
 * 
 * @author : Original: K.N. King, modified by D. Moxey and P. Plechac
 *           for use in the course MA117
 * @version: history: v1.1
 */
import java.util.InputMismatchException;
public class Fraction {
    // ============================================================
    // Instance variables
    // ============================================================
    private int numerator;
    private int denominator;
    
    // ============================================================
    // Constructors
    // ============================================================
    /**
     * Constructor which takes coefficients explicity.
     * 
     * Behaviour: Constructs a fraction with the specified numerator and
     *            denominator. Remember that your fraction should *always* be
     *            stored in irreducible form.
     *
     * @param num   The numerator
     * @param denom The denominator
     */
    public Fraction(int num, int denom) {
        if(denom==0){
            throw new IllegalArgumentException("Denominator can't be zero");
        }
        else if (denom < 0) {
            this.numerator = num * -1;
            this.denominator = denom * -1;
            reduce();
        }
        else {
            this.numerator = num;
            this.denominator = denom;
            reduce();
        }
         
    }

    /**
     * Constructor which takes coefficients explicity.
     *
     * Behaviour: Constructs a fraction which represents an integer: set the
     *            specified numerator and set denominator to 1.
     *
     * @param num The numerator
     */
    public Fraction(int num) {
        // This method is complete.
        this(num, 1);
    }

    /**
     * Default constructor.
     *
     * Behaviour: Constructs a fraction and set the default value to 0;
     *            i.e. numerator = 0 and denominator = 1
     */
    public Fraction() {
        // This method is complete.
        this(0, 1);
    }
    
    
    // ==============================================================
    // Convertors
    //
    // These functions will convert the Fraction to other data types.
    // ==============================================================

    /**
     * Convert the fraction to the floating point representation using double
     * precision.
     * 
     * Behaviour: Converts this fraction into a double.
     *
     * @return    A double value obtained by dividing the fraction's numerator
     *            by its denominator.
     */
    public double toDouble() {
        // Fill in this method. --FILLED
        return (double) numerator/denominator;
    }


    /**
     * Convert the fraction to the floating point representation using the
     * single precision.
     *
     * Behaviour: Converts this fraction into a float value.
     *
     * @return    A float value obtained by dividing the fraction's numerator by
     *            its denominator
     */
    public float toFloat() {
        // This method is complete.
        return (float) numerator / denominator;
    }

    /**
     * Convert the fraction to a string.
     * 
     * Behaviour: Converts this fraction into a string
     *
     * @return    A string of the form "num/denom". If the denominator is 1,
     *            returns a string containing only the numerator.
     */
    public String toString() {
        // Fill in this method. -- FILLED-
        if (numerator==0) {
            String finalString = "0";
            return finalString;
        }
        else if (denominator == 1) {
            String finalString = Integer.toString(numerator);
            return finalString;
        }
        else {
            String finalString = numerator + "/" + denominator;
            return finalString;
        }
    }

    
    // ============================================================
    // Accessors and mutator methods (getters and setters)
    // ============================================================

    /**
     * Get denominator.
     *
     * 
     * Behaviour: Returns the denominator of this fraction.
     *
     * @return    The denominator of this fraction.
     */
    public int getDenominator() {
        // This method is complete.
        return denominator;
    }

    /**
     * Get numerator.
     *
     * Behaviour: Returns the numerator of this fraction.
     *
     * @return    The numerator of this fraction.
     */
    public int getNumerator() {
        // This method is complete.
        return numerator;
    }

    //============================================================
    // Operations with fractions - Core methods
    //============================================================

    /**
     * Addition operation.
     *
     * Behaviour: Adds this fraction to a supplied fraction.
     *
     * @param f  The fraction to be added.
     * @return   The sum of this fraction and f.
     */
    public Fraction add(Fraction f) {
        // Fill in this method. - Filled
        int num   = numerator * f.denominator + f.numerator * denominator;
        int denom = denominator * f.denominator;

        return new Fraction(num, denom);
    }

    /**
     * Subtraction operation.
     * 
     * Behaviour: Subtracts a fraction from this fraction.
     *
     * @param f   The fraction to be subtracted.
     * @return    The difference between this fraction and f.
     *
    //  */
    public Fraction subtract(Fraction f) {
        // This method is complete.
        int num   = numerator * f.denominator - f.numerator * denominator;
        int denom = denominator * f.denominator;
        
        return new Fraction(num, denom);
    }

    /**
     * Division.
     *
     * Behaviour: Divides this fraction by another fraction.
     * 
     * @param f   The fraction to be used as a divisor.
     * @return    The quotient of this fraction and f.
     */
    public Fraction divide(Fraction f) {
        // Fill in this method. - Filled
        int num = numerator * f.denominator;
        int denom = denominator * f.numerator;

        return new Fraction(num, denom);
    }

    /**
     * Multiplication.
     * 
     * Behaviour: Multiplies this fraction and another fraction.
     *
     * @param f   The fraction to be multiplied.
     * @return    The product of this fraction and f.
     */
    public Fraction multiply(Fraction f) {
        // Fill in this method. - Filled
        int num = numerator * f.numerator;
        int denom = denominator * f.denominator;

        return new Fraction(num, denom);
    }

    private int gcd() {
        int num = numerator;
        int den =  denominator;

        while(num!=0 && den!=0) {
            int boomie = den;
            den = num%den;
            num = boomie;
        }

        return Math.abs(num+den); 
    }

    private void reduce() {
        int gcd = gcd();
        this.numerator =  numerator/gcd;
        this.denominator = denominator/gcd;
    }
    
    // ======================================================================
    // END OF USER MODIFIABLE CODE
    //
    // DO NOT CHANGE ANY FUNCTIONS IN THE SECTION BELOW; THEY ARE NEEDED FOR 
    // THE AUTOMATED MARKING SYSTEM. YOUR CODE CANNOT BE MARKED WITHOUT IT!
    // ======================================================================

    /**
     * Compare two fractions.
     *
     * @param  q  The fraction to compare with.
     * @return    true if q is Fraction equal to this fraction .
     */
    public boolean equals(Fraction q) {
        return (numerator   == q.getNumerator() &&
                denominator == q.getDenominator());
    }


}
