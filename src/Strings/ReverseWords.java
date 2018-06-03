package Strings;

public class ReverseWords {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       char[] input={'a','v','g',' ','v','s',' ','c','l','e','v','e','r'};
       reverseWords(input);
	}
	public static void reverseWords(char[] input) {
	    //reverse the whole input first
	    reverse(input,0,input.length);
       
	    int start=0,end;
	    while((end=find(input,' ',start))!=-1){
	    	//reverse each individual word
	    	reverse(input,start,end);
	    	start=end+1;
	    }
	    //reverse the last word 
	    reverse(input,start,input.length);
	    for(int i=0;i<input.length;i++){
	    	System.out.print(input[i]+" ");
	    }
	 }
	private static int find(char[] arr, char find, int start) {
		for(int i=start;i<arr.length;++i){
			if(arr[i]==find)
				return i;
		}
		return -1;
	}
	private static void reverse(char[] arr, int start, int end) {
		if(start>=end)
			return;
		int last=end-1;
		// Go up to the middle and swap the characters on either ends
		for(int i=start;i<=start+(last-start)/2;++i){
			char temp=arr[i];
			arr[i]=arr[last-i+start];
			arr[last-i+start]=temp;
		}
	}
}
