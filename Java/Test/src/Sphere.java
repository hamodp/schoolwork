

public class Sphere

{
	public double diameter;
	private double radius;
	//constructor for the class and initializer
	public Sphere()
	{
		diameter = radius*2;
	}
	
	//sets the diameter for calculations
	public double setDiameter (double diameter)
	{
		radius = diameter/2;
		return diameter;
	}
	
	public double getDiameter ()
	{
		return (radius*2);
	}
	//finds the volume of the sphere
	public double getVolume (double diameter)
	{
		radius = diameter/2;
		double volume = ((4/3)* Math.pow(radius, 3)* Math.PI);
		return volume;
	}
	//finds the surface area of the sphere
	public double getArea (double diameter)
	{
		radius = diameter/2;
		double area = 4*Math.pow(radius, 2)*Math.PI;
		return area;
	}
}
