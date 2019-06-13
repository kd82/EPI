<<<<<<< HEAD
package strings;
=======
package Strings;
>>>>>>> c02d66d7ac0d64834bc80a5fd1e480ae0b2a4e69

public class Palindrome {

	public static void main(String[] args) {
	  String[] input={"abA","casper","magam","toledo","kingsgnik","loL"};
       for(String in:input)
       {
    	   System.out.println("Iterative ");
    	   System.out.print(isPalindromic(in)+" ");
    	   System.out.println("Recursive ");
    	   System.out.print(isPalindromicRecursive(in)+" ");
    	   System.out.println("Case Sensitive ");
    	   System.out.print(isPalindrome(in)+" ");
       }
	}

	private static boolean isPalindromic(String str) {
		for(int i=0,j=str.length()-1;i<j;++i,--j){
			if(str.charAt(i)!=str.charAt(j))
				return false;
		}
		return true;
	}
   // Recursive Approach
   public static boolean isPalindromicRecursive(String str)
   {
	   if(str.length()<1)
		   return true;
	   if(str.charAt(0)!=str.charAt(str.length()-1))
		   return false;
	   return true;
   }
   //Case insensitive
   public static boolean isPalindrome(String s)
   {
	   int i=0,j=s.length()-1;
	   while(i<j){
		   if(!Character.isLetterOrDigit(s.charAt(i)) && i<j)
		   {
			   i++;
		   }
		   if(!Character.isLetterOrDigit(s.charAt(j)) && i<j)
		   {
			   j--;
		   }
		   if(Character.toLowerCase(s.charAt(i))!=Character.toLowerCase(s.charAt(j)))
			   return false;
		   ++i;
		   --j;
	   }
	   return true;
   }

}
