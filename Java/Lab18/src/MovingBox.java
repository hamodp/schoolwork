import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JFrame;


public class MovingBox implements Runnable {

	private static final long serialVersionUID = 1L;
	Thread t2;
	private int xBox = 0;
	private int yBox = 0;
	private Color boxColor = Color.BLUE;
	final static long MILLISECONDS_DELAY = 100;
	private static JFrame window = new JFrame("Moving Ball");
	private int runCount = 0;
	private int sleepFactor = 0;
	private Random shape =new Random(2);
	
	MovingBox(int xB, int yB, Color bColor, int tC){
		xBox =xB;
		yBox =yB;
		boxColor = bColor;
		sleepFactor =tC;
	}
	
	public void run() {
		System.out.println("Thread count = " + sleepFactor);
		for (int n = 0; n < 100; n++) {
			Graphics g = window.getContentPane().getGraphics();
			g.setColor(Color.WHITE);
			g.fillRect(xBox, yBox, 20, 20);
			yBox = yBox + 5;
			if (yBox > 380) yBox = 0;
			g.setColor(boxColor);
			g.fillRect(xBox, yBox, 20, 20);
			System.out.println("Thread " + Thread.currentThread().getName() + " Run count = " + runCount++);
			try {
				Thread.sleep(MILLISECONDS_DELAY * sleepFactor);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}

