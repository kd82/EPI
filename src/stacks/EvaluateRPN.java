package stacks;
import java.util.Deque;
import java.util.LinkedList;

public class EvaluateRPN {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       System.out.println(EvaluateExpression("3,4,+,12,*,1,+"));
	}
	
	public static int EvaluateExpression(String rpnExpression){
		Deque<Integer> stack=new LinkedList<>();
		String delimiter=",";
		String[] tokens=rpnExpression.split(delimiter);
		for(String token:tokens){
			if(token.length()==1 && "/*+-".contains(token)){
				int x=stack.removeFirst();
				int y=stack.removeFirst();
				switch(token.charAt(0)){
				case '+':
					stack.addFirst(x+y);
					break;
				case '-':
					stack.addFirst(x-y);
					break;
				case '*':
					stack.addFirst(x*y);
					break;
				case '/':
					stack.addFirst(x/y);
					break;
				default:
					throw new IllegalArgumentException("Given Expression is invalid");
				}
			}
			else
			{
				stack.addFirst(Integer.parseInt(token));
			}
		}
		return stack.removeFirst();
	}

}
