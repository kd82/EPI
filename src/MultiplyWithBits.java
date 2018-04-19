
public class MultiplyWithBits {
	
   public static class Rectangle{
	   int X,Y,Width,Height;
	   public Rectangle(int x,int y,int width,int height)
	   {
		   this.X=x;
		   this.Y=y;
		   this.Width=width;
		   this.Height=height;
	   }
   }
   public static void main(String args[])
   {
	   long x=999993l;
	   long y=3l;
	   Rectangle r1=new Rectangle(1, 2, 3, 3);
	   Rectangle r2=new Rectangle(1, 2, 3, 3);
	   //System.out.println(isRectangleIntersect(r1,r2));
	   //System.out.println(multiply(x,y));
	   System.out.println(isPalindrome(Integer.MAX_VALUE));
	   //System.out.println(reverse(-121));
   }

private static boolean isRectangleIntersect(Rectangle r1, Rectangle r2) {
	boolean res=true;
	if((r1.X+r1.Width<=r2.X || r2.X+r2.Width<=r1.X) && (r1.Y+r1.Height<=r2.Y||r2.Y+r2.Height<=r1.Y ))
	{
		res=false;
	}
	Rectangle result=new Rectangle(
			Math.max(r1.X, r2.X),
			Math.max(r1.Y, r2.Y),
			Math.min(r1.X+r1.Width, r2.X+r2.Width)-Math.max(r1.X, r2.X),
			Math.min(r1.Y+r1.Height, r2.Y+r2.Height)-Math.max(r1.Y, r2.Y)
			);
	System.out.println(result.X+" "+result.Y+" "+result.Height+" "+result.Width);
	return res;
}

private static boolean isPalindrome(int a) {
    if(a<0 || (a%10==0 && a!=0))
    	return false;
    final int numOfDigits=(int)(Math.floor(Math.log10(a)))+1;
    int msb=(int)Math.pow(10, numOfDigits-1);
    
    for(int i=0;i<numOfDigits/2;++i)
    {
    	if(a/msb!=a%10)
    		return false;
      a%=msb;
      a/=10;
      msb/=100;
    }
	return true;
}

private static int reverse(int n)
{
	long res=0;
	long xRemain=Math.abs(n);
	while(xRemain!=0)
	{
		res=res*10+xRemain%10;
		xRemain/=10;
	}
	if(n==res)
	{
		System.out.println("Palindrome!");
	}
	return n<0?-(int)res:(int)res;
}

private static long multiply(long x, long y) {
	// TODO Auto-generated method stub
	long result=0;
	 while(x!=0)
	 {
		 if((x&1)!=0)
		    result=sum(result,y);
		 x>>>=1;
		 y<<=1;
	 }
	 return result;
}

private static long sum(long a, long b) {
	
	while(b!=0)
	{
		long carry=a&b;
		a=a^b;
		b=carry<<1;
	}
	return a;
  }
}
