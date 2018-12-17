package queues;

import java.util.Arrays;
import java.util.Collections;
import java.util.NoSuchElementException;

public class DynamicCircularQueue {
   Integer head=0,tail=0,numQueueElems=0;
   public static final int SCALE_FACTOR =2;
   Integer[] queue;
   
   public DynamicCircularQueue(int capacity){
	  queue=new Integer[capacity];
   }
   
   public void Enqueue(int value){
	   if(numQueueElems==queue.length){
		   Collections.rotate(Arrays.asList(queue), -head);
		   head=0;
		   tail=numQueueElems;
		   queue=Arrays.copyOf(queue, numQueueElems*SCALE_FACTOR);	  
		 }
	   queue[tail]=value;
	   numQueueElems++;
	   tail=(tail+1)%queue.length;
   }
   
   public Integer Dequeue(){
	   if(numQueueElems!=0){
		   numQueueElems--;
		   Integer res=queue[head];
		   head=(head+1)%queue.length;
		   return res;
	   }
	   throw new NoSuchElementException("Queue is Empty");
   }
   
   public int size(){ return numQueueElems;}
}
