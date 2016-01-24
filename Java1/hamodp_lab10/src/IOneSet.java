import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
/*********************************************************************
 * Interface for implementing set intersection using a HashSet.
 *
 * Copyright(C) 2013 Duncan A. Buell.  All rights reserved.
 *
 * @author Duncan Buell used by Patrick Hamod
 * @version 1.00 2013-04-18
**/
public interface IOneSet
{
//  private ArrayList<String> theSet;
//  private HashSet<String> hashtable;

  public ArrayList<String> getTheSet();

  public void addElement(String element);

  public boolean containsElement(String element);

  public void readSet(Scanner inFile);

  public OneSet intersectWith(OneSet that);

  public String toString();

} // public interface IOneSet
