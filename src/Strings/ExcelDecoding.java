<<<<<<< HEAD
package strings;
=======
package Strings;
>>>>>>> c02d66d7ac0d64834bc80a5fd1e480ae0b2a4e69

public class ExcelDecoding {

	public static void main(String[] args) {
	  System.out.println(ssDecodeColID("AA"));
	}
	 public static int ssDecodeColID(final String str) {
		    int ret=0;
		    for(int i=0;i<str.length();++i){
		    	char c=str.charAt(i);
		    	ret=ret*26+c-'A'+1;
		    }
		    return ret;
	 }
}
