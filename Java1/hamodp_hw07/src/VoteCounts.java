import java.util.ArrayList;

/*********************************************************************
 * VoteCounts.
 *
 * This class counts the votes for a certain contest
 *
 * Copyright (C) 2012 by Duncan A. Buell.  All rights reserved.
 *
 * @author Duncan A. Buell
 * @version 1.00 2012-12-30
**/
public class VoteCounts implements IVoteCounts{
	private int totalVotes;
	  private String contestName;
	  private ArrayList<Choice> choices;

  /******************************************************************
   * constructor
   */
  public VoteCounts(int totalVotes, String contestName)
  {
	  this.totalVotes =totalVotes;
	  this.contestName =contestName;
	  this.choices = new ArrayList<Choice>();
  }
  
/*********************************************************************
 * Method to add a 'Choice' to the list of choices made by some voter.
 *
 * If the choice already exists in our list, we increment the count.
 * Otherwise, we add to the list and set the vote count to 1.
 *
 * @param choice the 'Choice' to be added.
**/
  
	public void addToCount(Choice choice)
	{
		boolean foundChoice = false;

	    for(Choice c : this.choices)
	    {
	      if(c.equals(choice))
	      {
	        foundChoice = true;
	        c.increment();
	        this.contestName = c.getContest();
	      }
	    } // for(Choice c : this.choices)

	    if(!foundChoice)
	    {
	      Choice newChoice = choice;
	      newChoice.increment();
	      this.choices.add(newChoice);
	      Choices.AddChoice(newChoice);
	    }

	}//public void addToCount(Choice choice)

/**************************************************************************
 * puts the vote data into a string including how many votes did not vite for
 * the contest and the total number of votes
 * 
 * @return output
 */
	public String toString()
	{
		 int totalForCandidates;
		    String output = "";

		    totalForCandidates = 0;
		    for(Choice choice : this.choices)
		    {
		      output += String.format("%5d %-30s %s\n",
		                         choice.getCount(),
		                         choice.getCandidateName(),
		                         choice.getContest());
		      totalForCandidates += choice.getCount();
		    }

		    output += String.format("%5d %-30s %s\n",
		                       totalVotes - totalForCandidates,
		                       "Undervote",
		                       contestName);
		    return output;
	}
}
