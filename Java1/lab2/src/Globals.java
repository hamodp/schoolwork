import java.util.ArrayList;
/*********************************************************************
 * Global class for the global data variable.
 *
 * The purpose of this class is to provide a global location into 
 * which the 'Key' class can write so as to remove all connection
 * between the sequence of data as input and the sequence of data
 * as stored. 
 *
 * Copyright (C) 2012 by Duncan A. Buell.  All rights reserved.
 *
 * @author Duncan A. Buell
 * @version 1.00 2012-12-21
**/
public class Globals
{
/*********************************************************************
 * main method.
**/
  static public ArrayList<CastVote> theList = new ArrayList<CastVote>();

} // public class Globals

