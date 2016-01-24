
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.*;

public class MovingBall extends JFrame implements Runnable, MouseListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Thread thread;
	private int xBall = 0;
	private int yBall = 0;
	private Color ballColor = Color.BLUE;
	final static long MILLISECONDS_DELAY = 100;
	private static JFrame window = new JFrame("Moving Ball");
	private int runCount = 0;
	private int sleepFactor = 0;
	private Random shape =new Random(2);
	private int xBox = 0;
	private int yBox = 0;
	private Color boxColor = Color.BLUE;
	// Constructor
	public MovingBall(int xB, int yB, Color bColor, int tC) {
		xBall = xB;
		yBall = yB;
		ballColor = bColor;
		sleepFactor = tC;
	}
	
	public void run() {
		System.out.println("Thread count = " + sleepFactor);
		for (int n = 0; n < 100; n++) {
			Graphics g = window.getContentPane().getGraphics();
			g.setColor(Color.WHITE);
			g.fillOval(xBall, yBall, 20, 20);
			yBall = yBall + 5;
			if (yBall > 380) yBall = 0;
			g.setColor(ballColor);
			g.fillOval(xBall, yBall, 20, 20);
			System.out.println("Thread " + Thread.currentThread().getName() + " Run count = " + runCount++);
			try {
				Thread.sleep(MILLISECONDS_DELAY * sleepFactor);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void mouseClicked(MouseEvent a) {
		int xLoc = a.getLocationOnScreen().x;
		int yLoc = a.getLocationOnScreen().y;
		if(shape.nextInt(2)==0){
			MovingBall mb4 =new MovingBall(xLoc, yLoc, Color.black, 4);
			mb4.thread =new Thread(mb4);
			mb4.thread.start();
		}
			
		else{
			MovingBox mb5 =new MovingBox(xLoc, yLoc, Color.red, 4);
			mb5.t2 =new Thread(mb5);
			mb5.t2.start();
		}
		System.out.println("Mouse clicked at " + xLoc +", " +yLoc);
	}
	public void mouseEntered(MouseEvent arg0) {
		System.out.println("Mouse entered");
	}
	public void mouseExited(MouseEvent arg0) {
		System.out.println("Mouse exited");
	}
	public void mousePressed(MouseEvent arg0) {
		System.out.println("Mouse pressed");
		
	}
	public void mouseReleased(MouseEvent arg0) {
		System.out.println("Mouse released");
	}

	public static void main(String[] args) {
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setSize(400, 400);
		Container c = window.getContentPane();
		c.setBackground(Color.WHITE);
		window.setVisible(true);
		MovingBall mb1 = new MovingBall(20, 0, Color.BLUE, 1);
		window.addMouseListener(mb1);
		mb1.thread = new Thread(mb1);
		mb1.thread.start();
		MovingBall mb2 = new MovingBall(40, 0, Color.RED, 2);
		mb2.thread = new Thread(mb2);
		mb2.thread.start();
		MovingBall mb3 = new MovingBall(60, 0, Color.GREEN, 3);
		mb3.thread = new Thread(mb3);
		mb3.thread.start();
		MovingBox mb6 =new MovingBox(80, 0, Color.cyan, 4);
		mb6.t2 =new Thread(mb6);
		mb6.t2.start();
	}
}
