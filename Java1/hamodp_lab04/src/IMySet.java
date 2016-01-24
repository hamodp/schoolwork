
/*********************************************************************
 * Interface for 'MySet'.
 *
 * This is the interface for Lab 04 for a mathematical set.
 *
 * Copyright (C) 2013 by Duncan A. Buell.  All rights reserved.
 *
 * @author Duncan A. Buell
 * @version 1.00 2013-02-06
**/
public interface IMySet<T extends Comparable<T>>
{

/*********************************************************************
 * Accessors and mutators.
**/

/*********************************************************************
 * General methods.
**/

/*********************************************************************
 * Method to add an 'T' to a 'MySet<T>' .
 *
 * @param e the 'T' to add
 * @return the element, if successfully added, else null
**/
  public T addToSet(T e);

/*********************************************************************
 * Method to return the cardinality of a 'MySet<T>'.
 *
 * @return the cardinality
**/
  public int card();

/*********************************************************************
 * Method to test if an 'T' is contained in a 'MySet<T>'.
 *
 * @param e the 'T' to test
 * @return the answer to the question
**/
  public boolean containsElement(T e);

/*********************************************************************
 * Method to test if one 'MySet<T>' is contained in another.
 *
 * @param thatSet the set to test against
 * @return the answer to the question
**/
  public boolean containsSet(MySet<T> thatSet);

/*********************************************************************
 * Method to test if two 'MySet<T>' instances are the same.
 *
 * @param that the 'MySet<T>' to test against
 * @return the answer to the question
**/
  public boolean equals(MySet<T> that);

/*********************************************************************
 * Method to return the 'isContainedIn' for one set in another.
 *
 * @param thatSet the set to test against
 * @return the answer to the question
**/
  public boolean isContainedIn(MySet<T> thatSet);

/*********************************************************************
 * Method to return the 'isEmpty' of a set.
 *
 * @return the answer to the question
**/
  public boolean isEmpty();

/*********************************************************************
 * Method to remove an 'T' from a 'MySet<T>' .
 *
 * @param e the 'T' to remove
 * @return the element, if successfully removed, else null
**/
  public T removeFromSet(T e);

/*********************************************************************
 * Usual 'toString' method.
 *
 * @return a formatted 'toString' of the class
**/
  public String toString();

} // public interface IMySet<T>
