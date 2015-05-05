import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
public class black {
   BufferedImage  image;
   int width;
   int height;
	int p;
   public black() {
      try {
         File input = new File("resize.jpg");
         image = ImageIO.read(input);
         width = image.getWidth();
         height = image.getHeight();
         for(int i=0; i<height; i++){
            for(int j=0; j<width; j++){
               Color c = new Color(image.getRGB(j, i));
               int red = (int)(c.getRed()*0.299);
               int green =(int)(c.getGreen()*0.587);
               int blue =(int)(c.getBlue()*0.114);
		int k=red+green+blue/3;
		if(k < 127)
		{
			p=0;
		}
		else
		{
	 	 
			p=255;
		}		
		Color newColor = new Color(p,p,p);
               image.setRGB(j,i,newColor.getRGB());
               }
          }
         File ouptut = new File("blackbbb.jpg");
         ImageIO.write(image, "jpg", ouptut);
      } catch (Exception e) {}
   }
   static public void main(String args[]) throws Exception 
   {
      black obj = new black();
   }
}