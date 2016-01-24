import javax.swing.JApplet;
import java.awt.*;

public class Olympic_Chain extends JApplet
//makes the olympic logo of the chain
{
	public void paint (Graphics page)
	{
		final int TOP = 50;
		final int Bottom= 80;
		setBackground(Color.pink);
		
		page.setColor(Color.blue);
		page.drawOval(20, TOP, 50, 50);
		//first circle keep blue
		
		page.setColor(Color.yellow);
		page.drawOval(50, Bottom, 50, 50);
		//second must be yellow
		
		page.setColor(Color.black);
		page.drawOval(80, TOP, 50, 50);
		//third must be black
		
		page.setColor(Color.green);
		page.drawOval(110, Bottom, 50, 50);
		//fourth must be green
		
		page.setColor(Color.red);
		page.drawOval(140, TOP, 50, 50);
	}
}
