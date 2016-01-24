import java.awt.image.*;
import java.awt.geom.*;
import java.awt.*;

/**
 * The purpose of this program is to demonstrate how to display and interact
 * with images.
 *
 * @author Prof. Michael N. Huhns
 * @version 1.0 Beta
 */

public class PixelColorDemo {
  public static void main(String[] args) {
    int x = 500, y = 80;
    DrawingKit dk = new DrawingKit("Daffodils", 800, 800);
    BufferedImage pict = dk.loadPicture("daffodils.jpg");

    // get pixel value at location (500, 80)
    int encodedPixelColor = pict.getRGB(x, y);
    Color pixelColor = new Color(encodedPixelColor);
    System.out.println(pixelColor);     
    int red =  pixelColor.getRed() ;
    int green =  pixelColor.getGreen() ;
    int blue =  pixelColor.getBlue();
    // change the color of the pixel to be pure red
    red = 255;
    green = 0;
    blue = 0;

    // update the pixel color in picture 
    Color newPixelColor = new Color(red, green, blue);
    int newRgbvalue = newPixelColor.getRGB();
    pict.setRGB(x, y, newRgbvalue);		
    // display the approximate location of the pixel
    dk.drawPicture(pict, 0, 0);    
    BasicStroke s = new BasicStroke(3);
    dk.setStroke(s);
    Ellipse2D.Float e = new Ellipse2D.Float(x-3, y-3, 8, 8);
    dk.draw(e);
    dk.drawString("(600, 150)", x-3, y-5);
  }
}
