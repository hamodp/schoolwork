import java.io.PrintWriter;
import java.util.Scanner;
/*********************************************************************
 * HW 04: Parse XML and create records.
 *
 * Copyright (C) 2012 by Duncan A. Buell.  All rights reserved.
 *
 * @author Duncan A. Buell used by Patrick Hamod
 * @version 1.00 2012-12-30
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
    ReadAndSort readAndSort = null;

    System.out.printf("begin execution%n");
    FileUtils.SetLogFile("zlog.txt");

    outFile = FileUtils.PrintWriterOpen("zout.txt");

    inFile = FileUtils.ScannerOpen("zin.txt");
    readAndSort = new ReadAndSort(inFile);
    FileUtils.CloseFile(inFile);

    outFile.printf("As read\n%s\n", readAndSort);
    outFile.flush();

    readAndSort.sortTheData(); // uses 'compareTo' in 'Record'
    outFile.printf("After sorting\n%s\n", readAndSort);
    outFile.flush();

    readAndSort.sortTheDataByOffice(); // uses the comparator
    outFile.printf("After sorting by office\n%s\n", readAndSort);
    outFile.flush();

    FileUtils.CloseFile(outFile);

    System.out.printf("end execution%n");
  }
} // public class Driver

