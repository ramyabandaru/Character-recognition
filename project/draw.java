import java.util.*;
import java.awt.*;
import java.io.*;
class draw extends Frame
{
 ArrayList<Integer> al;
 int x,y,r,tx,ty,tr,xy[][],count=0;
 String sx="",sy="",sr="";
 FileInputStream fx,fy,fr;
 draw()
 {
  al=new ArrayList<Integer>();
  for(int l=0;l<51168;l++)
  al.add(l);
  Collections.shuffle(al);
  xy=new int[51168][3];
  try{
  fx=new FileInputStream("x.txt");
  fy=new FileInputStream("y.txt");
  fr=new FileInputStream("r.txt");}catch(Exception e){}
  setSize(400,400);
  setVisible(true);
  //repaint();
 }
 public static void main(String args[])
 {
  draw d=new draw();
 }
 public void paint(Graphics g)
 {
   try{
   x=fx.read();
   y=fy.read();
   r=fr.read();}catch(Exception e){}
   while((char)x!='}')
   {
   try{
    while((char)x!=',')
    {
     sx=sx+(char)x;
     x=fx.read();
    }
    while((char)y!=',')
    {
     sy=sy+(char)y;
     y=fy.read();
    }
    while((char)r!=',')
    {
     sr=sr+(char)r;
     r=fr.read();
    }
    x=fx.read();
    y=fy.read();
    r=fr.read();
    tx=Integer.parseInt(sx);
    ty=Integer.parseInt(sy);
    tr=Integer.parseInt(sr);
    //Thread.sleep(1);
    }catch(Exception e){}
    xy[count][0]=tx;
    xy[count][1]=ty;
    xy[count][2]=tr;
    count++;
    //System.out.println(""+tx+" "+ty);
    //g.setColor(new Color(tr,tr,tr));
    //g.drawRect(tx,ty,1,1);
	sx="";
	sy="";
	sr="";
   }
   Iterator itr=al.iterator();
   while(itr.hasNext())
   {
    int temp=itr.next();
    g.setColor(new Color(xy[temp][2],xy[temp][2],xy[temp][2]));
    g.drawRect(xy[temp][0],xy[temp][1],0,0);
    try{
    Thread.sleep(1);}catch(Exception e){}
   }
   System.out.println("over");
 }
}