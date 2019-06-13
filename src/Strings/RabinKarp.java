<<<<<<< HEAD
package strings;
=======
package Strings;
>>>>>>> c02d66d7ac0d64834bc80a5fd1e480ae0b2a4e69

public class RabinKarp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      System.out.println(rabinKarp("GACGCCA","GAC"));
	}
	private static int rabinKarp(String t,String p){
	   if(p.length()>t.length())
		return -1;
	  final int BASE=256;
	  int powerS=1;
	  int tHash=0,pHash=0;
	  for(int i=0;i<p.length();++i){
		  powerS=i>0?powerS*BASE:1;
		  tHash=tHash*BASE+t.charAt(i);
		  pHash=pHash*BASE+p.charAt(i);
	  }
	  //Collision Check to see if the strings are really equal or not
	  for(int i=p.length();i<t.length();i++){
		  if(tHash==pHash && t.substring(i-p.length(),i).equals(p)){
			return i-p.length();  
		  }
		  tHash-=t.charAt(i-p.length())*powerS;
		  tHash=tHash*BASE+t.charAt(i);
	  }
	  //Check to see if the strings are equal 
	  if(tHash==pHash && t.substring(t.length()-p.length()).equals(p)){
			return t.length()-p.length();  
		  }
	   return -1;
	}
    
}
