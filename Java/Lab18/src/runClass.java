import java.awt.Color;
import java.awt.Container;

import javax.swing.JFrame;


public class runClass {
	
	static JFrame window = new JFrame("Moving Ball");
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
	}
}
