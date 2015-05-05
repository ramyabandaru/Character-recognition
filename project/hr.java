import javax.imageio.ImageIO;
import java.awt.image.FilteredImageSource;
import java.awt.image.ImageFilter;
import java.awt.image.CropImageFilter;
import java.awt.image.BufferedImage;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
class hr extends Frame implements ActionListener
{
 BufferedImage input;
 String s1="hi";
 String in;
 Label l1,l2;
 TextField t1;
 Button b1;
 hr()
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
public void actionPerformed(ActionEvent e)
 {
	in=t1.getText();
	resize();
	black();
	crop();
	compare();
  	//repaint();
  
 }

          public void resize()
          {
		System.out.println("resize");
                   try
                   {
                             //colored image path
                             BufferedImage image = ImageIO.read(new  
                                                File("in"));

                             //getting width and height of image
                             
                             BufferedImage bimg;
                           
                             //drawing a new image      
                             bimg = new BufferedImage(600,600,BufferedImage.TYPE_BYTE_GRAY);
                            Graphics2D gg = bimg.createGraphics();
                             gg.drawImage(image, 0, 0,600,600,null);

				gg.dispose();

                             //saving black and white image onto drive
                             String temp = "resize.jpg";
                             File fi = new File(temp);
                             ImageIO.write(bimg, "jpg", fi);
                   }
                   catch (Exception e)
                   {
                         s1="file not found";    
			System.out.println(e.getMessage());
           		return;
		        }
          	}
   
public void black() {
BufferedImage  image;
   int width;
   int height;
	int p;
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
         File ouptut = new File("black.jpg");
         ImageIO.write(image, "jpg", ouptut);
      } catch (Exception e) {}
   }
   
   public void crop() {
	int width;
   int height;
	BufferedImage  image;
      try {
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
		if(t>3 && tt==0)
		{
			startl=i;
			//System.out.println("ss1"+startl);
			tt++;
		}
		else if(t>3&& tt>0)
			tt++;
		else if(t<3 && tt>0)
		{
			endl=i;
			break l1;
		}	
			t=0;
	}
	l2:
	for(int i=0;i<width;i++)
	{
		//System.out.println("s2");
		for(int j=0;j<height;j++)
		{
		Color c = new Color(image.getRGB(i,j));	
		if(c.getRed()==0 && c.getGreen()==0 && c.getBlue()==0)
		{ 
			w1++;
		}
		}
		if(w1>2 && ww==0)
		{
			startw=i;
			ww++;
		}
		else if(w1>2 && ww>0)
			tt++;
		else if(w1<2 && ww>0)
		{
			endw=i;
			break l2;
		}	
			w1=0;
	}
		System.out.println("endl"+endl+"startl"+startl+"end w"+endw+"start w"+startw);
		
		int w,h;
		w=endw-startw;
		h=endl-startl;
		System.out.println("height and width are"+w+h);
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
      } catch (Exception e)
	 {
		System.out.println(e.getMessage());
	 }
   }  
   public void compare() 
	{
	BufferedImage  image1;
 BufferedImage  image2;
 
  int width,flag=0;
   int height;
	File input2;
	int count=0;
	int count2=0;
      try 
	{
         File input1 = new File("crop.jpg");
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
	//System.out.println("kk");
	count++;
	break l1;
	}
	Color c = new Color(image1.getRGB(j, i));
	if(c.getRed()==0 && c.getGreen()==0 && c.getBlue()==0)
	count2++;
          }
	//}
		
	}
	//System.out.println("hiiiiiiiiiiii");
	if((count2-count)<(count/10))
		flag=1;	
	if(flag==1)
		break;
	ch++;
	}
	
       if(flag==1)
	{
		System.out.println("found"+ch);
		s1="found     "+ch;
	}
	else
	{
		System.out.println("not found");
		s1="not found";
      	} 
	repaint();
	}catch (Exception e) {}
   }
public static void main(String args[])
 {
  hr h=new hr();
 }
}