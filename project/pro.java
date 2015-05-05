import javax.imageio.ImageIO;
import java.awt.image.FilteredImageSource;
import java.awt.image.ImageFilter;
import java.awt.image.CropImageFilter;
import java.awt.image.BufferedImage;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
class pro extends Frame implements ActionListener
{
 BufferedImage input;
 String s1=" ";
 String in;
 Label l1,l2;
 TextField t1;
 Button b1;
 pro()
 {
  l1=new Label("enter the file name");
  t1=new TextField(20);
l2=new Label("enter file name along with extension(Eg:demo.jpg)");
  b1=new Button("ok");
  //l2=new Label("done");
  b1.addActionListener(this);
  add(l1);
  add(l2);
  add(t1);
  add(b1);
  //add(l2);
  setLayout(new FlowLayout());
  setSize(400,400);
  setVisible(true);
 }
 
public void paint(Graphics g)
  {
// String s1="processing";
   g.drawString(s1,150,150);
  }
public void actionPerformed(ActionEvent ae)
 {
	in=t1.getText();
	try
	{
	input = ImageIO.read(new File(in)); 
	
	System.out.println("file is"+in);

	//resize();
	black();
	crop();
	compare();
  	//repaint();
	}
	catch (Exception e)
         {
		 s1="cannot load input image";
		repaint();
  	 }
 }

          public void resize()
          {
		System.out.println("resize");
                   try
                   {
                             //colored image path
                             BufferedImage image = ImageIO.read(new  
                                                File(in));

                             //getting width and height of image
                             
                             BufferedImage bimg;
                           
                             //drawing a new image      
                             bimg = new BufferedImage(300,300,BufferedImage.TYPE_BYTE_GRAY);
                            Graphics2D gg = bimg.createGraphics();
                             gg.drawImage(image, 0, 0,300,300,null);

				gg.dispose();

                             //saving black and white image onto drive
                             String temp = "resize.jpg";
                             File fi = new File(temp);
                             ImageIO.write(bimg, "jpg", fi);
                   }
                   catch (Exception e)
                   {
                        // s1="file not found";    
			System.out.println(e.getMessage());
           		//return;
		        }
          	}
   
public void black() {
BufferedImage  image;
   int width;
   int height;
	int p;
      try {
	System.out.println("black");
         File input = new File(in);
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
         File ouptut = new File("black.jpg");
         ImageIO.write(image, "jpg", ouptut);
      } catch (Exception e) {}
   }

     
   public void crop() {
      try {
	BufferedImage  image;
   int width;
   int height;
         File input = new File("black.jpg");
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
		if(w1>1 && ww>0)
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
		/*startw=startw-26;
		startl=startl-26;
		endw=endw+26;
		endl=endl+26;*/
		w=endw-startw;
		h=endl-startl;
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
		File op=new File("crop.jpg");
  		ImageIO.write(output2,"jpg",op);
		//System.out.println("count"+count);
		//}
      } catch (Exception e) {System.out.println(e.getMessage());}
   }
  
   public void compare() 
	{
      try 

	{
	System.out.println("compare");
	 BufferedImage  image1;
 	BufferedImage  image2;
        int min=99999;
	char cha='\0';
  	int width,flag=0;
   	int height;
	File input2;
	int count=0;
	int count2=0;
	int dif=0;
         File input1 = new File("crop.jpg");
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
	//System.out.println("hiiii");
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
	System.out.println("diff   "+(count2-count)+ch);
	dif=count2-count;
	if(dif<min)
	{
		cha=ch;
		min=dif;
	}
//if((count2-count)<count2/7)
//if(count2==count)
	//flag=1;
//if(flag==1)
	//break;
ch++;
}

       		//if(flag==1)
		//{
		System.out.println("found"+cha);
		s1="found   "+cha;
		//}
		//else
		//{
		//System.out.println("not found");
		//s1="not found";
		//}
      	repaint();
	} 
	catch (Exception e) 
	{
	System.out.println(e.getMessage());
	}
   }
	public static void main(String args[])
 {
  pro h=new pro();
 }
}