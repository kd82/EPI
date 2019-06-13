<<<<<<< HEAD
package strings;
=======
package Strings;
>>>>>>> c02d66d7ac0d64834bc80a5fd1e480ae0b2a4e69

public class RLC {

	public static void main(String[] args) {
	  System.out.println("Decoded String is :"+decoding("3e4f2e"));
	  System.out.println("Encoded String is :"+encoding("eeeffffee"));
	}
	public static String decoding(String s) {
		int count=0;
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<s.length();++i){
			char c=s.charAt(i);
			if(Character.isDigit(c)){
			 count=c-'0';
			}
			else{
				while(count>0){
				sb.append(c);
				count--;
				}
			}
		}
	    return sb.toString();
	}
	public static String encoding(String s) {
		int count=1;
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<s.length()-1;++i){
			char c=s.charAt(i);
			if(c!=s.charAt(i+1)){
			 sb.append(count);
			 sb.append(s.charAt(i));
			 count=1;
			}
			else{
				count++;
			}
		}
		sb.append(count);
		sb.append(s.charAt(s.length()-1));
	    return sb.toString();
	}

}
