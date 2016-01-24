import java.io.PrintWriter;
import java.util.Scanner;
/*********************************************************************
 * Homework 02: Parsing an EL155 Cast Vote Record and counting votes.
 * We read the EL155 and create an 'ArrayList' of each complete
 * cast vote record. Then we count the votes for President and for
 * the U.S. House.
 *
 * Copyright (C) 2012 by Duncan A. Buell.  All rights reserved.
 *
 * @author Duncan A. Buell
 * @version 1.00 2012-12-22
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
    DoTheWork doTheWork = null;

    inFile = FileUtils.ScannerOpen("EL155.378");
    outFile = FileUtils.PrintWriterOpen("zout.txt");
    FileUtils.SetLogFile("zlog.txt");

    System.out.println("begin execution");

    doTheWork = new DoTheWork(inFile);

    outFile.printf("%s%n", doTheWork);
    outFile.flush();

    outFile.printf("%s%n", doTheWork.countTheVotes("President"));
    outFile.flush();

    outFile.printf("%s%n", doTheWork.countTheVotes("CONG002"));
    outFile.flush();

    outFile.printf("%s%n", doTheWork.countTheVotes("CONG006"));
    outFile.flush();

    FileUtils.logFile.flush();

    System.out.printf("end execution%n");
  }
} // public class Driver

