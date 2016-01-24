import junit.framework.*;

import java.util.ArrayList;
import java.util.Iterator;
/*********************************************************************
 * * MySetTester.
 *
 * This is the class for Lab 07 that tests the set implementation.
 *
 * Copyright (C) 2012 by Duncan A. Buell.  All rights reserved.
 *
 * @author Duncan A. Buell used by Patrick Hamod
 * @version 1.00 2012-12-21
**/
public class MySetTester extends TestCase
{
  private String dummy = "";
  private MySet<Element1> mySet1 = null;
  private MySet<Element1> mySet2 = null;
  private MySet<Element1> mySet3 = null;
  private Element1 elt1 = null;
  private Element1 elt2 = null;
  private Element1 elt3 = null;
  private Element1 elt4 = null;
  private Element1 elt5 = null;
  private Element1 elt6 = null;


/*********************************************************************
 *
**/
  public MySetTester(String name)
  {
    super(name);

    System.out.printf("begin execution%n");

    //////////////////////////////////////////////////////////////////
    // set up the files for input and output
    FileUtils.SetLogFile("zlog.txt");
    FileUtils.logFile.flush();

    elt1 = new Element1("red");
    elt2 = new Element1("orange");
    elt3 = new Element1("blue");
    elt4 = new Element1("green");
    elt5 = new Element1("cerise");
    elt6 = new Element1("indigo");

    System.out.printf("end execution%n");
  }

/*********************************************************************
 *
**/
  protected void setUp()
  {
    this.mySet1 = new MySet<Element1>();
    this.mySet2 = new MySet<Element1>();
    this.mySet3 = new MySet<Element1>();
  }

/*********************************************************************
 *
**/
  protected void tearDown()
  {
    this.mySet1 = null;
    this.mySet2 = null;
    this.mySet3 = null;
  }

/*********************************************************************
 *
**/
  public void testConstructor()
  {
    System.out.println("enter constructor test");

    System.out.printf("The original sets are\n");
    System.out.printf("%s\n", mySet1);
    System.out.printf("%s\n", mySet2);
    System.out.printf("%s\n", mySet3);
    System.out.flush();
    System.out.printf("The original Elements are\n");
    System.out.printf("%s\n", elt1);
    System.out.printf("%s\n", elt2);
    System.out.printf("%s\n", elt3);
    System.out.printf("%s\n", elt4);
    System.out.printf("%s\n", elt5);
    System.out.printf("%s\n", elt6);
    System.out.flush();

    assertEquals(true, mySet1.isEmpty());
    assertEquals(true, mySet2.isEmpty());
    assertEquals(true, mySet3.isEmpty());

    assertEquals(0, mySet1.card());
    assertEquals(0, mySet2.card());
    assertEquals(0, mySet3.card());

    FileUtils.logFile.flush();

    System.out.println("leave constructor test");
  }

/*********************************************************************
 *
**/
  public void testOps()
  {
    System.out.println("enter ops test");

    System.out.printf("The original MySet1 data is\n");
    System.out.printf("%s\n", mySet1);
    System.out.flush();
    System.out.printf("The original MySet2 data is\n");
    System.out.printf("%s\n", mySet2);
    System.out.flush();
    System.out.printf("The original MySet3 data is\n");
    System.out.printf("%s\n", mySet3);
    System.out.flush();

    // create three sets, testing add and card
    mySet1.addToSet(elt1);
    assertEquals(1, mySet1.card());
    mySet1.addToSet(elt2);
    assertEquals(2, mySet1.card());
    mySet1.addToSet(elt3);
    assertEquals(3, mySet1.card()); // set one is now 1, 2, 3

    mySet2.addToSet(elt3);
    assertEquals(1, mySet2.card());
    mySet2.addToSet(elt1);
    assertEquals(2, mySet2.card());
    mySet2.addToSet(elt2);
    assertEquals(3, mySet2.card()); // set one is now 1, 2, 3

    mySet3.addToSet(elt4);
    assertEquals(1, mySet3.card());
    mySet3.addToSet(elt1);
    assertEquals(2, mySet3.card());
    mySet3.addToSet(elt2);
    assertEquals(3, mySet3.card()); // set one is now 1, 2, 4

    // test adding an elt that is already there
    mySet3.addToSet(elt2);
    assertEquals(3, mySet3.card()); // should not be added again

    // one and two should be equal
    assertTrue(mySet1.equals(mySet2));
    assertTrue(mySet2.equals(mySet1));

    // one and two should be different from three
    assertFalse(mySet1.equals(mySet3));
    assertFalse(mySet3.equals(mySet1));
    assertFalse(mySet2.equals(mySet3));
    assertFalse(mySet3.equals(mySet2));

    // test the membership test
    assertTrue(mySet1.containsElement(elt1));
    assertTrue(mySet1.containsElement(elt2));
    assertTrue(mySet1.containsElement(elt3));
    assertFalse(mySet1.containsElement(elt4));
    assertFalse(mySet1.containsElement(elt6));

    assertTrue(mySet3.containsElement(elt4));
    assertTrue(mySet3.containsElement(elt2));
    assertTrue(mySet3.containsElement(elt1));
    assertFalse(mySet3.containsElement(elt3));

    // now we test removal and rebuilding of one set to then equal another
    Element1 eee = mySet3.removeFromSet(elt1);
    assertTrue(eee.equals(elt1));
    assertFalse(mySet3.containsElement(elt1));

    eee = mySet3.removeFromSet(elt2);
    assertTrue(eee.equals(elt2));
    assertFalse(mySet3.containsElement(elt2));

    eee = mySet3.removeFromSet(elt6);
    assertFalse(elt6.equals(eee));

    mySet3.addToSet(elt3);
    mySet3.addToSet(elt5);
    mySet3.addToSet(elt6);

    mySet1.removeFromSet(elt1);
    assertFalse(mySet1.containsElement(elt1));
    mySet1.removeFromSet(elt2);
    assertFalse(mySet1.containsElement(elt2));
    mySet1.addToSet(elt4);
    mySet1.addToSet(elt5);
    mySet1.addToSet(elt6);

    assertEquals(4, mySet1.card());
    assertEquals(4, mySet3.card());
    assertTrue(mySet1.equals(mySet3));
    assertTrue(mySet3.equals(mySet1));

    FileUtils.logFile.flush();

    System.out.println("leave ops test");
  }

/*********************************************************************
 *
**/
  public void testSetIterator()
  {
    System.out.println("enter iterator test");
    
    System.out.printf("The original MySet1 data is\n");
    System.out.printf("%s\n", mySet1);
    System.out.flush();
    System.out.printf("The original MySet2 data is\n");
    System.out.printf("%s\n", mySet2);
    System.out.flush();
    System.out.printf("The original MySet3 data is\n");
    System.out.printf("%s\n", mySet3);
    System.out.flush();

    // create a set
    mySet1.addToSet(elt1);
    assertEquals(1, mySet1.card());
    mySet1.addToSet(elt2);
    assertEquals(2, mySet1.card());
    mySet1.addToSet(elt3);
    assertEquals(3, mySet1.card());
    mySet1.addToSet(elt4);
    assertEquals(4, mySet1.card());
    mySet1.addToSet(elt5);
    assertEquals(5, mySet1.card());
    mySet1.addToSet(elt6);
    assertEquals(6, mySet1.card());

    Iterator<Element1> iter = mySet1.iterator();
    while(iter.hasNext())
    {
      System.out.printf("iterator test element: %s\n", iter.next());
    }

    System.out.println("leave iterator test");
  }

/*********************************************************************
 *
**/
  public void testSetContainment()
  {
    System.out.println("enter set containment test");

    System.out.printf("The original MySet1 data is\n");
    System.out.printf("%s\n", mySet1);
    System.out.flush();
    System.out.printf("The original MySet2 data is\n");
    System.out.printf("%s\n", mySet2);
    System.out.flush();
    System.out.printf("The original MySet3 data is\n");
    System.out.printf("%s\n", mySet3);
    System.out.flush();

    // create three sets, testing add and card
    mySet1.addToSet(elt1);
    assertEquals(1, mySet1.card());
    mySet1.addToSet(elt2);
    assertEquals(2, mySet1.card());
    mySet1.addToSet(elt3);
    assertEquals(3, mySet1.card()); // set one is now 1, 2, 3

    mySet2.addToSet(elt3);
    assertEquals(1, mySet2.card());
    mySet2.addToSet(elt1);
    assertEquals(2, mySet2.card()); // set two is now 1, 3

    mySet3.addToSet(elt4);
    assertEquals(1, mySet3.card());
    mySet3.addToSet(elt1);
    assertEquals(2, mySet3.card());
    mySet3.addToSet(elt2);
    assertEquals(3, mySet3.card()); // set three is now 1, 2, 4

    // test adding an elt that is already there
    assertTrue(mySet2.isContainedIn(mySet1));
    assertTrue(mySet1.containsSet(mySet2));
    assertFalse(mySet1.containsSet(mySet3));

    mySet1.addToSet(elt4);
    assertTrue(mySet1.containsSet(mySet3));

    FileUtils.logFile.flush();

    System.out.println("leave set containment test");
  }

/*********************************************************************
 *
**/
  public static Test suite()
  {
    return new TestSuite(MySetTester.class);
  }

/*********************************************************************
 *
**/
  public static void main(String[] args)
  {
    String[] TestCaseName = {MySetTester.class.getName()};
  }
} // public class MySetTester extends TestCase
