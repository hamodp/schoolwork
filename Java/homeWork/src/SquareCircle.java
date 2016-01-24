
import java.awt.geom.*;

public class SquareCircle 
{
	public static void main (String[] args)
	{
		DrawingKit shapes = new DrawingKit("shapes");
		
		//forms loop drawing 20 shapes alternating squares and circles
		for (int i=1;i<=20; i++ )
		{
			//draws the squares
			if (i==1 || i==3 || i==5 || i==7 || i==9 || i==11 || i==13|| i==15|| i==17 || i==19)
			{
				Rectangle2D.Float square = new Rectangle2D.Float(i*20,20, 20,20);
				shapes.draw(square);
			}
			
			//draws the circles
			else
			{
				Ellipse2D.Float circle = new Ellipse2D.Float(i*20,20,20,20);
				shapes.draw(circle);
			}
		}
	}
}
