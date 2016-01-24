import java.util.ArrayList;
import java.util.Scanner;

/*********************************************************************
 * Lab 03: Parse text for XML tokens with some attributes.
 *
 * Copyright (C) 2012 by Duncan A. Buell.  All rights reserved.
  *
 * @author Patrick Hamod
 * @version 1.00 2012-12-25
**/
public class ParseTokens implements IParseTokens {

	private String currentLn;
	private ArrayList<String> xml; //
	
	public ParseTokens(Scanner inFile)
	{
		xml =new ArrayList<String>();
		parseTokens(inFile);
	}
	
	public ArrayList<String> getOpenTokenList(String s) {
		Scanner localScan = new Scanner(s);
		ArrayList<String> thisList =new ArrayList<String>();
		String word;
		thisList.add("open: ");
		while(localScan.hasNext())
		{
			word = localScan.next();
			 word = word.trim()+" ";
			thisList.add(word);
		}
		System.out.println(s);
		return thisList;
	}

	@Override
	public String getCloseToken(String s) {
		int index;
		index = s.length() -1;
		s = s.substring(0, index);
		return s;
	}

	@Override
	public boolean isCloseTag(String s) {
		return (! s.isEmpty() && s.charAt(0) == '<' &&  s.charAt(1) == '/');
	}

	@Override
	public boolean isOpenTag(String s) {
		
		return (!s.isEmpty() &&s.charAt(0) == '<' &&  s.charAt(1) != '/');
	}

	@Override
	public void parseTokens(Scanner inFile) 
	{
		int index;
		while(inFile.hasNext())
		{
			currentLn = inFile.nextLine();
			currentLn = currentLn.trim();
			if(this.isOpenTag(currentLn))
			{
				String line ="";
				currentLn = currentLn.substring(1, currentLn.length()-1);
				ArrayList<String> openTag = this.getOpenTokenList(currentLn);
				for(String s: openTag)
				{
					line += s;
				}
				xml.add(line);
				//System.out.println(currentLn);
			}
			else if(this.isCloseTag(currentLn))
			{
				
				currentLn = currentLn.substring(2);
				currentLn = this.getCloseToken(currentLn);
				currentLn = "close: "+ currentLn;
				xml.add(currentLn);
				//System.out.println(currentLn);
			}
			else
			{
				currentLn = "data: " + currentLn;
				xml.add(currentLn);
				//System.out.println(currentLn);
			}
			
		}
		
	}
	
	public String toString()
	{
		String output = "";
		
		for(String s: xml)
		{
			output+= s+"\n";
		}
		return output;
	}

}
