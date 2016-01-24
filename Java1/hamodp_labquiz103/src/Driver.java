import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;
/*********************************************************************
 * Lab Quiz 1:  Implement a linked list and add and test for entries.
 *
 * Copyright(C) 2013 Duncan A. Buell.  All rights reserved.
 *
 * @author Duncan Buell used by Patrick Hamod
 * @version 1.00 2013-02-17
**/
public class Driver
{
/*********************************************************************
 * main method
**/
  public static void main (String[] args)
  {
    Scanner dataLoadFile = null;
    Scanner testFile = null;
    PrintWriter outFile = null;
    Record rec = null;
    WordList theWordList;

    FileUtils.SetLogFile("zlog.txt");

    ////////////////////////////////////////////////////////////////////
    // First we read the main data to be loaded.
    dataLoadFile = FileUtils.ScannerOpen("zinputdata.txt");
    theWordList = new WordList();
    while(dataLoadFile.hasNext())
    {
      rec = new Record(dataLoadFile);
      theWordList.add(rec);
    } // while(inFile.hasNext())
    FileUtils.CloseFile(dataLoadFile);

    ////////////////////////////////////////////////////////////////////
    // Then we dump the list
    outFile = FileUtils.PrintWriterOpen("zout.txt");
    outFile.printf("The list is%n%s%n", theWordList);
    outFile.flush();

    ////////////////////////////////////////////////////////////////////
    // Now we run the lookup on the test file.
    testFile = FileUtils.ScannerOpen("zteststrings.txt");
    while(testFile.hasNext())
    {
      String testWord = testFile.next();
      int testPosition = testFile.nextInt();

      outFile.printf("The word to be tested is '%s' in position %d%n%n",
                      testWord, testPosition);
      outFile.flush();

      Record recFound = theWordList.firstOccurrence(testWord, testPosition);
      outFile.printf("The first occurrence of word '%s' at position %d is%n     '%s'%n%n",
                     testWord, testPosition,
                     recFound.toString());
      outFile.flush();
       
      recFound = theWordList.thirdOccurrence(testWord, testPosition);
      outFile.printf("The third occurrence of word '%s' at position %d is%n     '%s'%n%n",
                     testWord, testPosition,
                     recFound.toString());
      outFile.flush();

    } // while(testFile.hasNext())

    ////////////////////////////////////////////////////////////////////
    // Close up, go home.
    outFile.flush();
    FileUtils.CloseFile(outFile);
  }

} // public class Main
