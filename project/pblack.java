import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
class pblack {
   BufferedImage  image;
   int width;
   int height;
   public pblack() {
      try {
         //File input = new File("blackAndwhite11.jpg");
	System.out.println("s1");
         image = ImageIO.read("blackAndwhite11.jpg");
        System.out.println("s2"); 
	width = image.getWidth();
System.out.println("s3");
         height = image.getHeight();
System.out.println("s4");	
int pixel[][]=new int[width][height];
         int count = 0;
         for(int i=0; i<height; i++){
            for(int j=0; j<width; j++){
               count++;
               Color c = new Color(image.getRGB(j, i));
		pixel[j][i]=image.getRGB(j,i);
               //System.out.println("S.No: " + count + " Red: " + c.getRed() +
               //" Green: " + c.getGreen() + " Blue: " + c.getBlue());
		//System.out.println(pixel[j][i]);
               }
            }
		System.out.println(count);
      } catch (Exception e) {System.out.println("error");}
   }
   static public void main(String args[]) throws Exception 
   {
      Pixel obj = new Pixel();
   }
}