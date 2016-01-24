/******************************************************************************
 * @filename: FacePictureBlack
 * @author: Patrick Hamod
 * @date: 10 oct 2012
 *@version: 1
 * 
 * cuts the face out of one picture and pastes on top of the background and
 * makes it black and white
 ******************************************************************************/
import java.awt.Color;
import java.awt.image.BufferedImage;


public class FacePictureBlack {
	public static void main(String[] args){
		
		int x;
		int y;
		
		//black and white pictures combined
		DrawingKit dk2 = new DrawingKit("B&W face in Space", 800,800);
		
		//import picture for black and white
		BufferedImage p2= dk2.loadPicture("face.jpg");
		BufferedImage bg2 = dk2.loadPicture("bg.jpg");
		
		
		
		//makes the face black and white
		for(x=0; x< p2.getWidth(); x++){
			for( y = 0; y< p2.getHeight(); y++){
				
				int encodedPixelColor = p2.getRGB(x, y);
			    Color pixelColor = new Color(encodedPixelColor);     
			    
			    int red =  pixelColor.getRed() ;
			    int green =  pixelColor.getGreen() ;
			    int blue =  pixelColor.getBlue();
			    
			    // makes the colors black and white
			    red = (red+green+blue)/3;
			    green = (red+green+blue)/3;
			    blue = (red+blue+green)/3;

			    // update the pixel color in picture 
			    Color newPixelColor = new Color(red, green, blue);
			    int newRgbvalue = newPixelColor.getRGB();
			    p2.setRGB(x, y, newRgbvalue);		
			}		
		}
		BufferedImage face2= p2.getSubimage(20, 60, 245, 205);
		dk2.drawPicture(face2, 20, 60);
		
		//makes the background black and white
		for(x=0; x< 800; x++){
			for( y = 0; y< 800; y++){
				
				int encodedPixelColor = bg2.getRGB(x, y);
			    Color pixelColor = new Color(encodedPixelColor);
			    
			    int red =  pixelColor.getRed() ;
			    int green =  pixelColor.getGreen() ;
			    int blue =  pixelColor.getBlue();
			    
			    // makes the colors black and white
			    red = (red+green+blue)/3;
			    green = (red+green+blue)/3;
			    blue = (red+blue+green)/3;

			    // update the pixel color in picture 
			    Color newPixelColor = new Color(red, green, blue);
			    int newRgbvalue = newPixelColor.getRGB();
			    bg2.setRGB(x, y, newRgbvalue);		
			}		
		}
		dk2.drawPicture(bg2,0,0);
		dk2.drawPicture(face2, 20, 60);
	}
}
