/******************************************************************************
 * @filename: Button
 * @author: Patrick Hamod
 * @date: 16 Nov 2012
 *@version: 1
 * 
 * creates the buttons for MineField that creates a start, end and mine buttons
 * to check for user survival
 ******************************************************************************/
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;


public class Button extends JButton{

	boolean connected=false;
	protected boolean hasMine=false;
	protected boolean start=false;
	protected boolean end=false;
	boolean selected =false;
	
	Button(String name){
		super(name);
	}
	
	Button(){
		super();
	}
	
	//makes the button start
	void setStart(){
		start=true;
	}
	
	//makes the end
	void setEnd(){
		end=true;
	}
	
	//makes mines
	void setMine(){
		hasMine=true;
	}
	
	//makes the spot back to regular
	void reset(){
		start =false;
		end =false;
		hasMine=false;
	}
	
	//selects and deselects spots
	void select(){
		if(selected)selected=false;
		else selected =true;
	}
	
	//tell if the spot is start
	boolean getStart(){
		return start;
	}
	
	//tell if spot is end
	boolean getEnd(){
		return end;
	}
	
	//checks if spot killed user
	boolean check(){
		if(hasMine&& selected)return true;
		else return false;
	}
	
	//tells if spot is selected
	boolean getSelected(){
		return selected;
	}
	
}
