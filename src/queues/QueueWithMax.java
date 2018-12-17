package queues;

import java.util.Deque;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class QueueWithMax<T extends Comparable<T>>{
    private Deque<T> queue=new LinkedList<>();
    private Deque<T> deque=new LinkedList<>();
    
	public void Enqueue(T value){
		queue.add(value);
		while(!deque.isEmpty()){
			if(deque.getLast().compareTo(value)>=0){
				break;
			}
			deque.removeLast();
		}
		deque.addLast(value);
	}
	
	public T Dequeue(){
		
     if(!deque.isEmpty()){
    	 T popped=queue.remove();
    	 if(popped.equals(deque.getFirst())){
    		 queue.removeFirst();
    	 }
    	 return popped;
     }
     throw new NoSuchElementException("Called dequeue on empty queue");
	}
	
	public T Max(){
		 if(!deque.isEmpty())
			 return deque.peekFirst();
		 throw new NoSuchElementException("Queue is Empty");
	}

}
