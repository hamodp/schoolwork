import java.util.Scanner;
/*********************************************************************
 * Interface for 'Cast Vote'.
 *
 * This is the class for Lab 01 that deals with a single cast vote line.
 *
 * Basically, all we do is read the data from the input file into
 * the variables inside this class, and then set the key.
 *
 * Copyright (C) 2012 by Duncan A. Buell.  All rights reserved.
 *
 * @author Duncan A. Buell
 * @version 1.00 2012-12-21
**/
public interface ICastVote
{

/*********************************************************************
 * Constructor.
  public CastVote(Scanner inFile)
  {
    CODE GOES HERE TO READ AND ASSIGN VALUES

    this.key = new Key(this);
    this.key.storeData(key, this);
  } // public CastVote(Scanner inFile)
**/

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
  public void readData(Scanner inFile);

/*********************************************************************
 * Usual 'toString' method.
 *
 * @return a formatted 'toString' of the class
**/
  public String toString();

} // public interface ICastVote
