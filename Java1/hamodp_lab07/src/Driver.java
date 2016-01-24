import java.io.PrintWriter;
/*********************************************************************
 * Lab 07: Creating a class for mathematical sets.
 * The driver code does a lot of the testing of the set class, and
 * thus is more complicated than most drivers in this course.
 *
 * Copyright (C) 2012 by Duncan A. Buell.  All rights reserved.
 *
 * @author Duncan A. Buell used by Patrick Hamod
 * @version 1.00 2012-12-21
**/
public class Driver
{
/*********************************************************************
 * main method.
**/
  public static void main (String[] args)
  {
    PrintWriter outFile = null;
    Element1 e, enew = null;

    outFile = FileUtils.PrintWriterOpen("zout.txt");
    FileUtils.SetLogFile("zlog.txt");

    System.out.println("begin execution");

    // first we create set one
    MySet<Element1> set1 = new MySet<Element1>();
    e = new Element1("red");
    set1.addToSet(e);
    e = new Element1("orange");
    set1.addToSet(e);
    e = new Element1("blue");
    set1.addToSet(e);
    e = new Element1("green");
    set1.addToSet(e);
    outFile.printf("Set 1\n%s\n", set1);
    outFile.flush();

    // then we create set two
    MySet<Element1> set2 = new MySet<Element1>();
    e = new Element1("orange");
    set2.addToSet(e);
    e = new Element1("brown");
    set2.addToSet(e);
    e = new Element1("blue");
    set2.addToSet(e);
    e = new Element1("brown");
    set2.addToSet(e);
    outFile.printf("Set 2\n%s\n", set2);
    outFile.flush();

    // then we test one against two -- should be false
    if(set1.equals(set2))
    {
      outFile.printf("Sets 1 and 2 are equal\n");
      outFile.flush();
    }
    else
    {
      outFile.printf("Sets 1 and 2 are not equal\n");
      outFile.flush();
    }

    // then we create set three 
    MySet<Element1> set3 = new MySet<Element1>();
    e = new Element1("blue");
    set3.addToSet(e);
    e = new Element1("orange");
    set3.addToSet(e);
    e = new Element1("brown");
    set3.addToSet(e);
    outFile.printf("Set 3\n%s\n", set3);
    outFile.flush();

    // then we test two against three -- should be true
    if(set2.equals(set3))
    {
      outFile.printf("Sets 2 and 3 are equal\n");
      outFile.flush();
    }
    else
    {
      outFile.printf("Sets 2 and 3 are not equal\n");
      outFile.flush();
    }

    // try to remove an element that isn't there
    outFile.printf("Set 3\n%s\n", set3);
    outFile.flush();
    e = new Element1("red");
    enew = set3.removeFromSet(e);
    if(enew == null)
    {
      outFile.printf("Element '%s' not in set 3\n", e);
      outFile.flush();
    }
    else
    {
      outFile.printf("Element '%s' removed from set 3\n", e);
      outFile.flush();
    }
    outFile.printf("Set 3\n%s\n", set3);
    outFile.flush();

    // now try to remove an element that is there
    outFile.printf("Set 3\n%s\n", set3);
    outFile.flush();
    e = new Element1("brown");
    enew = set3.removeFromSet(e);
    if(enew == null)
    {
      outFile.printf("Element '%s' not in set 3\n", e);
      outFile.flush();
    }
    else
    {
      outFile.printf("Element '%s' removed from set 3\n", e);
      outFile.flush();
    }
    outFile.printf("Set 3\n%s\n", set3);
    outFile.flush();

    // now add the two elements to make one and three the same
    outFile.printf("Set 3\n%s\n", set3);
    outFile.flush();
    e = new Element1("red");
    set3.addToSet(e);
    e = new Element1("green");
    set3.addToSet(e);
    outFile.printf("Set 3\n%s\n", set3);
    outFile.flush();

    // then we test one against three -- should now be true
    outFile.printf("Set 1\n%s\n", set1);
    outFile.flush();
    outFile.printf("Set 3\n%s\n", set3);
    outFile.flush();
    if(set1.equals(set3))
    {
      outFile.printf("Sets 1 and 3 are equal\n");
      outFile.flush();
    }
    else
    {
      outFile.printf("Sets 2 and 3 are not equal\n");
      outFile.flush();
    }


    outFile.flush();
    FileUtils.logFile.flush();

    System.out.printf("end execution%n");
  }
} // public class Driver

