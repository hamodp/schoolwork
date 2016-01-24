import java.util.Scanner;

public class AreaofTriangle 
{
	static public void main (String arg [])
	{
		Scanner scan = new Scanner (System.in);
		
		System.out.print("Please enter a side of the triangle:");
		double sideA = scan.nextDouble();
		//collects first side of the triangle
		
		System.out.println();
		System.out.print("Please enter another side of the triangle:");
		double sideB = scan.nextDouble();
		//collects second side of the triangle
		
		System.out.println();
		System.out.print("Please enter the last side of the triangle:");
		double sideC = scan.nextDouble();
		// collects last side of the triangle
		
		double perimeter = sideA + sideB + sideC;
		System.out.println();
		System.out.print("Perimeter:" + perimeter);
		double s = perimeter / 2;
		//finds s for the equation
		
		double area = Math.sqrt(s* (-sideA +s)* (-sideB + s)* (-sideC + s));
		System.out.println();
		System.out.print("Area:" + area);
		//finds the area of the triangle
	}
}
