import java.util.ArrayList;
/*********************************************************************
 * Interface for 'MySet'.
 *
 * This is the interface for Lab 02 for a mathematical set.
 *
 * Copyright (C) 2012 by Duncan A. Buell.  All rights reserved.
 *
 * @author Duncan A. Buell edited by Patrick Hamod
 * @version 1.00 2012-12-21
**/

public class MySet implements IMySet {

	private ArrayList<Element> set;
	
	public MySet()
	{
		set =new ArrayList<Element>();
	}
	
	
	public Element addToSet(Element e) 
	{
		if(set.contains(e))
		{
			return e;
		}
		else
		{
			set.add(e);
			return null;
		}
	}

	@Override
	public int card() {
		
		
		return set.size();
	}

	@Override
	public boolean containsElement(Element e) {
		if(set.contains(e))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public boolean equals(MySet that) {
		if(that.card()== set.size())
		{
			for(Element e: set)
			{
				if(! that.containsElement(e))
				{
					return false;
				}
			}
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public boolean isEmpty() 
	{
		return set.isEmpty();
	}

	@Override
	public Element removeFromSet(Element e) {
		if(containsElement(e))
		{
			set.remove(e);
			return e;
		}	
		else
		{
			return null;
		}
	}
	
	public String toString()
	{
		String output = "";
		for(Element e: set)
		{
			output = output + e + " ";
		}
		return output;
	}
}
