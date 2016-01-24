
import java.util.ArrayList;
import java.util.Scanner;
/*********************************************************************
 * DoTheWork class
 * the top level class that calls the CastVote class and creates an arraylist
 * of them and then counts the votes 
 * 
 * @author Patrick Hamod
 * @version 1.00 2013-02-04
**/

public class DoTheWork implements IDoTheWork{

	private String pctData;
	private ArrayList<CastVote> castVotes;
	private CastVote cvr;
	private int voteCount = 0;
	private VoteCounts votes;
	
	/*********************************************************************
	 * constructor
	 *
	 * @param inFile file to be read
	**/
	public DoTheWork(Scanner inFile)
	{
		castVotes =new ArrayList<CastVote>();
		this.readFile(inFile);
	}

	/*********************************************************************
	 * method that counts all the votes for certain contests
	 *
	 *@param contest that that is counted
	 * @return string for testing
	**/
	public String countTheVotes(String contest) 
	{
		
		votes= new VoteCounts(voteCount, contest);
		for(CastVote c: castVotes)
		{
			Choice inputChoice = c.getChoiceForContest(contest);
			if(inputChoice != null)
				votes.addToCount(inputChoice);
		}
		return votes.toString();
	}

/***********************************************************************
 * 	takes out unneccessary parts of data and keeps the pct data
 * and takes the name and number
 * code taken from last homework
 * 
 * @param inputLine to test
 * @return aBoolean
 */
	public String getPctInfo(String inputLine) 
	{
		 int index;
		    String subLine;

		    // first we strip away the stuff leading up to the pct info
		    index = inputLine.indexOf("PRECINCT");
		    subLine = inputLine.substring(index);

		    // now we strip away the stuff beyond the pct info
		    index = subLine.indexOf("ELECTION");
		    subLine = subLine.substring(0,index).trim();

		    return subLine;
	}

/***********************************************************************
 * 	returns if the choice is a new choice but part of one vote
 * anyline that is not a new vote and begins with 5
 * 
 * @param inputLine to test
 * @return aBoolean
 */
	public boolean isCastVote(String inputLine) 
	{
		 if(0 == inputLine.indexOf("5"))
		      return true;
		    else
		      return false;
	}
	
/***********************************************************************
 * 	returns if the line is a header the line must contain
 * 'RUN DATE'
 * 
 * @param inputLine to test
 * @return aBoolean
 */
	public boolean isHeader(String inputLine)
	{
		if(inputLine.indexOf("RUN DATE") >= 0)
		      return true;
		    else
		      return false;
	}

/***********************************************************************
 * 	returns if the choice is a new vote marked with *
 * 
 * @param inputLine to test
 * @return aBoolean
 */
	public boolean isNewVote(String inputLine) 
	{
		return inputLine.contains("*");
	}

/*******************************************************************
 * reads through the file and takes the choices and makes cast vote
 * parts of code taken from last homework 
 * isNewVote must preceed isCastVote
 * 
 * @param inFile
 */
	public void readFile(Scanner inFile)
	{
		String inputLine = null;
	    cvr = null;
	    
	    while(inFile.hasNext())
	    {
	      inputLine = inFile.nextLine();
	      if(this.isHeader(inputLine))
	      {
	    	
	        pctData = this.getPctInfo(inputLine);
	       
	      }
	      
	      //adds old record if it exists and creates new cast vote
	      else if(this.isNewVote(inputLine))
	      { 
	    	if(cvr != null)
	    	{
	    		castVotes.add(cvr);
	    		voteCount++;
	    	}
	    	cvr = new CastVote(pctData, inputLine);
	      }
	      
	      else if(this.isCastVote(inputLine))
	      {
	    	 cvr.parseNewVoteInput(pctData, inputLine);
	    	
	      }
	     
	     
	    }//while(inFile.hasNext())
	    //catches last vote
	    voteCount++;
	    castVotes.add(cvr);
	}
	
	/*****************************************************************************
	 * this method gathers all the castvote records and prints them out in the new 
	 * format for the outfile
	 * 
	 * @return output the cast vote records
	 */
	public String toString()
	{
		String output="Beginning of data of "+ this.voteCount + " lines of CVR\n";
		for(CastVote c: castVotes)
		{
			output += c +"\n";
		}
		output += "End of data of "+ this.voteCount +" lines of CVR\n";
		return output;
	}
}
