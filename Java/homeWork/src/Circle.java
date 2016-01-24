/**********************************************************************************************
 * @filename: Circle
 * @author: Patrick Hamod
 * @date: 12 Sept 2012
 * 
 * takes user input of diameter of a circle and prints the radius the circumference the area of the smallest
 * square containing the circle and the area of the largest square contained in the the circle and then draws
 * examples of the shapes
 */
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.geom.*;

public class Circle
{
	public static void main(String[] args)
	{
		double diameter = Double.parseDouble(JOptionPane.showInputDialog(null, "Please enter the diameter of the circle: "));
		
		//prints the diameter of the circle
		JOptionPane.showMessageDialog(null,"Diameter: " + diameter);
		
		
		//finds the radius
		double radius = diameter/2;
		JOptionPane.showMessageDialog(null,"Radius: " + radius);
		
		//finds the circumference and prints
		double circ = 2*Math.PI*radius;
		JOptionPane.showMessageDialog(null, "Circumference: " + circ);
		
		//finds smallest the square area containing the circle
		double bigS= Math.pow(diameter,2);
		JOptionPane.showMessageDialog(null, "The smallest square containing the circle " +
				"has an area: " + bigS);
		
		// find the biggest square in the circle
		double side2 = Math.sqrt(Math.pow(diameter,2)/2);
		double smallS = Math.pow(side2,2);
		JOptionPane.showMessageDialog(null,"The largest square contained in the circle has " +
				"an area: "+ smallS);
		
		//draws the shapes
		DrawingKit outline = new DrawingKit("Circle with Squares");
		
		//makes large square
		double side1 = Math.sqrt(bigS);
		Rectangle2D.Double square1 = new Rectangle2D.Double(0,0,side1,side1);
		outline.draw(square1);
		
		//makes circle
		Ellipse2D.Double circle = new Ellipse2D.Double(0,0,diameter,diameter);
		outline.draw(circle);
		
		//makes inner square
		Rectangle2D.Double square2 = new Rectangle2D.Double(side1/7,side1/7,side2,side2 );
		outline.draw(square2);
		
		DrawingKit solid = new DrawingKit("Solid");
		
		//makes large square
		solid.setPaint(Color.red);
		Rectangle2D.Double Ssquare1 = new Rectangle2D.Double(0,0,side1,side1);
		solid.fill(Ssquare1);
		
		//makes circle
		solid.setPaint(Color.blue);
		Ellipse2D.Double Scircle = new Ellipse2D.Double(0,0,diameter,diameter);
		solid.fill(Scircle);
		
		//makes inner square
		solid.setPaint(Color.orange);
		Rectangle2D.Double Ssquare2 = new Rectangle2D.Double(side1/7,side1/7,side2,side2 );
		solid.fill(Ssquare2);
	}
}
