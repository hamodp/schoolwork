import java.awt.Container;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JOptionPane;
public class pract 
{

	public static void main(String[] args)
	{
		String input ="";

		//loop finds number for the series if it user doesn't type end
		while(! input.equalsIgnoreCase("end"))
		{
			input = JOptionPane.showInputDialog("Please enter next number or end to terminate: ");
			List <Double> list = new ArrayList<Double>();
			if(input.contains("1")||input.contains("2")||input.contains("3")||input.contains("4")||input.contains("5")||input.contains("6")||input.contains("7")||input.contains("8")||input.contains("9"))
			{
				double num = Double.parseDouble(input);
				JOptionPane.showMessageDialog(null,"number: " + num);
				list.add(num);
			}
			else if (input.equalsIgnoreCase("end"))
				JOptionPane.showMessageDialog(null,"done");
			else
				JOptionPane.showMessageDialog(null, "please enter a number or end");
		}
	}
}
