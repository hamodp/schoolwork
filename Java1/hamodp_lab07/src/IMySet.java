/*********************************************************************
 * Interface for 'MySet'.
 *
 * This is the interface for Lab 07 for a mathematical set.
 *
 * 'addToSet' will add a 'T' to a 'MySet<T>' .
 * @param e the 'T' to add
 * @return the element added, or else null
 *
 * 'card' will return the cardinality of a 'MySet<T>'.
 * @return the cardinality
 *
 * 'containsElement' will test if an 'T' is contained in a 'MySet<T>'.
 * @param e the 'T' to test
 * @return the answer to the question
 *
 * 'containsSet' wil test if one 'MySet<T>' is contained in another.
 * @param thatSet the set to test
 * @return the answer to the question
 *
 * 'equals' will test if two 'MySet<T>' instances are the same.
 * 
 * @param that the 'MySet<T>' to test against
 * @return the answer to the question
 *
 * 'isContainedIn' will test if this set is contained in another.
 * @param thatSet the set to test
 * @return the answer to the question
 *
 * 'isEmpty' will test if this set is empty
 * @return the answer to the question
 *
 * 'removeFromSet' will remove a 'T' from a 'MySet<T>' .
 * @param e the 'T' to remove
 * @param e the 'T' removed, else null
 *
 * Usual 'toString' method.
 * @return a formatted 'toString' of the class
 *
 *
 * Copyright (C) 2012 by Duncan A. Buell.  All rights reserved.
 *
 * @author Duncan A. Buell
 * @version 1.00 2012-12-21
**/
public interface IMySet<T extends Comparable<T>>
{

  public T addToSet(T e);

  public int card();

  public boolean containsElement(T e);

  public boolean containsSet(MySet<T> thatSet);

  public boolean equals(MySet<T> that);

  public boolean isContainedIn(MySet<T> thatSet);

  public boolean isEmpty();

  public T removeFromSet(T e);

  public String toString();

} // public interface IMySet<T>
