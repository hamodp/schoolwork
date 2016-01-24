// Java packages
import java.awt.*;
import javax.swing.*;

/**
 * ShowDie.java
 *
 * Draw a graphic image of a die.
 *
 * Created: Wednesday September 19 8:28:49 2012
 *
 * @author Prof. Michael N. Huhns<a href="mailto:huhns@sc.edu"></a>
 * @version 1.0
 */

public class ShowDie extends JFrame {
    private int dots;

    public ShowDie(int d, int x, int y) {
		super("Die");
		dots = d;
		setSize(100, 100);
		setLocation(x, y);
		setVisible(true);
    }

    public void paint(Graphics g) {
	super.paint(g);
	g.setColor(Color.WHITE);
	g.fillRect(25, 25, 50, 50);
	g.setColor(Color.BLACK);
	if (dots == 1)
	    g.fillOval(46, 46, 8, 8);
	else if (dots == 2) {
	    g.fillOval(32, 32, 8, 8);
	    g.fillOval(60, 60, 8, 8);
	}
	else if (dots == 3) {
	    g.fillOval(46, 46, 8, 8);
	    g.fillOval(32, 32, 8, 8);
	    g.fillOval(60, 60, 8, 8);
	}
	else if (dots == 4) {
	    g.fillOval(32, 32, 8, 8);
	    g.fillOval(60, 60, 8, 8);
	    g.fillOval(32, 60, 8, 8);
	    g.fillOval(60, 32, 8, 8);
	}
	else if (dots == 5) {
	    g.fillOval(46, 46, 8, 8);
	    g.fillOval(32, 32, 8, 8);
	    g.fillOval(60, 60, 8, 8);
	    g.fillOval(32, 60, 8, 8);
	    g.fillOval(60, 32, 8, 8);
	}
	else if (dots == 6) {
	    g.fillOval(32, 32, 8, 8);
	    g.fillOval(32, 46, 8, 8);
	    g.fillOval(32, 60, 8, 8);
	    g.fillOval(60, 32, 8, 8);
	    g.fillOval(60, 46, 8, 8);
	    g.fillOval(60, 60, 8, 8);
	}
	else
	    System.out.println("Error in number of dots being displayed");
    }

}// ShowDie
