/******************************************************************************
 * @filename: FacePicture
 * @author: Patrick Hamod
 * @date: 10 oct 2012
 *@version: 1
 * 
 * cuts the face out of one picture and pastes on top of the background
 ******************************************************************************/
import java.awt.image.*;

public class FacePicture{
	
	public static void main (String[] args){
		
		
		//color combined picture window
		DrawingKit dk1 = new DrawingKit("Face in Space", 800, 800);
		
		//imports picture
		BufferedImage p1 = dk1.loadPicture("face.jpg");
		
		
		//cut the face out
		BufferedImage face =  p1.getSubimage(20, 60, 245, 205);
		
		//draws background
		BufferedImage bg = dk1.loadPicture("bg.jpg");
		dk1.drawPicture(bg,0,0);
		dk1.drawPicture(face,20,60);
		
		
		
		
	}
}
