import javax.imageio.ImageIO;
import java.awt.image.FilteredImageSource;
import java.awt.image.ImageFilter;
import java.awt.image.CropImageFilter;
import java.awt.image.BufferedImage;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.awt.image.*;
import javax.swing.JFrame;
class crop {
   BufferedImage  image;
   int width;
   int height;
   public crop() {
      try {
         File input = new File("x.jpg");
         image = ImageIO.read(input);
         width = image.getWidth();
         height = image.getHeight();
         int count = 0;
	int t=0;
	int tt=0;
	int w1=0;	
	int ww=0;
	int endl=0,startl=0,startw=0,endw=0;
	System.out.println("s1");
	l1:
	for(int i=0;i<height;i++)
	{
		//System.out.println("s2");
	 	for(int j=0;j<width;j++)
		{
		Color c = new Color(image.getRGB(j, i));	
		if(c.getRed()==0 && c.getGreen()==0 && c.getBlue()==0)
		{ 
			t++;
		}
		}
		if(t>0 && tt==0)
		{
			startl=i;
			//System.out.println("ss1"+startl);
			tt++;
		}
		if(t>0 && tt>0)
			tt++;
		if((t==0 && tt>0 && count==0)|| i==height-1)
		{
			
			count++;
			endl=i;
			//break l1;
		}
		if(t>0 && count>0)
			count=0;
		if(count> 30)
			break l1;
		if(t==0 && tt>0 && count>0)
			count++;
		t=0;
	}
	//t=0;
	
	l2:
	//System.out.println("s2");
	for(int i=0;i<width;i++)
	{
		
		for(int j=0;j<height;j++)
		{
		Color c = new Color(image.getRGB(i,j));	
		if(c.getRed()==0 && c.getGreen()==0 && c.getBlue()==0)
		{ 
			w1++;
		}
		}
		if(w1>0 && ww==0)
		{

			System.out.println("s2");
			startw=i;
			ww++;
		}
		if(w1>0 && ww>0)
			ww++;
		if(w1<1 && ww>0)
		{
			System.out.println("s2"+i);
			endw=i;
			break l2;
		}
		//if(i==width-1)
			//endw=i;	
		w1=0;
	}
		
		
		int w,h;
		System.out.println("endl"+endl+"startl"+startl+"end w"+endw+"start w"+startw);
		//startw=startw-16;
		//startl=startl-16;
		//endw=endw+16;
		//endl=endl+16;
		w=endw-startw+1;
		h=endl-startl+1;
		//System.out.println("endl"+endl+"startl"+startl+"end w"+endw+"start w"+startw);
		//w=w+12;
		//h=h+12;
		/*if(w==0 && h==0)
		{
		BufferedImage output2=new BufferedImage(100,100,image.getType());
  		Graphics2D bb=output2.createGraphics();
  		bb.drawImage(image,0,0,100,100,null);
  		bb.dispose();	
		File op=new File("a3.jpg");
  		ImageIO.write(output2,"jpg",op);
		}
		else
		{*/
		System.out.println("height and width are"+h+" "+w);
		ImageFilter imf=new CropImageFilter(startw,startl,width,height);
 	        Image temp=Toolkit.getDefaultToolkit().createImage(new FilteredImageSource(image.getSource(),imf));
  		BufferedImage output=new BufferedImage(w,h,image.getType());
  		Graphics2D b=output.createGraphics();
  		b.drawImage(temp,0,0,null);
  		b.dispose();
  		BufferedImage output2=new BufferedImage(100,100,image.getType());
  		Graphics2D bb=output2.createGraphics();
  		bb.drawImage(output,0,0,100,100,null);
  		bb.dispose();	
		File op=new File("x.jpg");
  		ImageIO.write(output2,"jpg",op);
		//System.out.println("count"+count);
		//}
      } catch (Exception e) {System.out.println(e.getMessage());}
   }
   static public void main(String args[]) throws Exception 
   {
      crop obj = new crop();
   }
}