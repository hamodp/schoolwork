import java.util.ArrayList;

/************************************************************************************
 * MySet 
 * @author Patrick Hamod
 *
 * @param <T>
 */
public class MySet <T extends Comparable<T>> implements IMySet<T>// implements IMySet
{

	private ArrayList<T> myList;
    
	public MySet()
	{
		myList = new ArrayList<T>();
	}
	
	
	public int card() {
		
		return myList.size();
	}

	public boolean containsElement(T e) {
		
		
		return myList.indexOf(e)>=0;
	}

	public boolean isEmpty() {
		return myList.isEmpty();
	}

	public T removeFromSet(T e) {
		T returnVal = null;
		if(containsElement(e))
		{
			myList.remove(e);
			returnVal = e;
		}
		
		return returnVal;
	}

	
	public boolean containsSet(MySet<T> thatSet) {
		boolean doesContain= false;
		
			for(int i =0; i< this.card(); i++)
			{
				if(this.containsElement(thatSet.getElement(i)))
				{
					doesContain = true;
				}
				else
				{
					doesContain = false;
				}
			}
		return doesContain;
		
	}

	private T getElement(int i) {
		return myList.get(i);
	}


	public boolean equals(MySet<T> that) {
		boolean isEqual = false;
		if(myList.size() == that.card())
		{
			for(T e: myList)
			{

				if(that.containsElement(e))
				{
					isEqual =true;
				}
				else
				{
					isEqual =false;
					break;
				}
			}
		}
		
		return isEqual;
	}

	public boolean isContainedIn(MySet<T> thatSet) 
		{
			boolean isContained =false;
			for(T e: myList)
			{
				if(thatSet.containsElement(e))
				{
					isContained =true;
				}
				else
				{
					isContained =false;
					break;
				}
			}
			return isContained;
		}	
		


	public T addToSet(T e) {
		myList.add(e);
		return e;
	}

	public String toString()
	{
		String output = "";
		for(T e: myList)
		{
			output = output + e + " ";
		}
		return output;
	}
}
