import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
class Pixel {
   BufferedImage  image;
   int width;
   int height;
   public Pixel() {
      try {
         File input = new File("a.jpg");
         image = ImageIO.read(input);
         width = image.getWidth();
         height = image.getHeight();
         int count = 0;
         for(int i=0; i<height; i++){
            for(int j=0; j<width; j++){
               count++;
               Color c = new Color(image.getRGB(j, i));
               
		if(i==0 && j==0 || i==400 && j==400)
		System.out.println("S.No: " + count + " Red: " + c.getRed() +
               " Green: " + c.getGreen() + " Blue: " + c.getBlue());
               }
            }
	System.out.println("count"+count);
      } catch (Exception e) {System.out.println(e.getMessage());}
   }
   static public void main(String args[]) throws Exception 
   {
      Pixel obj = new Pixel();
   }
}