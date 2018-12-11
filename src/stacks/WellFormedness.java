package stacks;

import java.util.Deque;
import java.util.LinkedList;

public class WellFormedness {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
       System.out.println(isWellFormed("[()[]{(})()"));
	}
	
	public static boolean isWellFormed(String s){
		Deque<Character> stack=new LinkedList<>();
	    for(int i=0;i<s.length();++i){
	    	if(!stack.isEmpty()){
	    		char ch=s.charAt(i);
	    		char top=stack.peekFirst();
	    		if(top=='[' && ch==']')
	    		{
	    			stack.removeFirst();
	    		}
	    		if(top=='{' && ch=='}')
	    		{
	    			stack.removeFirst();
	    		}
	    		if(top=='(' && ch==')')
	    		{
	    			stack.removeFirst();
	    		}
	    	}
	    	else
	    		stack.addFirst(s.charAt(i));
	    }
		return stack.isEmpty();
	}
}
