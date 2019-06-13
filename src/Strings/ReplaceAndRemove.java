<<<<<<< HEAD
package strings;
=======
package Strings;
>>>>>>> c02d66d7ac0d64834bc80a5fd1e480ae0b2a4e69

public class ReplaceAndRemove {

	public static void main(String[] args) {
		char[] input={'a','c','d','b','b','c','a'};
		replaceAndRemove(7, input);
	}
	public static int replaceAndRemove(int size, char[] s) {
	    // TODO - you fill in here.
		//Remove b first and at the same time get the count of a 
		int aCount=0,writeIdx=0;
		for(int i=0;i<size;++i){
			if(s[i]=='a')
				++aCount;
			if(s[i]!='b'){
				s[writeIdx++]=s[i];
			}
		}
		
		int curIdx=writeIdx-1;
		writeIdx=writeIdx+aCount-1;
		int finalLen=writeIdx+1;
		while(curIdx>=0){
			if(s[curIdx]=='a'){
				s[writeIdx--]='d';
				s[writeIdx--]='d';
			}
			else{
				s[writeIdx--]=s[curIdx];
			}
			--curIdx;
		}
		for(int i=0;i<finalLen;++i){
				System.out.print(s[i]+" ");
		}
	    return finalLen;
	  }

}
