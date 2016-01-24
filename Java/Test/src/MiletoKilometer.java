import java.util.Scanner;
public class MiletoKilometer
//converts user input to kilometers
{
	public static void main (String[] arg)
	{
		double conversion = 1.60935;
		Scanner scan = new Scanner (System.in);
		System.out.println("Please enter miles");
		float mile = scan.nextFloat();
		double kilometer = mile * conversion;
		System.out.println("kilometerrs:" + kilometer);
		
	}
}
