import java.util.ArrayList;
import java.util.Scanner;
/*********************************************************************
 * Counter.
 *
 * This class counts from 1 to 2^n in binary with an array and has
 * a Gray code method for converting from a binary array to Gray code.
 *
 * THE ONLY THING TO ESPECIALLY NOTICE about this code is that the
 * array has the bits going backward, but they are turned around into
 * standard notation by the 'toString'. That is, the subscript zero
 * location is the rightmost bit of the number, not the leftmost. 
 * This makes subscripting very much easier, and the user of this
 * code would never have to know that's how it's done.
 *
 *
 * Copyright (C) 2012 by Duncan A. Buell.  All rights reserved.
 *
 * @author Duncan A. Buell modified by Patrick Hamod
 * @version 1.00 2012-12-25
**/
public class Counter
{
  static private ArrayList<Integer> bits;

/*********************************************************************
 * Constructor.
**/
  public Counter(int length)
  {
    bits = new ArrayList<Integer>();
    for(int i = 0; i < length; ++i) bits.add(0); 
  }

/*********************************************************************
 * Accessors and mutators.
**/

/*********************************************************************
 * General methods.
**/

/*********************************************************************
 * Method to return the grayCode value of the counter.
 *
 * compares the binary digits and creates the graycode by adding one if 
 * the digits are not equal
 * 
 * @return output the graycode in proper order
**/
  public String grayCode()
  {
	  ArrayList <Integer> bin = new ArrayList<Integer>();//arraylist containing the graycode bitmask
	  String output ="";
	  
	  for(int i = 0; i < bits.size() - 1; ++i){
          if(bits.get(i) < bits.get(i+1)|| bits.get(i) > bits.get(i + 1)){
                  bin.add(1);
          }
          else{
                  bin.add(0);
          }
	  }
	  bin.add(bits.get(bits.size() -1));
	 
	  for(int i = bits.size() -1; i >= 0; --i){
	          output += " " + bin.get(i).toString();
	  }
	 
	  return output;
  } // public String grayCode()

/*********************************************************************
 * Method to increment the counter.
 *
 * All this does is schoolchild addition with ripple carries.
 * When we run off the top edge, we reset to zero.
**/
  public void increment()
  {
    int carry;
    int digit;
    int sum;
    int length = bits.size();

    carry = 1;
    digit = 0;
    while(1 == carry)
    {
      sum = carry + bits.get(digit);
      bits.set(digit, sum);
      carry = 0;
      if(2 == sum)
      {
        carry = 1;
        sum = 0;
        bits.set(digit, sum);
        ++digit;
        if(digit >= length)
        {
          for(int i = 0; i < length; ++i) bits.set(i, 0); 
          break;
        }
      }
    }
    
  } // public void increment()

/*********************************************************************
 * Usual 'toString' method.
 *
 * As mentioned above, this reverses the order to print in standard
 * notation.
 *
 * @return a formatted 'toString' for the class
**/
  public String toString()
  {
    String s = "";

    for(Integer bit: bits)
    {
      s = String.format("%2d", bit) + s;
    }

    return s;
  } // public String toString()

} // public class Counter
