/******************************************************************************
 * @filename: MineField
 * @author: Patrick Hamod
 * @date: 16 Nov 2012
 *@version: 1
 * 
 * creates the GUI and makes the buttons into field of mine spots and start end 
 * and safe spots. also creates buttons to check path and start new game
 ******************************************************************************/
import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;


public class MineField extends JFrame implements ActionListener{

	int mine1, mine2, start, end;
	JPanel main =new JPanel();
	JPanel field =new JPanel(new GridLayout(5, 5));
	JPanel buttons =new JPanel();
	
	Random enemy =new Random();
	int loc1, loc2;
	Button  clear, done,b0,b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12,b13,b14,b15,b16,b17,b18,b19,b20,b21,b22
	,b23,b24,b25;
	Button[] danger = {b0,b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12,b13,
	                               b14,b15,b16,b17,b18,b19,b20,b21,b22,b23,b24};
	
	MineField(String name){
		super(name);
		setSize(350,220);
		final game g1=new game();
		done=new Button("Done");
		done.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(e.getSource().equals(done)){
						if(g1.Check(danger, end)){
							JOptionPane.showMessageDialog(null, "You've Survived!");
						}
						else {
							JOptionPane.showMessageDialog(null, "You are dead");
						}
				}
			}
		});
		
		clear =new Button("Clear");
		clear.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(e.getSource().equals(clear)){
					clear();
				}
			}
		});
		clear();
		
	}
	
	//creates the buttons makes the random start and end
	//resets the game 
	void clear(){
		//clears the old buttons
		field.removeAll();
		
		//makes the random start location
		start=enemy.nextInt(25);
		
		//keeps the end being the same location as the start
		do{
			end = enemy.nextInt(25);
		}while(start==end);
		
		//if the button is start or end they will be green
		//the rest are changed to the color yellow
		for(int i=0; i<25;i++){
			if(i==start){
				danger[i]=new Button("Start");
				danger[i].select();
				danger[i].getBackground();
				danger[i].setBackground(Color.green);
				field.add(danger[i]);
			}
			else if(i==end){
				danger[i] =new Button("End");
				danger[i].getBackground();
				danger[i].setBackground(Color.green);
				field.add(danger[i]);
			}
			else{
				danger[i]=new Button();
				danger[i].getBackground();
				danger[i].setBackground(Color.yellow);
				field.add(danger[i]);
			}
			
		}
		
		//makes 2 different location for mine
		do{
			mine1 = enemy.nextInt(25);
		}while(mine1==start || mine1==end);
		
		do{
			mine2 =enemy.nextInt(25);
		}while(mine2==mine1|| mine2==start|| mine2 ==end);
		
		danger[mine1].setMine();
		danger[mine2].setMine();
		
		for(int i=0; i<25;i++){
			
			//adds the listener for the buttons in the mine field
			danger[i].addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					for(int i=0; i<25; i++){
						if(e.getSource()==danger[i]){
							
							//prevents the end and start pieces from changing from seleceted or
							//deselected
							if(danger[i]==danger[start]|| danger[i]==danger[end]){
								danger[i].getBackground();
							 	danger[i].setBackground(Color.green);
								
							}
							
							//prevents spots froma appearing selected and being deselected
							else if(danger[i].getBackground().equals(Color.black)){}
							
							//all other buttons allow selection only if remote button pressed and
							//prevent rap around selection
							else if(i<4&&i>0&&(e.getSource()==danger[i])&&(danger[i-1].getSelected()||
									danger[i+1].getSelected()||danger[i+5].getSelected())){
				
								 	danger[i].setBackground(Color.black);
								 	danger[i].select();
							
							}
							else if(i>20&&i<24&&(e.getSource()==danger[i])&&(danger[i-1].getSelected()||
									danger[i+1].getSelected()||danger[i-5].getSelected())){
								danger[i].getBackground();
							 	danger[i].setBackground(Color.black);
							 	danger[i].select();
							}
							else if(i==24&&(e.getSource()==danger[i])&&(danger[i-1].getSelected()||
									danger[i-5].getSelected())){
								danger[i].getBackground();
							 	danger[i].setBackground(Color.black);
							 	danger[i].select();
							}
							else if(i==0&&(e.getSource()==danger[i])&&(danger[i+1].getSelected()||
									danger[i+5].getSelected())){
								danger[i].getBackground();
							 	danger[i].setBackground(Color.black);
							 	danger[i].select();
							}
							else if(i==20&&(e.getSource()==danger[i])&&(danger[i+1].getSelected()||
									danger[i-5].getSelected())){
								danger[i].getBackground();
							 	danger[i].setBackground(Color.black);
							 	danger[i].select();
							}
							else if(i==4&&(e.getSource()==danger[i])&&(danger[i-1].getSelected()||
									danger[i+5].getSelected())){
								danger[i].getBackground();
							 	danger[i].setBackground(Color.black);
							 	danger[i].select();
							}
							else if(((i>5&&i<9)||(i>10&&i<14)||(i>15&&i<19))&&(danger[i+5].getSelected()||
									danger[i+1].getSelected()||danger[i-1].getSelected()||danger[i-5].getSelected())){
								danger[i].getBackground();
							 	danger[i].setBackground(Color.black);
							 	danger[i].select();
							}
							else if((i==5||i==10||i==15)&&(danger[i+5].getSelected()||
									danger[i+1].getSelected()||danger[i-5].getSelected())){
								danger[i].getBackground();
							 	danger[i].setBackground(Color.black);
							 	danger[i].select();
							}
							else if((i==9||i==14||i==19)&&(danger[i+5].getSelected()||
									danger[i-1].getSelected()||danger[i-5].getSelected())){
								danger[i].getBackground();
							 	danger[i].setBackground(Color.black);
							 	danger[i].select();
							}
						}
					}
					
				}
			});
			
		}
		
		//makes GUI aspects oof the game
		Container con =getContentPane();
		main.add(field);
		buttons.add(done);
		buttons.add(clear);
		main.add(buttons);
		con.add(main);
		setContentPane(con);
		setVisible(true);
	}
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
}
