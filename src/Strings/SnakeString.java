<<<<<<< HEAD
package strings;
=======
package Strings;
>>>>>>> c02d66d7ac0d64834bc80a5fd1e480ae0b2a4e69

public class SnakeString {

	public static void main(String[] args) {
		System.out.println(snakeString("Hello_World!"));
	}
	public static String snakeString(String s) {
	    StringBuilder sb=new StringBuilder();
	    //first row
	    for(int i=1;i<s.length();i+=4){
	    	sb.append(s.charAt(i));
	    }
	    //second row
	    for(int j=0;j<s.length();j+=2){
	    	sb.append(s.charAt(j));
	    }
	    //Third row
	    for(int k=3;k<s.length();k+=4){
	    	sb.append(s.charAt(k));
	    }
	    
	    return sb.toString();
	  }
}
