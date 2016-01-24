/*********************************************************************
 * Lab 10: Read two lists and use a hash set to compute the set
 * intersection.
 *
 * Copyright (C) 2013 by Duncan A. Buell.  All rights reserved.
 *
 * @author Duncan A. Buell used by Patrick Hamod
 * @version 1.00 2013-04-19
**/
public class Driver
{
/*********************************************************************
 * main method.
**/
  public static void main (String[] args)
  {

    System.out.printf("begin execution%n");
    FileUtils.SetLogFile("zlog.txt");

    OneSet set1 = new OneSet("zin1.txt");
    FileUtils.logFile.printf("One: %s%n", set1);
    FileUtils.logFile.flush();

    OneSet set2 = new OneSet("zin2.txt");
    FileUtils.logFile.printf("Two: %s%n", set2);
    FileUtils.logFile.flush();

    FileUtils.logFile.printf("Int: %s%n", set1.intersectWith(set2));
    FileUtils.logFile.flush();


    FileUtils.CloseLogFile();

    System.out.printf("end execution%n");
  }
} // public class Driver

