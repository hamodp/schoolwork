import java.util.Random;
public class phonenumber
{
	public static void main (String arg[])
	{
		Random generator = new Random();
		int areacode = generator.nextInt(800);
		//makes random area code that does not begin with 8 or 9
		
		int mid = generator.nextInt(743);
		//creates the three middle digits that are not allowed to be larger than 742
		
		int last = generator.nextInt(10000);
		//determines last four digits
		
		System.out.println("The phone number is:" + areacode + "-" + mid +"-" + last);
		//displays the number like xxx-xxx-xxxx
		System.out.println("if the line does not display the proper amount pf digits assume the"
				+ "rest are zeros in front");
	}
}
