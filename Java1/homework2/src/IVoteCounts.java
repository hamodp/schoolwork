/*********************************************************************
 * IVoteCounts.
 *
 * This is the interface for the class that deals with the vote counts.
 *
 * Copyright (C) 2012 by Duncan A. Buell.  All rights reserved.
 *
 * @author Duncan A. Buell
 * @version 1.00 2012-12-30
**/
public interface IVoteCounts
{
//  private int totalVotes;
//  private String contestName;
//  private ArrayList<Choice> choices;

/*********************************************************************
 * Constructor.
**/
//  public VoteCounts(int totalVotes, String contestName)

/*********************************************************************
 * Accessors and mutators.
**/

/*********************************************************************
 * General methods.
**/

/*********************************************************************
 * Method to add a 'Choice' to the list of choices made by some voter.
 *
 * If the choice already exists in our list, we increment the count.
 * Otherwise, we add to the list and set the vote count to 1.
 *
 * @param choice the 'Choice' to be added.
**/
  public void addToCount(Choice choice);

/*********************************************************************
 * Usual 'toString' method.
 *
 * @return a formatted 'toString' of the class
**/
  public String toString();

} // public interface IVoteCounts
