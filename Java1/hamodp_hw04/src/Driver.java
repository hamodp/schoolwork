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
    DTD dtd = null;
    ParseTheData parseData = null;

    System.out.printf("begin execution%n");
    FileUtils.SetLogFile("zlog.txt");

    outFile = FileUtils.PrintWriterOpen("zout.txt");

    inFile = FileUtils.ScannerOpen("zdtd.txt");
    dtd = new DTD(inFile);
    FileUtils.CloseFile(inFile);

    outFile.printf("DTD is\n%s\n", dtd);

    inFile = FileUtils.ScannerOpen("zin.txt");
    parseData = new ParseTheData(inFile, outFile);
    FileUtils.CloseFile(inFile);

    outFile.flush();
    FileUtils.CloseFile(outFile);

    System.out.printf("end execution%n");
  }
} // public class Driver

