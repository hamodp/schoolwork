import java.io.PrintWriter;
import java.util.Scanner;
/*********************************************************************
 * Homework 01: Parsing an EL155 Cast Vote Record.
 * We read the EL155 and create an 'ArrayList' of each choice.
 *
 * Copyright (C) 2012 by Duncan A. Buell.  All rights reserved.
 *
 * @author Duncan A. Buell
 * @version 1.00 2012-12-20
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
    ReadTheFile readTheFile = null;
    int j = 0;

    inFile = FileUtils.ScannerOpen("EL155.102302");
    outFile = FileUtils.PrintWriterOpen("zout.txt");
    FileUtils.SetLogFile("zlog.txt");

    System.out.println("begin execution");

    while(inFile.hasNext())
    {

        	 readTheFile = new ReadTheFile(inFile);
        	 
        	 if(inFile.hasNext())
        	 {
        		 j++;
        		inFile.nextLine();
        	 }
    		
    	
    }
   
    FileUtils.logFile.flush();
    outFile.printf("%s%n", "Beginning of "+ j+ " lines of CVR" );
    
    outFile.printf("%s%n", readTheFile);
    	
    outFile.flush();
    outFile.close();
    System.out.printf("end execution%n");
  }


} // public class Driver

