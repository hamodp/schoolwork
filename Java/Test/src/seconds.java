import java.util.Scanner;
public class seconds 
//converts hours and minutes to seconds
{
	public static void main(String[] args) 
	{
	Scanner scan = new Scanner (System.in);	
	
	System.out.print("Please enter hours:");
	int hours = scan.nextInt();
	//allows input and identifies number of hours
	
	System.out.print("\n Please enter minutes:");
	int min = scan.nextInt();
	//input and identifies number of minutes
	
	System.out.print("\n Please enter seconds:");
	int sec = scan.nextInt();
	//input and identifies the number of seconds
	
	int total = (360 * hours) + (60 * min) + sec;
	System.out.print("\n Total seconds:" + total);
	//calculates the total amount of seconds
	}

}
