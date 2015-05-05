import javax.imageio.ImageIO;
import java.awt.image.FilteredImageSource;
import java.awt.image.ImageFilter;
import java.awt.image.CropImageFilter;
import java.awt.image.BufferedImage;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
class hd extends Frame implements ActionListener
{
 int line[][],lines,words[][],letters[][],letter=0,lett[][],ne=0;
 BufferedImage input;
 String s1="enter file name along with extension(Eg:demo.jpg)";
 Label l1;
 TextField t1;
 Button b1;
 can1 c1;
 hd()
 {
  letters=new int[200][4];
  lett=new int[200][4];
  line=new int[1000][2];
  //for(int z=0;z<10;z++)
  //{
   //line[z][0]=-1;
   //line[z][1]=-1;
  //}
  l1=new Label("enter the file name");
  t1=new TextField(20);
  b1=new Button("ok");
  b1.addActionListener(this);
  c1=new can1();
  add(l1);
  add(t1);
  add(b1);
  add(c1);
  setLayout(new FlowLayout());
  setSize(400,400);
  setVisible(true);
 }
 public static void main(String args[])
 {
  hd h=new hd();
 }
 public void actionPerformed(ActionEvent e)
 {
  ne=0;
  try{
  File ip=new File(t1.getText());
  input=ImageIO.read(ip);}catch(Exception eee){}
  s1="please wait";
  c1.repaint();
  bw();
  nol();
  now();
  for(int i=0;i<letter;i++)
  crop(i);
  s1="done";
  c1.repaint();
  System.out.println("no. of e's in the image = "+ne);
 }
 class can1 extends Canvas
 {
  can1(){setSize(400,400);setBackground(Color.white);}
  public void paint(Graphics g)
  {
   g.drawString(s1,50,50);
  }
 }
 public void bw()
 {
          int t=0;
          try{
           for(int i=0; i<input.getHeight(); i++){
            for(int j=0; j<input.getWidth(); j++){
               Color c = new Color(input.getRGB(j, i));
               int red = (int)(c.getRed() * 0.299);
               int green = (int)(c.getGreen() * 0.587);
               int blue = (int)(c.getBlue() *0.114);
	if(red+green+blue > 70)
		t=255;
	else
		t=0;
               Color newColor = new Color(t,t,t);
               input.setRGB(j,i,newColor.getRGB());
               }
          }
         File ouptut = new File("bw8.jpg");
         ImageIO.write(input, "jpg", ouptut);
          }catch(Exception e){System.out.println(""+e);}
 }
 public void nol()
 {
  int t=0,tt=0,n=0,i,j,start=0,end=0,k=0;
  for(i=100;i<input.getHeight()-100;i++)
  {
       for(j=0;j<input.getWidth();j++)
       {
        Color c=new Color(input.getRGB(j,i));
        if(c.getRed()==0 && c.getGreen()==0 && c.getBlue()==0)
			t++;
       }
       if(t>3 && tt==0)
       {
		tt++;
		n++;
		//System.out.println("strating of line "+n+" = "+i);
		line[k][0]=i;
		start=i;
       }
       else if(t<=3 && tt==1)
       {
		tt--;
		//System.out.println("ending of line "+n+" = "+i);
		line[k][1]=i;
		k++;
		end=i;
       }
       t=0;
  }
  //lines=k;
  //System.out.println("no. of lines : "+k);
  //for(int z=0;z<k;z++)
   //System.out.println(""+line[z][0]+" "+line[z][1]);
   for(int z=0;z<k;z++)
    if((line[z][1]-line[z][0])<20)
	line[z][0]=-1;
  //for(int z=0;z<k;z++)
   //System.out.println(""+line[z][0]+" "+line[z][1]);
  int q=0;
  for(int z=0;z<k;z++)
  {
   if(line[z][0]!=-1)
   {
    line[q][0]=line[z][0];
	line[q][1]=line[z][1];
	q++;
   }
  }
  //for(int z=0;z<q;z++)
   //System.out.println(""+line[z][0]+" "+line[z][1]);
  lines=q;
  System.out.println("no. of lines : "+lines);
 }
 public void now()
 {
  int start=0,end=0,t=0,tt=0,n=0,i,j,let=0;
  for(int k=0;k<lines;k++)
  {
   for(j=0;j<input.getWidth();j++)
   {
    for(i=line[k][0];i<=line[k][1];i++)
    {
        Color c=new Color(input.getRGB(j,i));
        if(c.getRed()==0 && c.getGreen()==0 && c.getBlue()==0)
		t++;     
    }
    if(t>2 && tt==0)
    {
     tt++;
	 letters[let][0]=line[k][0];
	 letters[let][1]=line[k][1];
	 letters[let][2]=j;
    }
    if(t<=2 && tt==1)
    {
     tt--;
	 letters[let][3]=j;
	 let++;
    }
    t=0;
   }
   for(int z=0;z<let;z++)
    if((letters[z][3]-letters[z][2])<10)
	letters[z][2]=-1;
   int q=0;
   for(int z=0;z<let;z++)
   {
    if(letters[z][2]!=-1)
    {
     letters[q][0]=letters[z][0];
	 letters[q][1]=letters[z][1];
	 letters[q][2]=letters[z][2];
	 letters[q][3]=letters[z][3];
	 q++;
    }
   }
   for(int z=0;z<q-1;z++)
   {
    if((letters[z+1][2]-letters[z][3])<5 && letters[z+1][0]==letters[z][0] && letters[z+1][1]==letters[z][1])
	{
	 letters[z][3]=letters[z+1][3];
	 letters[z+1][2]=-1;
	}
   }
   int v=0;
   for(int z=0;z<q;z++)
   {
    if(letters[z][2]!=-1)
    {
     letters[v][0]=letters[v][0];
	 letters[v][1]=letters[v][1];
	 letters[v][2]=letters[v][2];
	 letters[v][3]=letters[v][3];
	 v++;
    }
   }
   System.out.println("no. of letters in "+(k+1)+" line : "+v);
   //for(int z=0;z<v;z++)
    //System.out.println(""+letters[z][0]+" "+letters[z][1]+" "+letters[z][2]+" "+letters[z][3]+" ");
   for(int z=0;z<v;z++)
   {
    lett[n][0]=letters[z][0];
	lett[n][1]=letters[z][1];
	lett[n][2]=letters[z][2];
	lett[n][3]=letters[z][3];
	n++;
   }
   let=0;
  }
  System.out.println("total no. of letters : "+n);
  //for(int z=0;z<n;z++)
  //System.out.println(""+lett[z][0]+" "+lett[z][1]+" "+lett[z][2]+" "+lett[z][3]+" ");
  letter=n;
 }
 public void crop(int i)
 {
  int x,y,width,height,xy[][],count=0,count2=0;
  xy=new int[10000][2];
  x=lett[i][2];
  y=lett[i][0];
  width=lett[i][3]-x;
  height=lett[i][1]-y;
  try{
  ImageFilter imf=new CropImageFilter(x,y,width,height);
  Image temp=Toolkit.getDefaultToolkit().createImage(new FilteredImageSource(input.getSource(),imf));
  BufferedImage output=new BufferedImage(width,height,input.getType());
  Graphics2D b=output.createGraphics();
  b.drawImage(temp,0,0,null);
  b.dispose();
  BufferedImage output2=new BufferedImage(100,100,input.getType());
  Graphics2D bb=output2.createGraphics();
  bb.drawImage(output,0,0,100,100,null);
  bb.dispose();
  for(int k=0;k<output2.getHeight();k++)
   for(int j=0;j<output2.getWidth();j++)
   {
    Color c=new Color(output2.getRGB(j,k));
	if(c.getRed()==0 && c.getGreen()==0 && c.getBlue()==0)
	{
	 xy[count][0]=j;
	 xy[count][1]=k;
	 count++;
	}
   }
  File ip=new File("E.jpg");
  BufferedImage tip=ImageIO.read(ip);
  for(int z=0;z<count;z++)
  {
   Color c=new Color(tip.getRGB(xy[z][0],xy[z][1]));
   if(c.getRed()==0 && c.getGreen()==0 && c.getBlue()==0)
   {
    count2++;
   }
  }
  if((count-count2)<(count/10))
  ne++;
  //System.out.println("count = "+count+" count2 = "+count2);
  File op=new File("crop-hd.jpg");
  ImageIO.write(output2,"jpg",op);}catch(Exception e){System.out.println("crop\n"+e);}
 }
}