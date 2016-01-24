import java.io.PrintWriter;
import java.util.Scanner;
/*********************************************************************
 * Lab 01: Adding a key to a data payload.
 * We read a simplified EL155, create an 'ArrayList' of the cast vote,
 * and then output in key order instead of input order.
 *
 * Copyright (C) 2012 by Duncan A. Buell.  All rights reserved.
 *
 * @author Duncan A. Buell modified by Patrick Hamod
 * @version 1.00 2012-12-21
**/
public class Driver
{
/*********************************************************************
 * main method.
**/
  public static void main (String[] args)
  {
    Scanner inFile = null;
    PrintWriter outFile = null;
    CastVote cv = null;

    inFile = FileUtils.ScannerOpen("EL155.20short");
    outFile = FileUtils.PrintWriterOpen("zout.txt");
    FileUtils.SetLogFile("zlog.txt");

    System.out.println("begin execution");

    for(int i = 0; i < 100; ++i) Globals.theList.add(null);

    while(inFile.hasNext())
    {
      cv = new CastVote(inFile);
    }

    for(int i = 0; i < 100; ++i)
    {
      if(Globals.theList.get(i) != null)
      {
        outFile.printf("%s\n",i+"\t"+  Globals.theList.get(i)); 
        outFile.flush();
      }
    }

    outFile.flush();
    FileUtils.logFile.flush();

    System.out.printf("end execution%n");
  }
} // public class Driver

