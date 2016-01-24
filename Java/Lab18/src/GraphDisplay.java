import java.awt.*;
import java.awt.geom.Ellipse2D;

import javax.swing.*;

public class GraphDisplay extends JFrame{
	Graphics g;
	JPanel page;
	GraphDisplay(){
		super("Graphics Display");
		setSize(400, 400);
		setContentPane(page);
	}
	
	
	
	public void paintComponents(Graphics g , Point p){
		super.paintComponents(g);
		int x =p.getX();
		int y =p.gety();
		Graphics2D g2 =(Graphics2D) g;
		drawPoints(g2, x, y);
	}
	
	void drawPoints(Graphics2D g2, int x, int y){
		g2.setColor(Color.green);
		g2.fillOval(x,  y,15, 15);
	}
}