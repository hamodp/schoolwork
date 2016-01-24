/*********************************************************************
 * Element2 class for mathematical sets.
 *
 * This is basically a class that wraps a single variable, which is
 * at this moment just an 'Integer'.
 *
 * Copyright (C) 2013 by Duncan A. Buell.  All rights reserved.
 *
 * @author Duncan A. Buell
 * @version 1.00 2013-02-06
**/
public class Element2 implements Comparable<Element2>
{
  private Integer value;

/*********************************************************************
 * Constructor.
**/
  public Element2()
  {
    this.value = -99999;
  } // public Element2()

/*********************************************************************
 * Constructor.
**/
  public Element2(Integer inputValue)
  {
    this.value = inputValue;
  } // public Element2(integer inputValue)

/*********************************************************************
 * Accessors and mutators.
**/
/*********************************************************************
 * Method to compare two elements.
 *
 * @return the usual -1, 0, +1 of a comparison
**/
  public int compareTo(Element2 that)
  {
    if(this.value < that.getValue())
      return -1;
    else if(this.value > that.getValue())
      return +1;
    else
      return 0;
  } // public int compareTo(Element2 that)

/*********************************************************************
 * Method to test two elements for equality.
 *
 * @return the boolean answer
**/
  public boolean equals(Object that)
  {
    if(null == that)
      return false;
    else
      return (0 == this.value.compareTo(((Element2) that).getValue()));
  } // public boolean equals(Object that)

/*********************************************************************
 * Method to get the <code>value</code>.
 *
 * @return the value of the instance of the class
**/
  public Integer getValue()
  {
    return this.value;
  } // public Integer getValue()

/*********************************************************************
 * General methods.
**/

/*********************************************************************
 * Usual 'toString' method.
 *
 * @return a formatted 'toString' of the class
**/
  public String toString()
  {
    String s = "";

    s += String.format("%d", this.value);

    return s;
  } // public String toString()

} // public class Element2
