import javax.swing.JApplet;
import java.awt.*;

public class Snowman extends JApplet
//graphic practice
{
	public void paint (Graphics page)
	{
		final int MID = 150;
		final int TOP = 50;
		
		setBackground (Color.cyan);
		
		page.setColor(Color.blue);
		page.fillRect (0,175,300,50);
		//ground
		
		page.setColor(Color.yellow);
		page.fillOval(275, -40, 80, 80);
		//sun
		
		page.setColor(Color.white);
		page.fillOval(MID - 20, TOP, 40, 40);
		// head
		page.fillOval(MID-35, TOP+35, 70, 50);
		// upper torso
		page.fillOval(MID-50, TOP+80, 100, 60);
		// lower torso
		
		page.setColor(Color.black);
		page.fillOval(MID-10, TOP+10, 5, 5);
		page.fillOval(MID+5, TOP+10, 5, 5);
		//eyes
		
		page.drawArc(MID-10, TOP+20, 20, 10, 0, 180);
		//frown
		
		page.drawLine(MID-25, TOP+60, MID-50, TOP+40);
		page.drawLine(MID+25, TOP+60, MID+55, TOP+60);
		//arms
		
		page.drawLine(MID-20, TOP+5, MID+20, TOP+5);
		//brim of his hat
		page.fillRect(MID-15, TOP-20, 30, 25);
		// top hat
		
		page.setColor(Color.red);
		page.fillOval(MID,TOP+45, 5, 5);
		page.fillOval(MID, TOP+65, 5, 5);
		//buttons
		
		page.drawString("Patrick", 20, 20);
		//writes programmers name
		}
}
