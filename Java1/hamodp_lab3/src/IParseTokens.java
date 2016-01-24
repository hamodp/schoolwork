import java.util.ArrayList;
import java.util.Scanner;
/*********************************************************************
 * Interface for 'ParseTokens'.
 *
 * Copyright (C) 2013 by Duncan A. Buell.  All rights reserved.
 * 
 * <code>getOpenTokenList</code> should be passed a string that is the
 *       open XML input with the brackets stripped away, and should 
 *       return an <code>ArrayList</code> of the tokens in the line
 * <code>getCloseToken</code> should get the XML token for a close
 * <code>isCloseTag</code> should determine if the line is a close 
 * <code>isOpenTag</code> should determine if the line is an open
 * <code>parseTokens</code> should read the file line by line,
 *       determining open, close, or data, and add the parsed data
 *       to an <code>ArrayList</code> 
 * <code>toString</code> should return a string of all the data in the
 *       class
 * 
 * @author Duncan A. Buell
 * @version 1.00 2013-02-05
**/
public interface IParseTokens
{
  public ArrayList<String> getOpenTokenList(String s);

  public String getCloseToken(String s);

  public boolean isCloseTag(String s);

  public boolean isOpenTag(String s);

  public void parseTokens(Scanner inFile);

  public String toString();

} // public interface IParseTokens
