package stacks;
import java.util.Deque;
import java.util.LinkedList;

public class StackWithMaxAPI {
	private static class ElementWithCachedMax{
		   public Integer Max;
		   public Integer Element;
		   public ElementWithCachedMax(int element,int max){
			   this.Max=max;
			   this.Element=element;
		   }
    }
	public class StackApproach1{
		private Deque<ElementWithCachedMax> maxStack=new LinkedList<>();
		public void push(int elem){
			maxStack.addFirst(new ElementWithCachedMax(elem,Math.max(elem, isEmpty()?elem:max())));
		}
		public int pop(){
			if(isEmpty()){
				throw new IllegalStateException("Stack is empty");
			}
			else 
				return maxStack.removeFirst().Element;
		}
		public int max(){
			if(isEmpty()){
				throw new IllegalStateException("Stack is empty");
			}
			else 
				return maxStack.peek().Max;
		}
		public boolean isEmpty(){
			return maxStack.isEmpty();
		}
	}
	private static class MaxElementWithCount{
	   public Integer Max;
	   public Integer Count;
	   public MaxElementWithCount(int max,int count){
		   this.Max=max;
		   this.Count=count;
	   }
	}
	public class StackApproach2{
		private Deque<MaxElementWithCount> maxStack=new LinkedList<>();
		private Deque<Integer> stack=new LinkedList<>();
		public void push(int elem){
			if(maxStack.isEmpty() || maxStack.peekFirst().Max<elem)
				maxStack.addFirst(new MaxElementWithCount(elem,1));
			else if(maxStack.peekFirst().Max<elem){
				maxStack.addFirst(new MaxElementWithCount(elem,maxStack.peekFirst().Count+1));
			}
			stack.addFirst(elem);
		}
		public int pop(){
			Integer poppedElement;
			if(isEmpty()){
				throw new IllegalStateException("Stack is empty");
			}
			else {
				poppedElement=stack.removeFirst();
				if(!maxStack.isEmpty() && poppedElement.equals(maxStack.peekFirst().Max)){
					int count=maxStack.peekFirst().Count;
					if(count==1)
						maxStack.removeFirst();
					else 
						maxStack.peekFirst().Count=maxStack.peekFirst().Count-1;
				}
			}
			return poppedElement;
		}
		public int max(){
			if(isEmpty()){
				throw new IllegalStateException("Stack is empty");
			}
			else 
				return maxStack.peekFirst().Max;
		}
		public boolean isEmpty(){
			return maxStack.isEmpty();
		}
	}
	
}

