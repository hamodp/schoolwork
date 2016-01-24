import java.util.*;
/*********************************************************************
 * determines the legal tags that can be used in the xml code and
 * checks if the the tags are legal
 *
 *
 * @author Patrick Hamod
 * @version 1.00 2013-02-28
**/
public class DTD implements IDTD{

	private static ArrayList <String> legalTags;  
	
/**********************************************
 * constructors
 */
	DTD(){}
	
	DTD(Scanner inFile)
	{
		legalTags = new ArrayList<String>();
		this.readFile(inFile);
	}
/*******************************************************************************
 * general purpose methods
 */
	
/******************************************************************************
 * this method checks to see if the tag is an xml tag that can be used	
 * 
 * @param tag to check
 * @return isLegalTag answer to the question
 */

	static public boolean isLegalTag(String tag)
	{
		boolean isLegalTag = false;
		
		for(String s: legalTags)
		{
			if(s.compareTo(tag) == 0)
			{
				isLegalTag= true;
				break;
			}
		}
		
		
		return isLegalTag;
	}
	
/*************************************************************************
 * this method reads a file of legal tags to check against the xml code
 * 
 * @param inFile with legal tags
 */
	public void readFile(Scanner inFile) 
	{
		String tag ="";
		while(inFile.hasNext())
		{
			tag = inFile.nextLine();
			legalTags.add(tag);
		}
		
	}
	
/***************************************************************************
 *toString method that prints all of the legal tags
 * 
 * @return output legal strings
 */
	
	public String toString()
	{
		String output="";
		for(String s: legalTags)
		{
			output+= s+"\n";
		}
		return output;
	}

}
