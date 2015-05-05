import java.awt.image.*;
import javax.imageio.ImageIO;
import java.io.*;
import java.awt.*;

class BlackAndWhite
{
          public static void main(String asr[])
          {
                   try
                   {
                             //colored image path
                             BufferedImage image = ImageIO.read(new  
                                                File("IMG_20140923_215121703.jpg"));

                             //getting width and height of image
                             double image_width = image.getWidth();
                             double image_height = image.getHeight();
				//int w= (int)(image_width*0.5);
				//int h= (int)(image_height*0.5);

                             BufferedImage bimg = null;
                             BufferedImage img = image;

                             //drawing a new image      
                             bimg = new BufferedImage((int)image_width,(int)image_height,BufferedImage.TYPE_BYTE_BINARY);
				// bimg = new BufferedImage(30,30,BufferedImage.TYPE_BYTE_GRAY);
                            Graphics2D gg = bimg.createGraphics();
                             gg.drawImage(img, 0, 0,img.getWidth(null),img.getHeight(null),null);

                             //saving black and white image onto drive
                             String temp = "blackAndwhite111.jpg";
                             File fi = new File(temp);
                             ImageIO.write(bimg, "jpg", fi);
                   }
                   catch (Exception e)
                   {
                             System.out.println(e);
                   }
          }
}