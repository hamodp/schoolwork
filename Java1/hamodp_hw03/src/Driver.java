import java.io.PrintWriter;
import java.util.Scanner;
/*********************************************************************
 * Homework 3:  Assemble packets from messages.
 *
 * Copyright(C) 2013 Duncan A. Buell.  All rights reserved.
 *
 * @author Duncan Buell used by Patrick Hamod
 * @version 1.00 2013-02-05
**/
public class Driver
{
/*********************************************************************
 * main method
**/
  public static void main (String[] args)
  {
    int messageID;
    Scanner inFile = null;
    PrintWriter outFile = null;
    PacketAssembler assembler = null;

    FileUtils.SetLogFile("zlog.txt");
    FileUtils.logFile.printf("beginning execution%n");
    FileUtils.logFile.flush();
    
    inFile = FileUtils.ScannerOpen("zin.txt");
    outFile = FileUtils.PrintWriterOpen("zout.txt");

    // This is intended more or less to simulate running forever,
    // which is what a packet handler would be doing.
    messageID = -99; // yes, this is a magic number
    assembler = new PacketAssembler();
    while(inFile.hasNext())
    {
      messageID = assembler.readPacket(inFile);
      if(messageID >= 0)
      {
    	System.out.println(messageID);
        outFile.printf("Message is\n%s\n", assembler.dumpMessage(messageID));
      // assembler = new PacketAssembler();
      }
    }

    FileUtils.CloseFile(inFile);
    FileUtils.CloseFile(outFile);

    FileUtils.logFile.printf("ending execution%n");
    FileUtils.logFile.flush();
    
    FileUtils.CloseLogFile();
  }
} // public class Main





