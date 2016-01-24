import java.io.PrintWriter;
import java.util.Scanner;
/*********************************************************************
 * Lab 04: Creating a class for mathematical sets.
 * The driver code does a lot of the testing of the set class, and
 * thus is more complicated than most drivers in this course.
 *
 * This updates Lab 02 in that it uses generics instead of having
 * the data type of the set elements being specified.
 *
 * Copyright (C) 2013 by Duncan A. Buell.  All rights reserved.
 *
 * @author Duncan A. Buell
 * @version 1.00 2013-02-06
**/
public class Driver
{
/*********************************************************************
 * main method.
**/
  public static void main (String[] args)
  {
    PrintWriter outFile = null;
    Element1 e1, e1new = null;
    Element2 e2, e2new = null;

    outFile = FileUtils.PrintWriterOpen("zout.txt");
    FileUtils.SetLogFile("zlog.txt");

    System.out.println("begin execution");

    //////////////////////////////////////////////////////////////////
    //
    outFile.printf("%nTest of 'MySet' using 'Element1'%n");
    // first we create set one
    MySet<Element1> set1 = new MySet<Element1>();
    e1 = new Element1("red");
    set1.addToSet(e1);
    e1 = new Element1("orange");
    set1.addToSet(e1);
    e1 = new Element1("blue");
    set1.addToSet(e1);
    e1 = new Element1("green");
    set1.addToSet(e1);
    outFile.printf("Element1 Set 1: %s\n", set1);
    outFile.flush();

    // then we create set two
    MySet<Element1> set2 = new MySet<Element1>();
    e1 = new Element1("orange");
    set2.addToSet(e1);
    e1 = new Element1("brown");
    set2.addToSet(e1);
    e1 = new Element1("blue");
    set2.addToSet(e1);
    e1 = new Element1("brown");
    set2.addToSet(e1);
    outFile.printf("Element1 Set 2; %s\n", set2);
    outFile.flush();

    // then we test one against two -- should be false
    if(set1.equals(set2))
    {
      outFile.printf("Element1 Sets 1 and 2 are equal\n");
      outFile.flush();
    }
    else
    {
      outFile.printf("Element1 Sets 1 and 2 are not equal\n");
      outFile.flush();
    }

    // then we create set three 
    MySet<Element1> set3 = new MySet<Element1>();
    e1 = new Element1("blue");
    set3.addToSet(e1);
    e1 = new Element1("orange");
    set3.addToSet(e1);
    e1 = new Element1("brown");
    set3.addToSet(e1);
    outFile.printf("Element1 Set 3: %s\n", set3);
    outFile.flush();

    // then we test two against three -- should be true
    if(set2.equals(set3))
    {
      outFile.printf("Element1 Sets 2 and 3 are equal\n");
      outFile.flush();
    }
    else
    {
      outFile.printf("Element1 Sets 2 and 3 are not equal\n");
      outFile.flush();
    }

    // try to remove an element that isn't there
    outFile.printf("Element1 Set 3: %s\n", set3);
    outFile.flush();
    e1 = new Element1("red");
    e1new = set3.removeFromSet(e1);
    if(e1new == null)
    {
      outFile.printf("Element1 '%s' not in set 3\n", e1);
      outFile.flush();
    }
    else
    {
      outFile.printf("Element1 '%s' removed from set 3\n", e1);
      outFile.flush();
    }
    outFile.printf("Element1 Set 3: %s\n", set3);
    outFile.flush();

    // now try to remove an element that is there
    outFile.printf("Element1 Set 3: %s\n", set3);
    outFile.flush();
    e1 = new Element1("brown");
    e1new = set3.removeFromSet(e1);
    if(e1new == null)
    {
      outFile.printf("Element1 '%s' not in set 3\n", e1);
      outFile.flush();
    }
    else
    {
      outFile.printf("Element1 '%s' removed from set 3\n", e1);
      outFile.flush();
    }
    outFile.printf("Element1 Set 3: %s\n", set3);
    outFile.flush();

    // now add the two elements to make one and three the same
    outFile.printf("Element1 Set 3; %s\n", set3);
    outFile.flush();
    e1 = new Element1("red");
    set3.addToSet(e1);
    e1 = new Element1("green");
    set3.addToSet(e1);
    outFile.printf("Element1 Set 3: %s\n", set3);
    outFile.flush();

    // then we test one against three -- should now be true
    outFile.printf("Element1 Set 1: %s\n", set1);
    outFile.flush();
    outFile.printf("Element1 Set 3: %s\n", set3);
    outFile.flush();
    if(set1.equals(set3))
    {
      outFile.printf("Element1 Sets 1 and 3 are equal\n");
      outFile.flush();
    }
    else
    {
      outFile.printf("Element1 Sets 1 and 3 are not equal\n");
      outFile.flush();
    }

    //////////////////////////////////////////////////////////////////
    //
    outFile.printf("%nTest of 'MySet' using 'Element2'%n");
    // first we create set one
    MySet<Element2> newSet1 = new MySet<Element2>();
    e2 = new Element2(101);
    newSet1.addToSet(e2);
    e2 = new Element2(202);
    newSet1.addToSet(e2);
    e2 = new Element2(303);
    newSet1.addToSet(e2);
    e2 = new Element2(404);
    newSet1.addToSet(e2);
    outFile.printf("Element2 Set 1; %s\n", newSet1);
    outFile.flush();

    // then we create set two
    MySet<Element2> newSet2 = new MySet<Element2>();
    e2 = new Element2(101);
    newSet2.addToSet(e2);
    e2 = new Element2(303);
    newSet2.addToSet(e2);
    e2 = new Element2(505);
    newSet2.addToSet(e2);
    e2 = new Element2(707);
    newSet2.addToSet(e2);
    outFile.printf("Element2 Set 2: %s\n", newSet2);
    outFile.flush();

    // then we test one against two -- should be false
    if(newSet1.equals(newSet2))
    {
      outFile.printf("Element2 Sets 1 and 2 are equal\n");
      outFile.flush();
    }
    else
    {
      outFile.printf("Element2 Sets 1 and 2 are not equal\n");
      outFile.flush();
    }

    // then we create set three 
    MySet<Element2> newSet3 = new MySet<Element2>();
    e2 = new Element2(505);
    newSet3.addToSet(e2);
    e2 = new Element2(303);
    newSet3.addToSet(e2);
    e2 = new Element2(101);
    newSet3.addToSet(e2);
    outFile.printf("Element2 Set 3: %s\n", newSet3);
    outFile.flush();

    // then we test two against three -- should be true
    if(newSet2.equals(newSet3))
    {
      outFile.printf("Element2 Sets 2 and 3 are equal\n");
      outFile.flush();
    }
    else
    {
      outFile.printf("Element2 Sets 2 and 3 are not equal\n");
      outFile.flush();
    }

    // try to remove an element that isn't there
    outFile.printf("Element2 Set 3: %s\n", newSet3);
    outFile.flush();
    e2 = new Element2(404);
    e2new = newSet3.removeFromSet(e2);
    if(e2new == null)
    {
      outFile.printf("Element2 Element '%s' not in integer set 3\n", e2);
      outFile.flush();
    }
    else
    {
      outFile.printf("Element2 Element '%s' removed from integer set 3\n", e2);
      outFile.flush();
    }
    outFile.printf("Element2 Set 3: %s\n", newSet3);
    outFile.flush();

    // now try to remove an element that is there
    outFile.printf("Element2 Set 2: %s\n", newSet2);
    outFile.flush();
    e2 = new Element2(707);
    e2new = newSet2.removeFromSet(e2);
    if(e2new == null)
    {
      outFile.printf("Element2 Element '%s' not in set 2\n", e2new);
      outFile.flush();
    }
    else
    {
      outFile.printf("Element2 Element '%s' removed from set 2\n", e2new);
      outFile.flush();
    }
    outFile.printf("Element2 Set 2: %s\n", newSet2);
    outFile.flush();

    // then we test two against three -- should now be true
    outFile.printf("Element2 Set 2: %s\n", newSet2);
    outFile.flush();
    outFile.printf("Element2 Set 3: %s\n", newSet3);
    outFile.flush();
    if(newSet2.equals(newSet3))
    {
      outFile.printf("Element2 Sets 2 and 3 are equal\n");
      outFile.flush();
    }
    else
    {
      outFile.printf("Element2 Sets 2 and 3 are not equal\n");
      outFile.flush();
    }

    outFile.printf("Does 2 contain 3? %s%n", newSet2.containsSet(newSet3));


    outFile.flush();
    FileUtils.logFile.flush();

    System.out.printf("end execution%n");
  }
} // public class Driver

