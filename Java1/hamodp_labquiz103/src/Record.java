import java.util.ArrayList;
import java.util.Scanner;
/*********************************************************************
 * Class for handling the individual fields in a record.
 *
 * This is essentially just a wrapper for a data payload, which in
 * this case happens to be five <code>String</code> variables, together
 * with a test to see if a string is one of the strings in the payload.
 *
 * Copyright(C) 2013 Duncan A. Buell. All rights reserved. 
 *
 * @author Duncan Buell edited by Patrick Hamod
 * @version 1.00 2013-02-17
**/
public class Record implements IRecord
{
/*********************************************************************
 * Instance variables for the class.
**/
  static private final String DUMMYSTRING = "dummy";

  static private int staticSequenceNumber = -1;
  private int sequenceNumber;

  private ArrayList<String> words;

/*********************************************************************
 * Constructor.
**/
  public Record()
  {
	  staticSequenceNumber++;
	  sequenceNumber = staticSequenceNumber;
	  words = new ArrayList<String>();
  } // public Record()

/*********************************************************************
 * Constructor with data for initialization.
 *
 * @param data the data to be used for initialization.
**/
  public Record(Scanner inFile)
  {
	  staticSequenceNumber++;
	  sequenceNumber = staticSequenceNumber;
	  words = new ArrayList<String>();
	  this.readRecord(inFile);
  } // public Record(Scanner inFile)

/*********************************************************************
 * Accessors and mutators.
**/

/*********************************************************************
 * General methods.
**/

/*********************************************************************
 * Method to test if a word matches the appropriate word in the record.
 *
 * @param wordToMatch the <code>String</code> against which to test.
 * @return the answer to the question
**/
  public boolean isAMatch(String wordToMatch, int position)
  {
	  return wordToMatch.equals(words.get(position));
  } // public boolean matches(String wordToMatch)

/*********************************************************************
 * Method to read the input data from an input <code>Scanner</code>.
 * Note that this is more or less hard coded. Also that we don't
 * bulletproof the input; among other things we assume that partial
 * records don't appear in the input data.
 *
 * @param inFile the <code>Scanner</code> from which to read.
 * @return this instance of a <code>Record</code>.
**/
  private Record readRecord(Scanner inFile)
  {
    String s = "";

    if(inFile.hasNext())
    {
      s = inFile.next();
      this.words.add(s);

      s = inFile.next();
      this.words.add(s);

      s = inFile.next();
      this.words.add(s);

      s = inFile.next();
      this.words.add(s);

      s = inFile.next();
      this.words.add(s);

    } // if(inFile.hasNext())

    return this;
  } // private Record readRecord(Scanner inFile)

/*********************************************************************
 * Method to convert a record to a <code>String</code>.
 *
 * @return the <code>String</code> value of the record.
**/
  public String toString()
  {
    String s = "";

    s += String.format("%4d ", this.sequenceNumber);

    for(String word : words)
    {
      s += String.format("%-15s ", word);
    }

    return s;
  } // public String toString()

} // public class Record implements IRecord
