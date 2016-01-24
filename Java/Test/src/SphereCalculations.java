
import java.util.Scanner;

public class SphereCalculations 
{ 
	static public void main(String [] arg)
	{
		Scanner scan = new Scanner(System.in);
		
		Sphere sphere1 = new Sphere();
		//diameter
		Sphere sphere2 = new Sphere();
		//area
		Sphere sphere3 = new Sphere();
		//volume
		
		System.out.print("Input diameter of sphere:");
		double diameter =  scan.nextDouble();
		//allows user to input the circles diameter
		sphere1.setDiameter(diameter);
		System.out.println();
		System.out.println("Diameter:" + sphere1.getDiameter());
		
		sphere2.getArea(diameter);
		System.out.println("Surface area:"+ sphere2.getArea(diameter));
		
		sphere3.getVolume(diameter);
		System.out.println("Volume:" + sphere3.getVolume(diameter));
	}
}
