import java.awt.*;
import javax.swing.JPanel;


public class ImagePanel extends JPanel {
	
	private Image image;
	
	ImagePanel(){
		image = null;
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawImage(image, 0,0,null);
	}
	
	public void loadImage(Image i){
		image = i;
		repaint();
	}
}
