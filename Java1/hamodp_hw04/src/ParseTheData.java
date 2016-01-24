import java.io.PrintWriter;
import java.util.EmptyStackException;
import java.util.Scanner;
import java.util.Stack;

/*********************************************************************
 * parses the xml code and tests for proper tags and nesting
 *
 * Copyright (C) 2012 by Duncan A. Buell.  All rights reserved.
 *
 * @author Patrick Hamod
 * @version 1.00 2013-02-28
**/
public class ParseTheData implements IParseTheData{

	private Stack<XMLData> xml;
	private XMLData data;
	private DTD dtd;
	
/***********************************************************************
 * constructor
 * 
 * @param inFile
 * @param outFile
 */
	ParseTheData(Scanner inFile, PrintWriter outFile)
	{
		xml =new Stack<XMLData>();
		dtd =new DTD();
		this.parseTheData(inFile, outFile);
	}
	
/***********************************************************************
 * general purpose methods	
 */


/************************************************************************
 * takes the tags out of <> and checks for the purpose of checking legality
 * of the tag
 * 
 * @param s the tag to be extracted
 */
	public String extractTag(String s) 
	{
		String tag ="";
		if(isOpenTag(s))
		{
			tag = s.substring(1, s.length()-1);
		}
		else
		{
			tag = s.substring(2, s.length()-1);
		}
		return tag;
	}

/************************************************************************
 * checks the tag to see if closing tag by checking for </'tag'>
 * 
 * @param s line to check
 * @return isCloseTag answer to question
 */
	public boolean isCloseTag(String s) {
		return (! s.isEmpty() && s.charAt(0) == '<' && s.charAt(1)== '/');
	}

/************************************************************************
 * checks the tag to see if closing tag by checking for <'tag'>
 * 
 * @param s line to check
 * @return isCloseTag answer to question
 */
	public boolean isOpenTag(String s) {
		return (!s.isEmpty() && s.charAt(0) == '<' &&  s.charAt(1) != '/');
	}

/*************************************************************************
 * this method parses the xml code and prints it to the outfile if the 
 * xml is properly nested otherwise the program will break and throw error 
 * for illegal tag or improper nesting
 * 
 * @param inFile outFile files to read and write to
 */
	public void parseTheData(Scanner inFile, PrintWriter outFile)throws RuntimeException 
	{
		String output ="";
		String line ="";
		XMLData openTag =new XMLData();
		while(inFile.hasNext())
		{
			
			line = inFile.nextLine();
			line = line.trim();
			
			//open tag push onto stack and print out the tag
			if(this.isOpenTag(line))
			{
				
				data =new XMLData(extractTag(line), true);
				xml.push(data);
				output = "open: '" + line +"'  '"+ this.extractTag(line)+"'";
				outFile.println(output);
				line = this.extractTag(line);
				if(!DTD.isLegalTag(line))
				{
					
					throw new RuntimeException(line + " is not a valid xml tag");
				}
			}
			
			//close tag prints out the data and checks for proper nesting
			else if(this.isCloseTag(line))
			{
				data =new XMLData(extractTag(line), true);
				output = "close: '" + line +"'  '"+ this.extractTag(line)+"'";
				outFile.println(output);
				line = this.extractTag(line);
				if(!DTD.isLegalTag(line))
				{
					
					throw new RuntimeException(line + " is not a valid xml tag");
				}
				
				
					openTag = xml.pop();
					while(!openTag.isTag())
					{
						if(openTag.getTagText().equals(data.getTagText()))
						{
							break;
						}
						openTag = xml.pop();
					}
					if(!openTag.getTagText().equals(data.getTagText()))
					{
						throw new RuntimeException(data.getTagText() + " is not properly nested in the xml file");
					}
			}
			
			//gets all other data
			else
			{
				data =new XMLData(line, false);
				xml.push(data);
				outFile.println("data: '"+ line+"'");
				
			}
			
		}//while(inFile.hasNext())
		if(! xml.isEmpty()  )
		{
			throw new RuntimeException(data.getTagText() + " is not properly nested in the xml file");
		}
	}

	
	}
	
