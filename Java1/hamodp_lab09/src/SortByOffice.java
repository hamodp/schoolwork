import java.util.Comparator;
/*********************************************************************
 * Class to implement a comparator for sorting by office number.
 *
 * Copyright (C) 2011 by Duncan A. Buell.  All rights reserved.
 *
 * @author Duncan A. Buell edited by Patrick Hamod
 * @version 1.00 2011-12-31
**/
public class SortByOffice implements Comparator<Record>
{
/*********************************************************************
 * Method to compare the two records.
 *
 * @return -1, 0, or +1 according as the comparison goes.
**/
  public int compare(Record rec1, Record rec2)
  {
	  int returnValue;

	    returnValue = 0;

	    // this sort works on the name
	    if(rec1.getOffice().compareTo(rec2.getOffice()) < 0)
	    {
	      returnValue = -1;
	    }
	    else if(rec1.getOffice().compareTo(rec2.getOffice()) > 0)
	    {
	      returnValue = +1;
	    }
	    else
	    {
	      returnValue = 0;
	    }

	    return returnValue;
  }
} // public class SortByOffice
