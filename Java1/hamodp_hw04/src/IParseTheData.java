import java.io.PrintWriter;
import java.util.Scanner;
/*********************************************************************
 * Interface for <code>ParseTheData<code>.
 *
 * You will need at least the 'xmlStack' as an instance variable.
 *
 * The 'extractTag' method should take in a string that is the
 * input line, known to be an open or close tag, should remove
 * the angle brackets, and return what's inside the angle brackets.
 *
 * Methods 'isCloseTag' and 'isOpenTag' come from the earlier lab
 * and need to check for angle brackets and then possibly the
 * slash in the character at position 1.
 *
 * Method 'parseTheData' is the one that actually does the main
 * work of this application, to read the data, process the stack
 * (or manage the stack if you want to pass the work off to a
 * helper method or two), and log the input lines after you have
 * determined what they are.
 *
 * Since it's not clear what a 'toString' method would output in
 * the case of this class, we are not going to require that you
 * implement one.
 *
 * Copyright (C) 2013 by Duncan A. Buell.  All rights reserved.
 *
 * @author Duncan A. Buell used by Patrick Hamod
 * @version 1.00 2013-02-13
**/
public interface IParseTheData
{
/*********************************************************************
 * Instance variables for the class.
**/
//  Stack<XMLData> xmlStack = null;

  public String extractTag(String s);

  public boolean isCloseTag(String s);

  public boolean isOpenTag(String s);

  public void parseTheData(Scanner inFile, PrintWriter outFile);

} // public interface IParseTheData
