import java.util.Scanner;
/*********************************************************************
 * Cast Vote.
 *
 * This is the class for Lab 01 that deals with a single cast vote line.
 *
 * Basically, all we do is read the data from the input file into
 * the variables inside this class, and then set the key.
 *
 * Copyright (C) 2012 by Duncan A. Buell.  All rights reserved.
 *
 * @author Duncan A. Buell modified by Patrick Hamod
 * @version 1.00 2012-12-21
**/
public class CastVote implements ICastVote
{
  
  private String inputLine;
  private Key key;

/*********************************************************************
 * Constructor.
**/
  public CastVote(Scanner inFile)
  {
    readData(inFile);

    this.key = new Key(this);
    this.key.storeData(key, this);
  } // public CastVote(Scanner inFile)

/*********************************************************************
 * Accessors and mutators.
**/

/*********************************************************************
 * General methods.
**/

/*********************************************************************
 * Method to read data from the 'Scanner'.
 *
 * We read data, without bulletproofing for correctness.
 *
 * @param inFile the Scanner from which to read.
**/
  public void readData(Scanner inFile)
  {
	Scanner localScanner =new Scanner(inFile.nextLine());
    while(localScanner.hasNext())
    {
    	if(inputLine != null)
    	{
    		inputLine = inputLine+"  "+localScanner.next();
    	}
    	else
    	{
    		inputLine =localScanner.next();
    	}
    }
    System.out.println(inputLine);
  } // public void readData(Scanner inFile)

/*********************************************************************
 * Usual 'toString' method.
 *
 * @return a formatted 'toString' of the class
**/
  public String toString()
  {
	  return inputLine;
  } // public String toString()

} // public class CastVote
