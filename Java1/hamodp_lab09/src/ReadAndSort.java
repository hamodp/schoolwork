import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
/*********************************************************************
 * Class for reading phonebook data into instances of 'Record'
 * classes and then sorting that data with a call to the Collections
 * sorting routine.
 *
 * Copyright (C) 2012 by Duncan A. Buell.  All rights reserved.
 *
 * @author Duncan A. Buell edited by Patrick Hamod
 * @version 1.00 2012-12-31
**/
public class ReadAndSort
{
/*********************************************************************
 * Instance variables for the class.
**/
  ArrayList<Record> theRecords = null;

/*********************************************************************
 * Constructor.
**/
  public ReadAndSort(Scanner inFile)
  {
    this.theRecords = new ArrayList<Record>();
    this.readTheData(inFile);
  } // public ParseTheData()

/*********************************************************************
 * Accessors and mutators.
**/

/*********************************************************************
 * General methods.
**/
/*********************************************************************
 * Method to read the data.
 *
 * @param inFile the input file from which to read
**/
  private void readTheData(Scanner inFile)
  {
	  Record nextRec;
	  while(inFile.hasNext())
	  {
		 Scanner localScanner = new Scanner(inFile.nextLine());
		 nextRec =new Record(localScanner);
		 theRecords.add(nextRec);
	  }
  } // public void readTheData(Scanner inFile)

/*********************************************************************
 * Method to sort the data.
**/
  public void sortTheData()
  {
    Collections.sort(theRecords);
  } // public void sortTheData()

/*********************************************************************
 * Method to sort the data by office.
**/
  public void sortTheDataByOffice()
  {
    Collections.sort(theRecords, new SortByOffice());
  } // public void sortTheDataByOffice()

/*********************************************************************
 * Usual 'toString' method.
 *
 * @return the usual 'toString' of the class.
**/
  public String toString()
  {
    String s = "";

    for(Record rec: theRecords)
    {
      s += String.format("%s\n", rec);
    }

    return s;
  } // public String toString()

} // public class ParseTheData
