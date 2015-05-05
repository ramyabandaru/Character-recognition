class sam
{
public static void main(String args[])
{
int i,j,flag=0;
int n=Integer.parseInt(args[0]);
for(i=2;i<n;i++)
{
flag=0;
for(j=2;j<i;j++)
{
	System.out.println("flag"+flag);
	System.out.println(i);
	if((i%j)==0)
	{
		flag=1;
		break;
	}
}
if(flag==0)
	System.out.println("prime"+i);
else
	System.out.println("not prime"+i);
}
}
}