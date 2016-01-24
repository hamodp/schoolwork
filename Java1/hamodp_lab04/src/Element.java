/*********************************************************************
 * Element class for mathematical sets.
 *
 * This is basically a class that wraps a single variable, which is
 * at this moment just a 'String'.
 *
 * Copyright (C) 2012 by Duncan A. Buell.  All rights reserved.
 *
 * @author Duncan A. Buell
 * @version 1.00 2012-12-21
**/
public class Element implements Comparable<Element>
{
  private String value;

/*********************************************************************
 * Constructor.
**/
  public Element()
  {
    this.value = "dummyvalue";
  } // public Element()

/*********************************************************************
 * Constructor.
**/
  public Element(String inputValue)
  {
    this.value = inputValue;
  } // public Element(String inputValue)

/*********************************************************************
 * Accessors and mutators.
**/
/*********************************************************************
 * Method to compare two elements.
 *
 * @return the usual -1, 0, +1 of a comparison
**/
  public int compareTo(Element that)
  {
    return this.value.compareTo(that.getValue());
  } // public int compareTo(Element that)

/*********************************************************************
 * Method to test two elements for equality.
 *
 * @return the boolean answer
**/
  public boolean equals(Object that)
  {
    return (0 == this.value.compareTo(((Element) that).getValue()));
  } // public boolean equals(Element that)

/*********************************************************************
 * Method to get the <code>value</code>.
 *
 * @return the value of the instance of the class
**/
  public String getValue()
  {
    return this.value;
  } // public String getValue()

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

    s += String.format("%s", this.value);

    return s;
  } // public String toString()

} // public class Element
