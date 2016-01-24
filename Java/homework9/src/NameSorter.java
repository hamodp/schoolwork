/******************************************************************************
 * @filename: Button
 * @author: Patrick Hamod
 * @date: 16 Nov 2012
 *@version: 1
 * 
 * gui table that allows sorting by age and name
 ******************************************************************************/
import java.awt.*;
import java.awt.event.*;
import java.text.Collator;
import java.util.ArrayList;
import java.util.*;

import javax.swing.*;



public class NameSorter extends JFrame implements ActionListener  {

	String name="  ";
	static ArrayList nameList=new ArrayList();
	int age;
	static ArrayList <String>Titles=new ArrayList<String>();
	ArrayList <String> ageList=new ArrayList<String>();
	Name names;
	int[] list;
	JPanel nameHolder;
	JPanel buttons =new JPanel();
	JPanel main =new JPanel(new BorderLayout());
	Collator compare;
	JButton sortAge, sortName;
	JLabel title =new JLabel("Names");
	JLabel title2=new JLabel("Age");
	Container con;
	JLabel[] label;
	JLabel[] ageLabel;
	
	//sets up the gui
	NameSorter(){
		super();
		setSize(400, 400);
		con =getContentPane();
		sortName =new JButton("Sort by Name");
		sortAge= new JButton("Sort by Age");
		
		sortName.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					if(e.getSource().equals(sortName)){
						sortNames(Titles);
					}
				}
		});
		sortAge.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(e.getSource().equals(sortAge)){
					sortAges(ageList);
				}
			}
	});
		buttons.add(sortName);
		buttons.add(sortAge);
		main.add(buttons, BorderLayout.SOUTH);
		while(!name.equals("end")){
			name=JOptionPane.showInputDialog("Please enter a name leave blank to end: ");
			if(!name.equals("end")){
				age =Integer.parseInt(JOptionPane.showInputDialog("please enter "+ name+ "'s age"));
				names=new Name(name, age);
				ageList.add(age+"");
				Titles.add(name);
				nameList.add(names);
				//ageList.add(age);
				compare =Collator.getInstance();
				
			}
			
		}
		nameHolder=new JPanel(new GridLayout(Titles.size()+1,2 ));
		label= new JLabel[nameList.size()];
		ageLabel= new JLabel[nameList.size()];
		clear();
		setVisible(true);
	}
	
	//sets the table up alternating colors
	public void clear(){
		main.remove(nameHolder);
		nameHolder.removeAll();
		title.setBackground(Color.blue);
		title.setOpaque(true);
		title2.setBackground(Color.blue);
		title2.setOpaque(true);
		nameHolder.add(title);
		nameHolder.add(title2);
		for(int i=0; i<nameList.size();i++){
			if(i%2==0){
				label[i] =new JLabel(Titles.get(i));
				ageLabel[i]=new JLabel(ageList.get(i));
				label[i].setBackground(Color.white);
				label[i].setOpaque(true);
				ageLabel[i].setBackground(Color.white);
				ageLabel[i].setOpaque(true);
				nameHolder.add(label[i]);
				nameHolder.add(ageLabel[i]);
				main.add(nameHolder, BorderLayout.NORTH);
			}
			else if(i%2==1){
				
				label[i] =new JLabel(Titles.get(i));
				ageLabel[i]=new JLabel(ageList.get(i));
				ageLabel[i].setBackground(Color.lightGray);
				label[i].setBackground(Color.lightGray);
				label[i].setOpaque(true);
				ageLabel[i].setOpaque(true);
				
				
				nameHolder.add(label[i]);
				nameHolder.add(ageLabel[i]);
				main.add(nameHolder, BorderLayout.NORTH);
			}
		}
		con.add(main);
		setContentPane(con);
	}
	
	//sorts age in ascending 
	public void sortAges(ArrayList a){

		Collections.sort(a);
		
		for(int i=0; i<a.size(); i++){
			ageList.set(i, (String) a.get(i));
			for(int j=0; j<a.size();j++)
				if(a.get(i).equals(((Name)nameList.get(j)).getAge())){
					Titles.set(i,((Name) nameList.get(j)).getName());
					System.out.println(Titles.get(i));
				}
			}
			clear();
	}
	
	//sorts the table of names alphabeticly
	public void sortNames(ArrayList a){
		

		Collections.sort(a);
		
		for(int i=0; i<a.size(); i++){
			Titles.set(i, (String) a.get(i));
			for(int j=0; j<a.size();j++)
				if(a.get(i).equals(((Name)nameList.get(j)).getName())){
					ageList.set(i,((Name) nameList.get(j)).getAge());
					System.out.println(ageList.get(i));
				}
			}
			clear();
		}
		
	
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	public static void main (String[] args){
		NameSorter ns= new NameSorter();
		
	}

}
