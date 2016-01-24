import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.awt.*;

public class Shapes
{
	public static void main (String[] args)
	{
		DrawingKit shapes = new DrawingKit("shapes");
		
		//forms loop drawing 20 shapes alternating squares and circles
		for (int i=1;i<=20; i++ )
		{
			if (i==1 || i==5 || i==7|| i==11 || i==13|| i==17 || i==19)
			{
				shapes.setPaint(Color.blue);
				Rectangle2D.Float square = new Rectangle2D.Float(i*20,20, 20,20);
				shapes.draw(square);
			}
			else if(i==3||i==9||i==15)
			{
				shapes.setPaint(Color.red);
				Rectangle2D.Float square = new Rectangle2D.Float(i*20,20, 20,20);
				shapes.draw(square);
			}
			else if(i==6||i==12||i==18)
			{
				shapes.setPaint(Color.red);
				Ellipse2D.Float circle = new Ellipse2D.Float(i*20,20,20,20);
				shapes.draw(circle);
			}
			else
			{
				shapes.setPaint(Color.blue);
				Ellipse2D.Float circle = new Ellipse2D.Float(i*20,20,20,20);
				shapes.draw(circle);
			}
		}
	}
}
