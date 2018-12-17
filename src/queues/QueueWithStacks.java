package queues;

import java.util.Deque;
import java.util.LinkedList;

public class QueueWithStacks {
	
	Deque<Integer> enq=new LinkedList<>();
	Deque<Integer> deq=new LinkedList<>();
	
	public void Enqueue(int val){
		enq.addFirst(val);
	}
	
	public int Dequeue(){
		if(deq.isEmpty()){
			//transfer elements from enq to deq
			while(!enq.isEmpty())
				deq.addFirst(enq.removeFirst());
		}
		if(!deq.isEmpty())
			return deq.removeFirst();
		
		throw new IllegalArgumentException("Cannot enqueue on empty queue");
		}
}
