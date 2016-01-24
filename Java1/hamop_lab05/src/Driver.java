import java.io.PrintWriter;
import java.util.Scanner;
import java.math.BigInteger;
/*********************************************************************
 * Lab 05.
 * Gray coding.
 *
 * Copyright (C) 2012 by Duncan A. Buell.  All rights reserved.
 *
 * @author Duncan A. Buell used by Patrick Hamod
 * @version 1.00 2012-12-25
**/
public class Driver
{
/*********************************************************************
 * main method.
**/
  public static void main (String[] args)
  {
    int length, power;
    Counter counter = null;
    Scanner inFile = null;
    PrintWriter outFile = null;

    System.out.printf("begin execution%n");
    FileUtils.SetLogFile("zlog.txt");

    inFile = FileUtils.ScannerOpen("zin.txt");
    outFile = FileUtils.PrintWriterOpen("zout.txt");

    length = inFile.nextInt();

    //////////////////////////////////////////////////////////////////
    // These next few lines are just one way to get exponentiation
    // done simply for integers.
    BigInteger temp = new BigInteger("2");
    temp = temp.pow(length);
    power = temp.intValue();

    counter = new Counter(length);
    for(int i = 0; i < power; ++i)
    {
      outFile.printf("Counter, GrayCode %s : %s\n",
                     counter, counter.grayCode());
      outFile.flush();
      counter.increment();
    }

    FileUtils.logFile.flush();

    System.out.printf("end execution%n");
  }
} // public class Driver

