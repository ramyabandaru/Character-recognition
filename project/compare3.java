import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
public class compare3
{
   BufferedImage  image1;
 BufferedImage  image2;
 
  int width,flag=0;
   int height;
	File input2;
	int count=0;
	int count2=0;
   public compare3() 
	{
      try 
	{
         File input1 = new File("z.jpg");
	image1 = ImageIO.read(input1);
	String s=".jpg";
	char ch='a';
	for(int k=0;k<26;k++)
	{
	//c=(char)c+k;
	input2 = new File(ch+s);
	//System.out.println(ch+s);
	image2 = ImageIO.read(input2);
         //width1 = image1.getWidth();
         //height1 = image1.getHeight();
	width= image2.getWidth();
         height= image2.getHeight();
        l1: 
	for(int i=0; i<height; i++)
	{
            for(int j=0; j<width; j++)
	{
	if(image1.getRGB(j, i)==image2.getRGB(j, i))  
	{
	//System.out.println("kk"+image1.getRGB(j, i));
	count++;
	//break l1;
	}
	Color c = new Color(image2.getRGB(j, i));
	if(c.getRed()==0 )
	{
	//System.out.println("ffff"+c.getGreen());
	count2++;
          }
	}
		
	}
	System.out.println("hiiiiiiiiiiii"+ch+ch+ch+ch);
	if((count2-count)<(count2/10))
		flag=1;	
	if(flag==1)
		break;
	ch++;
	
	}

       if(flag==1)
		System.out.println("found"+ch);
	else
		System.out.println("not found");

      } catch (Exception e) {System.out.println(e.getMessage());}
   }
   public static void main(String args[]) throws Exception 
   {
      compare3 obj = new compare3();
   }
}