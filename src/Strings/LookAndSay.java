<<<<<<< HEAD
package strings;
=======
package Strings;
>>>>>>> c02d66d7ac0d64834bc80a5fd1e480ae0b2a4e69

public class LookAndSay {
	public static void main(String[] args) {
		int n=4;
		System.out.println(lookAndSay(n));
	}
	public static String lookAndSay(int n) {
	   String s="1";
	   for(int i=0;i<n;++i){
		   s=nextNumber(s);
	   }
	    return s;
	  }
	private static String nextNumber(String s) {
		StringBuilder res=new StringBuilder();
		int i=0,count=1;
		while(i<s.length()){
			while(i+1<s.length() && s.charAt(i)==s.charAt(i+1)){
				++i;
				++count;
			}
			res.append(count);
			res.append(s.charAt(i));
			++i;
		}
		return res.toString();
	}
	
}
