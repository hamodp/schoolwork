import java.util.Scanner;
public class Distance 
//program written to take to cartesian plane points and solve the distance
{
	public static void main (String arg[])
	{
		Scanner scan = new Scanner(System.in);
		System.out.print("please enter the first x value:");
		double x1 = scan.nextDouble();
		//tkaes the first x value
		
		System.out.println();
		System.out.print("Please enter the corresponding y value:");
		double y1 = scan.nextDouble();
		// takes the y value that belongs with the first x
		
		System.out.println();
		System.out.print("Please enter the second x value:");
		double x2 = scan.nextDouble();
		// takes the second x value
		
		System.out.println();
		System.out.print("Please enter the corresponding y value:");
		double y2 = scan.nextDouble();
		//takes value that belongs to the second x
		
		double run = Math.pow((x2-x1), 2);
		double rise = Math.pow((y2-y1), 2);
		double distance = Math.sqrt(run + rise);
		//preforms the calculations to find distance
		
		System.out.println();
		System.out.print("Distance:" + distance);
		
	}
}
