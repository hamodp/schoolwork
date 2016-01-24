// Java packages
import javax.swing.*;

/**
 * Die.java
 *
 * This class represents a single die, which has a value of 1 to 6
 *
 * Created: Wednesday September 19, 2012
 *
 * @author Prof. Michael Huhns<a href="mailto:huhns@sc.edu"></a>
 * @version 1.0
 */

public class Die {
    /**
     * A die is defined in terms of its value, which must be between
     * 1 and 6
     */
    private int value;

    /**
     * Default constructor for a die.  The die is initialized to a
     * random integer value between 1 and 6
     */
    public Die() {
		value = (int)(Math.random() * 6.0 + 1.0);
    }

    /** Returns the value of a die, without affecting it */
    public int getValue() {
		return value;
    }

    /** Displays a die, i.e., its value */
    public ShowDie display(int x, int y) {
		System.out.println("The value of the die is " + value);
		ShowDie sd = new ShowDie(value, x, y);
		sd.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	return sd;
    }

    /** Removes the display of a die */
    public void undisplay(ShowDie sd) {
		sd.dispose();
    }

    /** Rolls the die, sets its value, and returns the new value */
    public int roll() {
		value = (int)(Math.random() * 6.0 + 1.0);
		return value;
    }

}// Die
