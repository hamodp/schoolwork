import java.util.Scanner;
/*********************************************************************
 * Interface for the 'DoTheWork' class for Homework 2.
 * Copyright (C) 2012 by Duncan A. Buell.  All rights reserved.
 *
 * @author Duncan A. Buell
 * @version 1.00 2012-12-22
**/
public interface IDoTheWork
{
  public String countTheVotes(String contest);
  
  public String getPctInfo(String inputLine);

  public boolean isCastVote(String inputLine);

  public boolean isHeader(String inputLine);

  public boolean isNewVote(String inputLine);

  public void readFile(Scanner inFile);

  public String toString();

} // public interface IDoTheWork
