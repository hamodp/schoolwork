import java.awt.*;
import javax.swing.*;
import java.io.File;

public class pictureplacement 
//shows the placement of the text relative to the picture
{
	public static void main (String arg [])
	{
		JFrame frame = new JFrame ("Picture Placement");
		frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		
		

		ImageIcon icon = new ImageIcon ("PL 61- 64.JPEG");
		
		JLabel label1, label2, label3, label4;
		
		label1 = new JLabel ("Devil left", icon, SwingConstants.CENTER);
		
		label2 = new JLabel ("Devil right", icon, SwingConstants.CENTER);
		label2.setHorizontalTextPosition (SwingConstants.LEFT);
		label2.setVerticalTextPosition (SwingConstants.BOTTOM);
		
		label3 = new JLabel ("Devil Above", icon, SwingConstants.CENTER);
		label3.setHorizontalTextPosition (SwingConstants.CENTER);
		label3.setVerticalTextPosition (SwingConstants.BOTTOM);
		
		
		JPanel panel = new JPanel ();
		panel.setBackground(Color.cyan);
		panel.setPreferredSize (new Dimension (200,250));
		panel.add(label1);
		panel.add(label2);
		panel.add(label3);
		
		frame.getContentPane().add(panel);
		frame.pack();
		frame.setVisible(true);
	}
}
