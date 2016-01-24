import java.io.PrintWriter;
import java.util.Scanner;
/*********************************************************************
 * Lab 03: Parse text for XML tokens with some attributes.
 *
 * Copyright (C) 2012 by Duncan A. Buell.  All rights reserved.
  *
 * @author Duncan A. Buell
 * @version 1.00 2012-12-25
**/
public class Driver
{
/*********************************************************************
 * main method.
**/
  public static void main (String[] args)
  {
    PrintWriter outFile = null;
    Scanner inFile = null;
    ParseTokens xmlData = null;

    inFile = FileUtils.ScannerOpen("zintest2.txt");
    outFile = FileUtils.PrintWriterOpen("zout.txt");
    FileUtils.SetLogFile("zlog.txt");

    System.out.printf("begin execution%n");

    xmlData = new ParseTokens(inFile);
    outFile.printf("%s\n", xmlData);

    FileUtils.CloseFile(outFile);
    FileUtils.CloseLogFile();

    System.out.printf("end execution%n");
  }
} // public class Driver

