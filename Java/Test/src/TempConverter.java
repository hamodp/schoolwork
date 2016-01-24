import java.util.Scanner;
public class TempConverter 
//converts input Fahrenheit to Celsius temperature
{
	public static void main (String[] arg)
	{
		final double fraction = 5.0/9.0;
		Scanner scan = new Scanner (System.in);
		System.out.println("Please enter temperature in Fahrenheit.");
		double Fahrenheit = scan.nextDouble();
		double celsius = (fraction * (Fahrenheit - 32)); 
		System.out.println("In Celsius:" + celsius);
	}
}