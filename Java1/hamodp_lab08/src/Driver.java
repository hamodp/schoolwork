import java.io.PrintWriter;
import java.util.Iterator;
/*********************************************************************
 * Lab 08: Creating an iterator for sublists of a list.
 *
 * Copyright (C) 2012 by Duncan A. Buell.  All rights reserved.
 *
 * @author Duncan A. Buell used by Patrick Hamod
 * @version 1.00 2012-12-27
**/
public class Driver
{
/*********************************************************************
 * main method.
**/
  public static void main (String[] args)
  {
    PrintWriter outFile = null;
    Element e = null;
    MySet<Element> theSet = null;

    outFile = FileUtils.PrintWriterOpen("zout.txt");
    FileUtils.SetLogFile("zlog.txt");

    System.out.println("begin execution");

    // first we create a set
    theSet = new MySet<Element>();
    e = new Element("red");
    theSet.addToSet(e);
    e = new Element("orange");
    theSet.addToSet(e);
    e = new Element("blue");
    theSet.addToSet(e);
    e = new Element("green");
    theSet.addToSet(e);
    outFile.printf("The set is %s\n", theSet);
    outFile.flush();

    // this is merely to dump the set to the log file to make it easier to test  
    FileUtils.logFile.printf("%s\n", theSet);
    FileUtils.logFile.flush();

    Iterator<MySet<Element>> subsetIter = theSet.subsetIterator();
    while(subsetIter.hasNext())
    {
      outFile.printf("Subset %s\n", subsetIter.next());
      outFile.flush();
    } // while(subsetIter.hasNext())

    outFile.flush();
    FileUtils.logFile.flush();

    System.out.printf("end execution%n");
  }
} // public class Driver

