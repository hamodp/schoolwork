import java.util.Scanner;
/*********************************************************************
 * Class to handle a single phonebook-like record of
 * <code>String</code> data.
 * There is essentially no code in here whose purpose is not obvious.
 *
 * We have instance variables and their accessors and mutators.
 *
 * We have a <code>toString</code> for output, and a not-very-well
 * written method to read data (that is not very well written in that
 * we have not bulletproofed the code for possible invalid inputs).
 *
 * We also have a method to compare records by last name, a method
 * to compare records in general (that happens at this point to be
 * comparing by last name), and a method that overrides
 * <code>equals</code> so we can test the contents of one record
 * against another for containment and removal.
 *
 * Copyright (C) 2011 by Duncan A. Buell.  All rights reserved.
 *
 * @author Duncan A. Buell used by Patrick Hamod
 * @version 1.00 2011-01-11
**/
public class Record implements Comparable<Record>
{
/*********************************************************************
 * Instance variables for the class.
**/
  private static final String DUMMYSTRING = "dummy";
  private static final int DUMMYINT = Integer.MIN_VALUE;
  private int teaching;  /** the course number being taught */
  private String name;   /** the last name                  */
  private String office; /** the office 'number'            */
  private String phone;  /** the phone 'number'             */

/*********************************************************************
 * Constructor.
**/
  public Record(Scanner inFile)
  {
    this.name = Record.DUMMYSTRING;
    this.office = Record.DUMMYSTRING;
    this.phone = Record.DUMMYSTRING;
    this.teaching = Record.DUMMYINT;

    this.readRecord(inFile);
  } // public Record()

/*********************************************************************
 * Accessors and mutators.
**/
/*********************************************************************
 * Accessor for the <code>name</code>.
 *
 * @return the value of <code>name</code>.
**/
  public String getName()
  {
    return this.name;
  } // public String getName()

/*********************************************************************
 * Accessor for the <code>office</code>.
 *
 * @return the value of <code>office</code>.
**/
  public String getOffice()
  {
    return this.office;
  } // public String getOffice()

/*********************************************************************
 * Accessor for the <code>phone</code>.
 *
 * @return the value of <code>phone</code>.
**/
  public String getPhone()
  {
    return this.phone;
  } // public String getPhone()

/*********************************************************************
 * Accessor for the <code>teaching</code>.
 *
 * @return the value of <code>teaching</code>.
**/
  public int getTeaching()
  {
    return this.teaching;
  } // public int getTeaching()

/*********************************************************************
 * General methods.
**/

/*********************************************************************
 * Method to compare the <code>name</code> values of records.
 * Note that we are relying here on the fact that we know that the
 * <code>name</code> is data of <code>String</code> type.
 *
 * @return -1, 0, or +1 according as the comparison goes.
**/
  public int compareTo(Record that)
  {
    int returnValue;

    returnValue = 0;

    // this sort works on the name
    if(this.getName().compareTo(that.getName()) < 0)
    {
      returnValue = -1;
    }
    else if(this.getName().compareTo(that.getName()) > 0)
    {
      returnValue = +1;
    }
    else
    {
      returnValue = 0;
    }

    return returnValue;
  } // public int compareTo(Record that)

/*********************************************************************
 * Method to override the <code>equals</code> method.
 * We will declare two records to be equal if their data values are 
 * equal, not if they are identical objects.
 *
 * @param that the <code>Record</code> to be compared against.
 * 
 * @return boolean answer to the question.
**/
  public boolean equals(Object thatObject)
  {
    boolean returnValue;

    returnValue = true;

    Record that = (Record) thatObject;

    returnValue = returnValue && this.getName().equals(that.getName());
    returnValue = returnValue && this.getOffice().equals(that.getOffice());
    returnValue = returnValue && this.getPhone().equals(that.getPhone());
    returnValue = returnValue && (this.getTeaching() == that.getTeaching());

    return returnValue;
  } // public boolean equals(Object that)

/*********************************************************************
 * Method to read the <code>Record</code> from an input
 * <code>Scanner</code> file. Note that this is more or less hard
 * coded. Also that we don't bulletproof the input; among other
 * things we assume that partial records don't appear in the input.
 *
 * @param the <code>Scanner</code> from which to read.
 *
 * @return the <code>Scanner</code> from which to read.
**/
  public void readRecord(Scanner inFile)
  {
    int n;    /** local variable for input of the course number */
    String s; /** local variable for input of the string data   */
    
    // no bulletproofing--if *any* data exists we assume that
    // an entire record exists and in the right order and format
    if(inFile.hasNext())
    {
      s = inFile.next();
      this.name = s;

      s = inFile.next();
      this.office = s;

      s = inFile.next();
      this.phone = s;

      n = inFile.nextInt();
      this.teaching = n;
    }
  } // public void readRecord(Scanner inFile)

/*********************************************************************
 * Method to convert a record to a <code>String</code>.
 *
 * @return the formatted <code>String</code> value of the record.
**/
  public String toString()
  {
    String s;
    s = String.format("%-10s %-5s %-9s %4d",
                 this.getName(),this.getOffice(),
                 this.getPhone(),this.getTeaching());
    return s;
  } // public String toString()

} // public class Record
