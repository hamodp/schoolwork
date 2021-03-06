import java.util.ArrayList;
import java.util.Comparator;
import java.util.TreeMap;
import java.util.Map.Entry;

/*********************************************************************
 * Choices: this class is storage for all unique choices for each contest
 * it also creates a unique id for each of these choices to find the choice
 *
 * Copyright (C) 2013 by Patrick Hamod.  All rights reserved.
 *
 * @author Patrick Hamod
 * @version 1.00 2013-04-22
**/
public class Choices
{
	private static TreeMap<Choice, Integer> mapIDToChoice;
	private static TreeMap<Integer, Choice> mapChoiceToID;
	static private int id = -1;

/***********************************************************************************
 * constructor
 */
public Choices()
{
	mapIDToChoice = new TreeMap<Choice, Integer>(new CompContest());
	mapChoiceToID = new TreeMap<Integer, Choice>();
	
}
	

/*********************************************************************************
 * general methods
 */
/********************************************************************
 * this method adds if the choice is not found in the treemap it adds 
 * a new choice and reference number to it
 * @param choice
 */
  static public void AddChoice(Choice choice)
  {
	  if(mapIDToChoice.get(choice)==null)
	  {
	       id++;
		  mapIDToChoice.put(choice, id);
		  mapChoiceToID.put(id, choice);
	  }
  }
  
/*********************************************************************************
 * accessors
 */
 /****************************************************************
  * this method gets the choice associated with the input number
  * 
  * @param id
  * @return choice
  */
  static public Choice GetChoice(Integer id)
  {
	  return mapChoiceToID.get(id);
  }

/**************************************************************
 * this method gets the id number associated to the input choice
 * 
 * @param choice
 * @return id
 */
  static public Integer GetID(Choice choice)
  {
	return mapIDToChoice.get(choice);  
  }

 /*****************************************************************
  * usual toString method
  * 
  * @return output
  */
  public String toString()
  {
	  String output = "";
	  
	  for(Entry<Integer, Choice> data: mapChoiceToID.entrySet())
		{
			output += data.getValue().toString()+"\n";
		}
	  
	  return output;
  }
}
