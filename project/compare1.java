import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
public class compare1
{
   BufferedImage  image1;
 BufferedImage  image2;
 
  int width,flag=0;
   int height;
	File input2;
	int count=0;
	int count2=0;
   public compare1() 
	{
      try 

	{
         File input1 = new File("a.jpg");
	image1 = ImageIO.read(input1);
	String s=".jpg";
	char ch='a';
	width= image1.getWidth();
         height= image1.getHeight();
	for(int k=0;k<26;k++)
	{
	count=0;
	count2=0;
	input2 = new File(ch+s);
	//System.out.println(c+s);
	image2 = ImageIO.read(input2);
         //width1 = image1.getWidth();
         //height1 = image1.getHeight();
	
        //l1: 
	System.out.println("hiiii");
	for(int i=0;i<height;i++)
{
for(int j=0;j<width;j++)
{
	Color c1=new Color((image1.getRGB(j, i)));
	Color c2=new Color((image2.getRGB(j, i)));
	if(c1.getRed()==0 && c1.getBlue()==0 && c1.getGreen()==0)
	{
	if(c2.getRed()==0 && c2.getBlue()==0 && c2.getGreen()==0)
		count++;
	count2++;
	}
	//if(c2.getRed()==0)
	//	count2++;
}
}
	System.out.println("count"+count+"count2"+count2);
	System.out.println("diff   "+(count2-count));
if((count2-count)<count2/10)
//if(count2==count)
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
      compare1 obj = new compare1();
   }
}