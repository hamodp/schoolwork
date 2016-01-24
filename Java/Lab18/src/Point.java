import java.awt.*;
import java.awt.geom.*;

import javax.swing.*;
import java.util.Scanner;

public class Point extends JFrame{

	Ellipse2D.Float circle;
	int x;
	int y;
	Point(int x , int y){
		this.x = x;
		this.y =y;
	}
	
	float getx(){
		return x;
	}
	
	int gety(){
		return y;
	}
	
	public static void main (String[] args){
		GraphDisplay gd = new GraphDisplay();
		int x;
		int y;
		Point node[] = new Point[7];
		Graphics g = null;
		
		node[0]= new Point(360, 40);
		node[1]= new Point(25, 25);
		node[2]=new Point(100, 100);
		node[3]=new Point(250, 100);
		node[4]=new Point(370, 370);
		node[5]=new Point(50 , 350);
		node[6]=new Point(210 ,210);
		
		gd.paintComponents(g, node[0]);
		gd.setVisible(true);
		for(int i =0; i<7; i++){
			break;
			
		}
	}
}
