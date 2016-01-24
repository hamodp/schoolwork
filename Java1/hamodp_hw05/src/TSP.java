import java.io.PrintWriter;
import java.util.*;

/*********************************************************************
 *Class TSP this class takes a file and and tries to solve the
 * traveling sales problem by using recursion 
 *
 * @author Patrick Hamod
 * @version 1.00 2013-03-23
**/

public class TSP
{
	ArrayList<String> cities;
	ArrayList<String> path;
	ArrayList<ArrayList<Integer>> cost;
	ArrayList<Integer> permutations;
	int minimumCost;
	int limit;
	int recursion;
	
	
	/******************************************************************
	 * Constructor 
	 * 
	 * @param inFile
	 */
	public TSP(Scanner inFile)
	{
		cities = new ArrayList<String>();
		minimumCost = Integer.MAX_VALUE;
		cost =new ArrayList<ArrayList<Integer>>();
		Scanner localScanner =new Scanner(inFile.nextLine());
		
		//gets the top tags for the names of the cities
		while (localScanner.hasNext())
		{
			cities.add(localScanner.next());
		}
		
		//takes the matrix of the cost to move from one location to another
		while(inFile.hasNext())
		{
			localScanner =new Scanner(inFile.nextLine());
			ArrayList<Integer> tempCost =new ArrayList<Integer>();
			
			
			while (localScanner.hasNext())
			{
				tempCost.add(localScanner.nextInt());
			}
			cost.add(tempCost);
		}
		localScanner.close();
		permutations = new ArrayList<Integer>();
		permutations.add(0);
		path =new ArrayList<String>();
	}
	
	/**********************************************************************
	 * accessors and mutators
	 */
	
	/********************************************************
	 * accessor to get the minimum cost for TSP 
	 * @return minimumCost
	 */
	public int getMinDistance()
	{
		return minimumCost;
	}
	
	/*********************************************************************
	 * general methods
	 */
	/**********************************************************************
	 * this method sets up for the recursion method to find all permutations
	 * and returns the permutation of the shortest cost
	 * 
	 * @param outFile file to write to 
	 * @return path the permutation of most cost effective route
	 */
	
	public ArrayList<String> solveTSP(PrintWriter outFile)
	{
		limit =12000;
		for(int i=1; i<cities.size(); i++)
		{
			permutations.add(i);
		}
		this.RecursivePermutaion(cities.size()-1, 0 , permutations);
		return path;
	}
	
	
	/***********************************************************************
	 * this method creates the permutations of the cities and determines which
	 * permutations to test for minimum cost
	 * 
	 * @param size of the permutation
	 * @param progress how many digits the permutation has done
	 * @param end arraylist  of the permuation
	 */
	public void RecursivePermutaion(int size, int progress, ArrayList<Integer> end)
	{
		recursion++;
		int remaining = size - progress;
		if(recursion > limit)
		{
			throw new RuntimeException(limit +" :limit  "+ recursion+ " :recursion") ;
		}
		else if(remaining == 0)
		{
			
		}
		else
		{
			for(int i = progress; i <= size; i++)
			{
				end = swap(i, progress, end);
				
				if(end.get(0) == 0)
				{
					this.calculateMin(end);
				}
				
				RecursivePermutaion(size,  progress+1, end);
				
				end = swap(i, progress, end);
			}
			
			
		}
	}//public void recursion
	
	/************************************************************************
	 * this method determines the minimum cost and saves the permutation of the cities
	 * to path to return in solveTSP
	 * 
	 * @param permutations arraylist to test
	 */
	private void calculateMin(ArrayList<Integer> permutations)
	{
		int sum =0 ;
		int n=0;
		for(int i=0 ; i< permutations.size()-1; i++)
		{
			n= permutations.get(i+1);
			sum += cost.get(permutations.get(i)).get(n);
			if(sum > minimumCost)
			{
				break;
			}
		}
		sum += cost.get(n).get(0);
		if(sum < minimumCost)
		{
			minimumCost = sum;
			path =new ArrayList<String>();
			for(int j =0; j< permutations.size(); j++)
			{
				path.add(cities.get(permutations.get(j)));
			}
		}
	}
	
	
	/********************************************************************************
	 * this method swaps two elements in an arraylist
	 * 
	 * @param i first element to swap
	 * @param j second element to swap
	 * @param permutations arraylist to swap elements
	 * @return permutations arraylist with swapped elements
	 */
	private ArrayList<Integer> swap(int i, int j, ArrayList<Integer> permutations)
	{
		
		int element = permutations.get(j);
		permutations.set(j , permutations.get(i));
		permutations.set(i, element);
		return permutations;
		
	}
	
	
	/*******************************************************************************
	 * usual toString method that prints all the costs of the cities 
	 * 
	 * @return String
	 */
	public String toString()
	{
		int n=0;
		String output= String.format("%-15s", "");
		
		for(String s: cities)
		{
			output += String.format("%-15s", s);
		}
		
		output+= "\n";
		
		for(ArrayList<Integer> a: cost)
		{
			output+=String.format("%-15s", cities.get(n));
			n++;
			for(Integer i: a)
			{
				output+=String.format("%-15d", i);
			}
			output+="\n";
		}
		return output;
	}
}
