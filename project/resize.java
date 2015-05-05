import java.awt.image.*;
import javax.imageio.ImageIO;
import java.io.*;
import java.awt.*;

class resize
{
          public static void main(String asr[])
          {
                   try
                   {
                             //colored image path
                             BufferedImage image = ImageIO.read(new  
                                                File("gsam.jpg"));

                             //getting width and height of image
                             
                             BufferedImage bimg;
                           
                             //drawing a new image      
                             bimg = new BufferedImage(600,600,BufferedImage.TYPE_BYTE_GRAY);
                            Graphics2D gg = bimg.createGraphics();
                             gg.drawImage(image, 0, 0,600,600,null);

				gg.dispose();

                             //saving black and white image onto drive
                             String temp = "res.jpg";
                             File fi = new File(temp);
                             ImageIO.write(bimg, "jpg", fi);
                   }
                   catch (Exception e)
                   {
                             System.out.println(e.getMessage());
                   }
          }
}