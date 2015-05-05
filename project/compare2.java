import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
public class compare2
{
   BufferedImage  image1;
 BufferedImage  image2;
 
  int width,flag=0;
   int height;
	File input2;
	int count=0,i,j,max,m,ct=0;
	int count2=0;
   public compare2() 
	{
      try 
	{
         File input1 = new File("z.jpg");
	image1 = ImageIO.read(input1);
	String s=".jpg";
	char ch='a';
	char f;
	for(int k=0;k<26;k++)
	{
	input2 = new File(ch+s);
	System.out.println(ch+s);
	image2 = ImageIO.read(input2);
         //width1 = image1.getWidth();
         //height1 = image1.getHeight();
	width= image2.getWidth();
         height= image2.getHeight();
        //l1: 
	for(i=0;i<height;i++)
	{
	for(j=0;j<width;j++)
	{
	Color c1=new Color((image1.getRGB(j, i)));
	Color c2=new Color((image2.getRGB(j, i)));
	if(c2.getRed()==0)
	{
	if(c1.getRed()==0)
		count++;
		count2++;
	}
	//if(c2.getRed()==0)
		//count2++;
	}
	}
	m=(count2-count);
	System.out.println("count"+count+"count2"+count2);
	if(ct==0)
	{
	max=count2-count;
	flag=1;
	f=ch;
	ct++;
	}
	if(m<max)
		f=ch;
	//if(flag==1)
	//break;
	ch++;
	}

       if(flag==1)
		System.out.println("found");
	else
		System.out.println("not found");

      } catch (Exception e) {System.out.println(e.getMessage());}
   }
   public static void main(String args[]) throws Exception 
   {
      compare2 obj = new compare2();
   }
}