

import java.util.*;

/*********************************************************************
 * Application class for reading the EL155 and parsing into an
 * 'ArrayList' of cast vote records.
 *
 * This class is passed a file as an input 'Scanner' and reads that
 * file into an 'ArrayList', each entry of which is a 'Choice'.
 * Because the precinct name and number come only from the header
 * line, this 'String' is also passed in to the constructor and is
 * parsed. 
 *
 * Rules: parsing the header lines is done in this class.
 *        parsing the actual cast vote lines is done in 'Choice'.
 *
 * Copyright (C) 2012 by Duncan A. Buell.  All rights reserved.
 *
 * @author Duncan A. Buell modified by Patrick Hamod
 * @version 1.00 2012-12-20
**/
public class ReadTheFile implements IReadTheFile
{

	/*********************************************************************
	 * Instance variables for the class.
	 * i counts the arraylist indices to return to the Driver class
	 * j is var to compare with i
	**/
	
	
	private static ArrayList <Choice> theList =new ArrayList<Choice>();
	private static String pctData;
	
	private String inputLine;
	private Choice vote;
	
	
	/*********************************************************************
	 * Constructor.
	 *
	 * @param inFile the 'Scanner' from which to create the list
	 */
	public ReadTheFile(Scanner inFile)
	  {
	    
		this.readFile(inFile);
	    
	  } // public ReadTheFile(Scanner inFile)
	 
	/*********************************************************************
	 * Method to get the precinct from the input header line.
	 * This method knows that precinct info starts with the 'String'
	 * "PRECINCT" and ends before the 'String' "ELECTION".
	 *
	 * @param inputLine the line to parse
	 * @return the precinct
	**/
	public String getPctData(String inputLine) {
		
			pctData =inputLine.substring(60, 108);
			return pctData;
	}

	/*********************************************************************
	 * Method to determine if the line is a cast vote choice.
	 *
	 * The definition of being a cast vote choice is that the zeroth char 
	 * is a leading '5' in an iVotronic serial number.
	 *
	 * @param inputLine the line to parse
	 * @return the answer to the question
	**/
	public boolean isChoice(String inputLine) {
		return inputLine.startsWith("5");
		
	}

	/*********************************************************************
	 * Method to determine if the line is a header line.
	 *
	 * The definition of being a header line is that the line begins
	 * with the 'String' "RUN DATE".
	 *
	 * @param inputLine the line to parse
	 * @return the answer to the question
	**/
	public boolean isHeader(String inputLine) {	
		return inputLine.startsWith("RUN DATE");
		
	}

/*********************************************************************
 * Method to read the cast vote records into the 'ArrayList'.
 *
 * We read line by line. If it's a header, we pull off the pct info.
 * If not a header but is a cast vote line, we create a new 'Choice'
 * with the pct data and the line and add the 'Choice' to the
 * 'ArrayList'. 
 *
 * @param inFile the Scanner from which to read. 
**/
	public void readFile(Scanner inFile) {
		
		Scanner localScanner = null;
		
			localScanner = new Scanner(inFile.nextLine());
			while(localScanner.hasNext())
			{
				inputLine = localScanner.nextLine();
				if(isHeader(inputLine))
				{
					getPctData(inputLine);
					
				}
				else if(isChoice(inputLine))
				{
					vote =new Choice(pctData, inputLine);
					
					theList.add(vote);
					
				}
			}	
			localScanner.close();
		//outFile.close();
	
	}
	
/*********************************************************************
 * Method to <code>toString</code> the class.
 *
 * @return the <code>toString<c/ode> of the list.
**/
	public String toString()
	{
		String output = "";
		for(Choice c: theList)
		{
			output += (c+ "\n");
		}
		return output;
	}

	
}