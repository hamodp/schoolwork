/******************************************************************************
 * @filename: FaceDominate
 * @author: Patrick Hamod
 * @date: 10 oct 2012
 *@version: 1
 * 
 * cuts the face out of one picture and pastes on top of the background and adds the pixel
 * colors together with 9:1 ratio in favor of face picture
 ******************************************************************************/
import java.awt.Color;
import java.awt.image.BufferedImage;


public class FaceDominate {
public static void main(String[] args){
		
		int x;
		int y;
		
		//black and white pictures combined
		DrawingKit dk2 = new DrawingKit("B&W face in Space", 800,800);
		
		//import picture for black and white
		BufferedImage p2= dk2.loadPicture("face.jpg");
		BufferedImage bg2 = dk2.loadPicture("bg.jpg");
		
		
		
		//makes the face black and white
		for(x=0; x< 800; x++){
			for( y = 0; y< 800; y++){
				
				//sets what the pixels of the combined pictures are
				if(x< p2.getWidth() && y< p2.getHeight()){
					
					//make reference for face pixel color
					int encodedPixelColor = p2.getRGB(x, y);
					 Color pixelColor = new Color(encodedPixelColor); 
					
					//makes reference for background picture
					int pixel2 = bg2.getRGB(x, y);
					Color space = new Color(pixel2);
				       
				    //face colors 
				    int red =  pixelColor.getRed() ;
				    int green =  pixelColor.getGreen() ;
				    int blue =  pixelColor.getBlue();
				    
				    //background colors
				    int red2= space.getRed();
				    int green2 = space.getGreen();
				    int blue2 = space.getBlue();
				    
				    // makes the colors black and white
				    red = (int)(red*.9 +red2*.1);
				    green = (int)(green*.9+green2*.1);
				    blue = (int)(blue*.9+blue2*.1);
	
				    // update the pixel color in picture 
				    Color newPixelColor = new Color(red, green, blue);
				    int newRgbvalue = newPixelColor.getRGB();
				    p2.setRGB(x, y, newRgbvalue);
				    bg2.setRGB(x, y, newRgbvalue);
				}
				else{ 
					
					//makes reference for background picture
					int pixel2 = bg2.getRGB(x, y);
					Color space = new Color(pixel2);
				       
				    //white because lies outside the resolution of picture 
				    int red =  0;
				    int green =  0 ;
				    int blue =  0;
				    
				    //background colors
				    int red2= space.getRed();
				    int green2 = space.getGreen();
				    int blue2 = space.getBlue();
				    
				    // makes the colors black and white
				    red = (int)(red*.9 +red2*.1);
				    green = (int)(green*.9+green2*.1);
				    blue = (int)(blue*.9+blue2*.1);
	
				    // update the pixel color in picture 
				    Color newPixelColor = new Color(red, green, blue);
				    int newRgbvalue = newPixelColor.getRGB();
				    bg2.setRGB(x, y, newRgbvalue);
				}
			}		
		}
		BufferedImage face2= p2.getSubimage(20, 60, 245, 205);
		
		//draws the cropped face onto the background
		dk2.drawPicture(bg2,0,0);
		dk2.drawPicture(face2, 200, 200);
	}
}
