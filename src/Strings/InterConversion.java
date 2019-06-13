<<<<<<< HEAD
package strings;
=======
package Strings;
>>>>>>> c02d66d7ac0d64834bc80a5fd1e480ae0b2a4e69

public class InterConversion {

	public static void main(String[] args) {
	 System.out.println(intToString(-101));
	 System.out.println(stringToInteger("-101"));
	}

	private static int stringToInteger(String str) {
		boolean isNegative=str.charAt(0)=='-';
		int result=0;
		int i=isNegative?1:0;
		while(i<str.length())
		{
			int digit=str.charAt(i)-'0';
			result=result*10+digit;
			i++;
		}
		return isNegative?-result:result;
	}

	private static String intToString(int n) {
	  boolean isNegative=false;
	  if(n<0)
	  {
		  n=-n;
		  isNegative=true;
	  }
	  StringBuilder sb=new StringBuilder();
	  do{
		sb.append((char)('0'+(n%10)));
		n/=10;
	  }while(n!=0);
	 
	  if(isNegative)
		 {
		  sb.append("-");
		 }
	  sb.reverse();
	  return sb.toString();
	}
}
