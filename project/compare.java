import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
public class compare
{
   BufferedImage  image1;
 BufferedImage  image2;
 
  int width,flag;
   int height;
	File input2;
   public compare() 
	{
      try 
	{
	//flag=1;
         File input1 = new File("crop-hd.jpg");
	image1 = ImageIO.read(input1);
	String s=".jpg";
	char c='a';
	for(int k=0;k<26;k++)
	{
	flag=1;
	//c=(char)c+k;
	input2 = new File(c+s);
	//System.out.println(c+s);
	image2 = ImageIO.read(input2);
         //width1 = image1.getWidth();
         //height1 = image1.getHeight();
	width= image2.getWidth();
         height= image2.getHeight();
        l1: 
	//{
	for(int i=0; i<height; i++)
	{
            for(int j=0; j<width; j++)
	{
	if(image1.getRGB(j, i)!=image2.getRGB(j, i))  
	{
	//System.out.println("kk");
	flag=0;
	break l1;
	}
          }
	//}
		
	}
	//System.out.println("hiiiiiiiiiiii");
	if(flag==1)
			break;
	c++;
	}
       if(flag==1)
		System.out.println("found"+c);
	else
		System.out.println("not found");

      } catch (Exception e) {}
   }
   public static void main(String args[]) throws Exception 
   {
      compare obj = new compare();
   }
}