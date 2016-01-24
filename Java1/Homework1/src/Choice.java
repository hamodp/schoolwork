import java.util.Scanner;
/*********************************************************************
 * Cast Vote.
 *
 * This is the class that deals with a single cast vote choice.
 * also takes line of data and parses each individual datum
 * 
 * Copyright (C) 2012 by Duncan A. Buell.  All rights reserved.
 *
 * @author Duncan A. Buell modified by Patrick Hamod
 * @version 1.00 2012-12-20
**/
public class Choice implements IChoice
{
	
	/********************************************************************
	 * instance variables
	 */
	static private int staticVoteNumber = 0;
	private int localVoteNumber = 0;
	boolean isNewVote;
	private String ballotStyle;
	private String candidateContest;
	private String ivo;
	private String pctName;
    private String pctNumber;
	private String sequenceCode;
	private Scanner scan;
	private String voteFor;
	
	/**********************************************************************
	 * constructor takes line and the pct data to organize list of votes
	 * 
	 * @param pctData
	 * @param inputLine
	 */
	public Choice(String pctData, String inputLine) 
	{
		ballotStyle ="";
		candidateContest= "";
		ivo ="";
		pctName="";
		pctNumber="";
		sequenceCode="";
		voteFor="";
		parseInput(pctData, inputLine);
	}

	/*********************************************************************
	 * Method to extract the precinct information from the 'String'.
	 *
	 * Extracting the pct info means getting rid of the "PRECINCT" and
	 * the hyphen from the input, taking the next piece of the 'String'
	 * as the pct number, and then taking rest of the input 'String'
	 * as the name of the pct.
	 *
	 * We make judicious use of 'trim()' in order to limit ourselves
	 * only to real data.
	 *
	 * @param pctData the 'String' from which to extract
	**/
	public void extractPctData(String pctData) 
	{
		pctData = pctData.trim();
		pctNumber = pctData.substring(0, 3);
		pctName =pctData.substring(5);
	}

	/*********************************************************************
	 * Method to parse an input line to create a cast vote choice.
	 *
	 * First we extract the pct info from the 'pctData' input parameter.
	 *
	 * Then we convert the input line to a 'Scanner' and read off the
	 * info one at a time.
	 *
	 * The only tricky part is that we may or may not have an asterisk
	 * so we have a variable number of strings to extract.
	 *
	 * If we have the asterisk at the appropriate location, we assume
	 * that we have a new vote and we bump that counter.
	 *
	 * @param pctData and inputLine to get scan for variables.
	**/

	public void parseInput(String pctData, String inputLine) 
	{
		extractPctData(pctData);
		scan =new Scanner(inputLine);
		if(inputLine.contains("*"))
		{
			isNewVote = true;
			staticVoteNumber++;
			this.localVoteNumber = staticVoteNumber;
			this.ivo = scan.next();
			this.ballotStyle =scan.next();
			scan.next();
			this.sequenceCode = scan.next();
			this.candidateContest =scan.next();
			
			String name1= scan.next();
			String name2= scan.next();
			
			if(candidateContest.contains("Yes")|| candidateContest.contains("No"))
			{
				voteFor = scan.next()+" "+scan.next()+" "+scan.next();
				
				if(scan.hasNext())
				{
					voteFor= voteFor+" "+scan.next();
				}
				voteFor= "\t\t\t\t\t"+ voteFor;
			}
			else if(! candidateContest.contains("Republican")&&
					!candidateContest.contains("Democratic"))
			{
				if(candidateContest.length()==1 ||name1.length()==1 ||
						candidateContest.equals("W/I"))
				{
					candidateContest = candidateContest+" "+name1+ " "+ name2+ "\t";
				}
				else
				{
					candidateContest = candidateContest+" "+name1+ "\t\t";
					voteFor= name2;
				}
				while(scan.hasNext())
					{
						voteFor= voteFor+" "+scan.next();
					}
				
			}//end else if
		}//end if(input.contains(*))
		
		else{
			isNewVote =false;
			this.localVoteNumber = staticVoteNumber;
			this.ivo = scan.next();
			this.ballotStyle =scan.next();
			this.sequenceCode = scan.next();
			this.candidateContest =scan.next();
			String name1= scan.next();
			String name2= scan.next();
			
			if(candidateContest.contains("Yes")|| candidateContest.contains("No"))
			{
				voteFor = name1 + " "+ name2 +" "+scan.next();
				
				if(scan.hasNext())
				{
					voteFor= voteFor+" "+scan.next();
				}
				
				voteFor= "\t\t\t\t\t"+ voteFor;
			}//end if
			else if(! candidateContest.contains("Republican")&&
					!candidateContest.contains("Democratic"))
			{
				if(candidateContest.length()==1 ||name1.length()==1 ||
						candidateContest.contains("W/I"))
				{
					candidateContest = candidateContest+" "+name1+ " "+ name2+ "\t";
					
				}
				else
				{
					candidateContest = candidateContest+" "+name1+"\t\t\t";
					voteFor= name2;
				}
				while(scan.hasNext())
					{
						voteFor= voteFor+" "+scan.next();
					}
			}
		}
	}
	
	/*********************************************************************
	 * Usual 'toString' method.
	 *
	 * @return a formatted 'toString' of the class
	**/
	public String toString()
	{
		if(isNewVote)
		{
			return(localVoteNumber+"\t"+ pctNumber+" "+pctName+"\t"+ ivo+ " N\t"+ballotStyle
					+ "\t" + sequenceCode+ "\t" +candidateContest+ " "+ voteFor);
		}
		else
		{
			return (localVoteNumber+"\t"+ pctNumber+" "+pctName+"\t"+ ivo+"\t\t" + ballotStyle
					+ "\t" + sequenceCode + "\t" + candidateContest+ "\t"+ voteFor);
		}
	}

}
