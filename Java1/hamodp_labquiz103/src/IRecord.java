/*********************************************************************
 * Interface for the Record.
 *
 * This has the list of required methods so the compiler will be happy.
 *
 * Copyright(C) 2012 Duncan A. Buell. All rights reserved. 
 *
 * @author Duncan Buell used by Patrick Hamod
 * @version 1.00 2012-10-07
**/
public interface IRecord
{
  public boolean isAMatch(String wordToMatch, int position);
} // public interface IRecord
