/*********************************************************************
 * Key class for cast votes.
 *
 * This is the class that hides from everyone the sequence in which
 * votes are stored.
 *
 * If this were done properly, one would use the key inside this
 * class to store the data record, so that there would never be any
 * way to connect the key to the record except for the code here
 * inside this particular class.
 *
 * Copyright (C) 2012 by Duncan A. Buell.  All rights reserved.
 *
 * @author Duncan A. Buell modified by Patrick Hamod
 * @version 1.00 2012-12-21
**/
public class Key implements IKey
{
  private final int modulus = 97;
  private final int primroot = 5;

  static private int keyvalue = 5;

  private int key;

/*********************************************************************
 * Constructor.
**/
  public Key(CastVote vote)
  {
    keyvalue = (keyvalue * primroot) % modulus;
    key = keyvalue;
  } // public Key(CastVote vote)

/*********************************************************************
 * Accessors and mutators.
**/
/*********************************************************************
 * General methods.
**/

/*********************************************************************
 * Method to store data based on the <code>key</code>.
 *
 * @param key the key
 * @param vote the vote to be stored
**/
  public void storeData(Key key, CastVote vote)
  {
	
    Globals.theList.set(keyvalue,  vote);
  } // public int getKey()


/*********************************************************************
 * Usual 'toString' method.
 *
 * @return a formatted 'toString' of the class
**/
  public String toString()
  {
    return key+"";
  } // public String toString()

} // public class Key
