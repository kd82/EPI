package queues;

public class CircularQueue {
    Integer Head;
    Integer Tail;
    int[] Queue;
    Integer Capacity;
    /** Initialize your data structure here. Set the size of the queue to be k. */
    public CircularQueue(int k) {
        Queue=new int[k];
        Head=-1;
        Tail=-1;
        Capacity=k;
    }
    
    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
         if(isFull())
             return false;
        
         if (isEmpty()) {
            Head = 0;
        }
        
         Tail = (Tail + 1) % Capacity;
       
        Queue[Tail]=value;
        
        return true;
    }
    
    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if(isEmpty())
             return false;
        
        if (Head == Tail) {
            Head = -1;
            Tail = -1;
            return true;
        }
        Head = (Head + 1) % Capacity;
        return true;
    }
    
    /** Get the front item from the queue. */
    public int Front() {
        if(isEmpty())
            return -1;
        else
            return Queue[Head];
    }
    
    /** Get the last item from the queue. */
    public int Rear() {
        if(isEmpty())
            return -1;
        else
            return Queue[Tail];
    }
    
    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return Head==-1;
    }
    
    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
       return ((Tail + 1) % Capacity) == Head;
    }
}
