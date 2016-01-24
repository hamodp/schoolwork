import java.util.ArrayList;
import java.util.Iterator;

/************************************************************************************
 * MySet 
 * @author Patrick Hamod
 *
 * @param <T>
 */
public class MySet <T extends Comparable<T>> implements IMySet<T>// implements IMySet
{
	private MySetIterator myIterator;
	private ArrayList<T> myList;
    
	public MySet()
	{
		myList = new ArrayList<T>();
		iterator();
	}
	
	
	public Iterator<T> iterator()
	{ 
		myIterator =new MySetIterator(this);
		return myIterator;
	}
	
	public int card() {
		Iterator<T> i = this.iterator();
		int card =0;
		while(i.hasNext())
		{
			card++;
			i.next();
		}
		return card;
	}

	public boolean containsElement(T e) {
		
		boolean isContained = false;
		Iterator<T> i = this.iterator();
		while(i.hasNext())
		{
			if(e.equals(i.next()))
			{
				isContained =true;
				break;
			}
		}
		return isContained;
	}

	public boolean isEmpty() {
		Iterator<T> i = this.iterator();
		boolean isEmpty =false;
		if(! i.hasNext())
		{
			isEmpty =true;
		}
		return isEmpty;
	}

	public T removeFromSet(T e) {
		T returnVal = null;
		Iterator<T> i = this.iterator();
		
		while(i.hasNext())
		{
			if(i.next().equals(e))
			{
				returnVal = e;
				i.remove();
			}
		}
		
		return returnVal;
	}

	
	public boolean containsSet(MySet<T> thatSet) {
		boolean doesContain= false;
		
		Iterator<T> i = thatSet.iterator();
		
		while(i.hasNext())
		{
			if(!containsElement(i.next()))
			{
				break;
			}
		}
		
		if(!i.hasNext())
		{
			doesContain = true;
		}
			
		return doesContain;
		
	}

	

	public boolean equals(MySet<T> that) {
		boolean isEqual = true;
		Iterator<T> i = this.iterator();
		
		if(this.card() == that.card())
		{
			while(i.hasNext())
			{
				if(! that.containsElement(i.next()))
				{
					isEqual = false;
					break;
				}
			}
			
		}
		else{
			isEqual = false;
		}
		
		return isEqual;
	}

	public boolean isContainedIn(MySet<T> thatSet) 
		{
			boolean isContained =false;
			
			Iterator<T> i = this.iterator();
			
			while(i.hasNext())
			{
				if(!containsElement(i.next()))
				{
					break;
				}
			}
			
			if(!i.hasNext())
			{
				isContained = true;
			}
				
			
			return isContained;
		}	
		


	public T addToSet(T e) {
		Iterator<T> i = this.iterator();
		boolean isContained = false;
		while(i.hasNext())
		{
			if(e.equals(i.next()))
			{
				isContained =true;
				break;
			}
		}
		if(!isContained)
		{
			myList.add(e);
		}
		return e;
	}

	public String toString()
	{
		String output = "";
		Iterator<T> i = this.iterator();
		
		while(i.hasNext())
		{
			output += i.next()+ " ";
		}
		return output;
	}
	
	
	private class MySetIterator implements Iterator<T>
	{
	  private final int SUBSCRIPTBUMP = 1;
	  private int mySubscript;

	/*********************************************************************
	 * Constructor.
	**/
	  public MySetIterator(MySet theStuff)
	  {
	    this.mySubscript = -1;
	  } // public MyStuffIterator(MyStuff theStuff)

	/*********************************************************************
	 * General methods.
	**/

	/*********************************************************************
	 * Method to answer the question of a "next" element.
	 *
	 * @return the <code>boolean</code> answer to the question.
	**/
	@Override
	  public boolean hasNext()
	  {
	    boolean returnValue = false;

	    if(this.mySubscript + this.SUBSCRIPTBUMP < myList.size())
	    {
	      returnValue = true;
	    }

	    return returnValue;
	  } // public boolean hasNext()

	/*********************************************************************
	 * Method to return the 'next' element.
	 *
	 * @return the next data element.
	**/
	@Override
	  public T next()
	  {
	    if(this.hasNext())
	    {
	      this.mySubscript = this.mySubscript + this.SUBSCRIPTBUMP;
	    }
	    else
	    {
	      throw new RuntimeException("ERROR: hasNext fails");
	    }

	    return myList.get(this.mySubscript);
	  } // public Integer next()

	/*********************************************************************
	 * Method to remove the element returned by the most recent 'next'
	 * operation.  Note that since we don't implement this, we don't need
	 * to keep the most recent returned value.
	 *
	 * @throws IllegalStateException if this method is invalid now.
	**/
	
	  public void remove()
	  {
		 myList.remove(mySubscript);
	  }

	} // private class MyStuffIterator

}//public class MySet
