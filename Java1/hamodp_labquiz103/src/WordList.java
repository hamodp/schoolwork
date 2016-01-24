import java.util.ArrayList;
/*********************************************************************
 * Class implementing a linked list using the Java class.
 *
 * Copyright(C) 2013 Duncan A. Buell.  All rights reserved.
 *
 * @author Duncan Buell edited by Patrick Hamod
 * @version 1.00 2013-02-17
**/
public class WordList
{
  private ArrayList<Record> wordList;

/*********************************************************************
 * Constructor.
**/
  public WordList()
  {
    this.wordList = new ArrayList<Record>();
  } // public WordList()

/*********************************************************************
 * Accessors and mutators.
**/

/*********************************************************************
 * Mutators.
**/

/*********************************************************************
 * General methods..
**/
/*********************************************************************
 * Method to add a Record item to the linked list.
 *
 * @param what the item to add
**/
  public void add(Record what)
  {
    wordList.add(what);
  } // public void add(Record what)


/*********************************************************************
 * Method to find the first occurrence of a word in a given position.
 *
 * @param word the word to be searched for.
 * @param position the position to be searched for.
 * @return the record in which the position occurs, else null.
**/
  public Record firstOccurrence(String word, int position)
  {
    Record returnValue = null;

    for(Record r: wordList)
    {
    	if(r.isAMatch(word, position))
    	{
    		returnValue = r;
    		break;
    	}
    }

    return returnValue;
  } // public Record firstOccurrence(String word, int position)

/*********************************************************************
 * Method to find the third occurrence of a word in a given position.
 *
 * @param word the word to be searched for.
 * @param position the position to be searched for.
 * @return the record in which the position occurs, else null.
**/
  public Record thirdOccurrence(String word, int position)
  {
    Record returnValue = null;
    int third = 0;//tests until third occurence
    for(Record r: wordList)
    {
    	if(r.isAMatch(word, position))
    	{
    		third++;
    		if(third == 3)
    		{
    			returnValue = r;
    			break;
    		}
    	}
    }

    return returnValue;
  } // public Record thirdOccurrence(String word, int position)

/*********************************************************************
 * Usual 'toString' method.
 *
 * @return the 'toString' of the entire list
**/
  public String toString()
  {
    String s = "";

    for(Record rec : wordList)
    {
      s += String.format("%s\n", rec);
    } // for(Record rec : wordList)

    return s;
  } // public String toString()

} // public class MyList
