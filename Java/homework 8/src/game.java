/******************************************************************************
 * @filename: Game
 * @author: Patrick Hamod
 * @date: 16 Nov 2012
 *@version: 1
 * 
 * runs the Mine Field game and checks the array of buttons to see if user survives
 ******************************************************************************/
import java.awt.Color;
import java.util.Random;

import javax.swing.JOptionPane;


public class game {

	static JOptionPane message =new JOptionPane();
	boolean alive=false;
	
	//checks an array of buttons to make user makes it to the end
	//and makes sure they did not step on a mine
	boolean Check(Button[] b, int end){
		for(int i=0; i<b.length;i++){
			
			//if the user doesnt make it to the end they die
			if(!b[i].check()){
		
				//all ifs check to see if the selected are connected to the end
				if(end==0 && ((b[i]==b[end+5] && b[i].getSelected())||
						(b[i]==b[end+1]&&b[i].getSelected()))){
					
						alive =true;
						break;
				}
					
				else if(((end>5&&end<9)||(end>10&&end<14)||(end>15&&end<19))&&(((b[i]==b[end-1]&&b[i].getSelected())||
						(b[i]==b[end+1]&&b[i].getSelected())||
							(b[i]==b[end+5]&&b[i].getSelected())|| (b[i]==b[end-5]&&b[i].getSelected())))){
				
						alive =true;
						break;
				}
				
				else if(end==24&&(((b[i]==b[end-1]&&b[i].getSelected())||
						(b[i]==b[end-5]&&b[i].getSelected())))){
					
						alive =true;
						break;
				}
				
				else if(end<24&&end>20&&(((b[i]==b[end-1]&&b[i].getSelected())||
						(b[i]==b[end+1]&&b[i].getSelected())||
						(b[i]==b[end-5]&&b[i].getSelected())))){
					
						alive =true;
						break;
				}
				
				else if(end<5&&end>0&&(((b[i]==b[end-1]&&b[i].getSelected())||
						(b[i]==b[end+1]&&b[i].getSelected())||
						(b[i]==b[end+5]&&b[i].getSelected())))){
					
						alive =true;
						break;
				}
				
				
					
				else if((end==5||end==10||end==15)&&((b[i]==b[end-5]&&b[i].getSelected())||(b[i]==b[end+1]&&b[i].getSelected())||
						(b[i]==b[end+5]&&b[i].getSelected()))){
					
						alive =true;
						break;
				}
				
				else if((end==9||end==14||end==19) &&((b[i]==b[end-5]&&b[i].getSelected())
						||(b[i]==b[end-1]&&b[i].getSelected())||
						(b[i]==b[end+5]&&b[i].getSelected()))){
					
						alive =true;
						break;
					
				}
				
		
				else if(end==4&&((b[i]==b[end-1]&&b[i].getSelected())|| (b[i]==b[end+5]&&b[i].getSelected()))){
						alive=true;
						break;
					
				}
				
				else if(end==20&&((b[i]==b[end+1]&&b[i].getSelected())|| (b[i]==b[end-5]&&b[i].getSelected()))){
					alive=true;
					break;
				
				}
				
				else{
						alive = false;
				}
			}
			else{ 
				alive=false;
				break;
			}
		}
		
		return alive;
	}
	
	//main method to execute game
	public static void main (String[] args){
		 JOptionPane.showMessageDialog(null, "Welcome to the Minefield the only way out is through the "+
					"underground tunnels.\n This is no time for indecision there is no do over with your steps.");
		MineField one =new MineField("MineField");
	}
}
