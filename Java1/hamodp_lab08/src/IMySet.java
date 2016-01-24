/*********************************************************************
 * Interface for 'MySet'.
 *
 * This is the interface for Lab 08 for a mathematical set.
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

  public T getByID(int id);

  public boolean isContainedIn(MySet<T> thatSet);

  public boolean isEmpty();

  public T removeFromSet(T e);

  public String toString();

} // public interface IMySet<T>
