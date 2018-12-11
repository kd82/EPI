package stacks;

import java.util.Deque;
import java.util.LinkedList;
public class NormaliseParanthesis {
	public static void main(String[] args) {
		System.out.println(shortestPath("usr/lib/../bin/gcc"));
	}

	private static String shortestPath(String path) {
	   if(path.equals(""))
		   throw new IllegalArgumentException("Path cannot be empty");
	   
	   Deque<String> pathNames=new LinkedList<>();
	   
	   if(path.startsWith("/")) //Special case when the path name starts from root
		   pathNames.addFirst("/");
		   
	   for(String token :path.split("/")){
		   if(token.equals("..")){
			   if(pathNames.isEmpty() || pathNames.peekFirst().equals(".."))
				   pathNames.addFirst(token);
			   else {
				   if(pathNames.peekFirst().equals("/"))
					   throw new IllegalArgumentException("Trying to move up the root "+path);
				   }
			   pathNames.removeFirst();
		   }
		   else if(!token.equals(".") || !token.isEmpty()){
			   pathNames.addFirst(token);
		   }
	   }
	   StringBuilder sb=new StringBuilder();
	   if(!pathNames.isEmpty()){
		   java.util.Iterator<String> it=pathNames.descendingIterator();
		   String prev=it.next();
		   sb.append(prev);
		   while(it.hasNext()){
			   if(!prev.equals("/"))
				   sb.append("/");
		 
		   prev=it.next();
		   sb.append(prev);
		   }
	   }
	  
	  
	   return sb.toString();
	}
}
