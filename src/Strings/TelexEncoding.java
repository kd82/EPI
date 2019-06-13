<<<<<<< HEAD
package strings;
=======
package Strings;
>>>>>>> c02d66d7ac0d64834bc80a5fd1e480ae0b2a4e69

public class TelexEncoding {

	public static void main(String[] args) {
		char[] input={'.','b','c', 'd','e', '.',' ',' ',' ',' ', ' ', ' '};
		telexEncoding(6, input);
	}

	private static void telexEncoding(int size, char[] input) {
	  //TO DO more efficiently by using a mapping
	  final String[] spelledChars={"TOD","AMMOC","KRAM NOITSEUQ","KRAM NOITAMALCXE"};
      int count=0;
	  for(int i=0;i<size;++i){
		  if(input[i]=='.'){
			  count+=spelledChars[0].length();
		  }
      }
	  int finalSize=size+count-1;
	  int writeIdx=finalSize,j=size;
	  while(j>=0){
		  if(input[j]=='.'){
			  input[--writeIdx]='T';
			  input[--writeIdx]='O';
			  input[--writeIdx]='D';
		  }
		  else{
			  input[--writeIdx]=input[j];
		  }
		  --j;
	  }
	  for(int i=0;i<finalSize;i++){
		  System.out.print(input[i]+" ");
	  }
	}

}
