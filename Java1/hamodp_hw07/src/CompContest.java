import java.util.Comparator;

/*********************************************************************
 * CompContest: compares and sorts choices based on contest and candidate
 *
 * Copyright (C) 2013 by Patrick Hamod.  All rights reserved.
 *
 * @author Patrick Hamod
 * @version 1.00 2013-04-22
**/
public class CompContest implements Comparator<Choice> {

/********************************************************************
 * this method is the comparator to allow comparison
 */
	public int compare(Choice o1, Choice o2)
	{
		if(o1.getContest().compareTo(o2.getContest()) < 0)
	    {
	      return -1;
	    }
	    else if(o1.getContest().compareTo(o2.getContest()) > 0)
	    {
	      return +1;
	    }
	    else
	    {
	      if(o1.getCandidateName().compareTo(o2.getCandidateName()) < 0)
	      {
	        return -1;
	      }
	      else if(o1.getCandidateName().compareTo(o2.getCandidateName()) > 0)
	      {
	        return +1;
	      }
	    }
	  return 0;
	 }
}
