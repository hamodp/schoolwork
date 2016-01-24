/*********************************************************************
 * Interface for 'MySet'.
 *
 * This is the interface for Lab 02 for a mathematical set.
 *
 * Copyright (C) 2012 by Duncan A. Buell.  All rights reserved.
 *
 * @author Duncan A. Buell
 * @version 1.00 2012-12-21
**/
public interface IMySet
{

/*********************************************************************
 * Accessors and mutators.
**/

/*********************************************************************
 * General methods.
**/

/*********************************************************************
 * Method to add an 'Element' to a 'MySet' .
 *
 * @param e the 'Element' to add
**/
  public Element addToSet(Element e);

/*********************************************************************
 * Method to return the cardinality of a 'MySet'.
 *
 * @return the cardinality
**/
  public int card();

/*********************************************************************
 * Method to test if an 'Element' is contained in a 'MySet'.
 *
 * @param e the 'Element' to test
 * @return the answer to the question
**/
  public boolean containsElement(Element e);

/*********************************************************************
 * Method to test if two 'MySet' instances are the same.
 *
 * @param that the 'MySet' to test against
 * @return the answer to the question
**/
  public boolean equals(MySet that);

/*********************************************************************
 * Method to return the 'isEmpty' of a set.
 *
 * @return the answer to the question
**/
  public boolean isEmpty();

/*********************************************************************
 * Method to remove an 'Element' from a 'MySet' .
 *
 * @param e the 'Element' to remove
**/
  public Element removeFromSet(Element e);

/*********************************************************************
 * Usual 'toString' method.
 *
 * @return a formatted 'toString' of the class
**/
  public String toString();

} // public interface IMySet
