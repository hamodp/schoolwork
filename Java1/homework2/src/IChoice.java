/*********************************************************************
 * IChoice interface.
 *
 * This is the interface that deals with a single choice in a cast vote.
 *
 * Copyright (C) 2012 by Duncan A. Buell.  All rights reserved.
 *
 * @author Duncan A. Buell
 * @version 1.00 2012-12-21
**/
public interface IChoice
{
/*********************************************************************
 * Accessors and mutators.
**/

/*********************************************************************
 * Accessor method to get the candidate name.
 *
 * @return the candidate
**/
  public String getCandidateName();

/*********************************************************************
 * Accessor method to get the contest name.
 *
 * @return the contest
**/
  public String getContest();

/*********************************************************************
 * Accessor method to get the count;
 *
 * @return the count
**/
  public int getCount();

/*********************************************************************
 * General methods.
**/

/*********************************************************************
 * Method to compare two choices.
 *
 * We choose to compare first on contest, then on candidate name.
 *
 * @return the usual -1, 0, +1 of a comparison
**/
  public int compareTo(Choice that);

/*********************************************************************
 * Method to test two elements for equality.
 *
 * @return the boolean answer
**/
  public boolean equals(Object that);

/*********************************************************************
 * Method to increment the count;
**/
  public void increment();

/*********************************************************************
 * Usual 'toString' method.
 *
 * @return a formatted 'toString' of the class
**/
  public String toString();

} // public interface IChoice
