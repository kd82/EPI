package linkedLists;

public class CycleDetection {

	public static void main(String[] args) {

		ListNode<Integer> dummyHead=ListHelper.createList(5);
		dummyHead.next=new ListNode<Integer>(55,null);
		dummyHead.next.next=new ListNode<Integer>(51,dummyHead);
		System.out.println(hasCycle(dummyHead));
		ListNode<Integer> start=startOfCycle(dummyHead);
		System.out.println(start==null?"No Cycle":start.data);
		start=startOfCycle1(dummyHead);
		System.out.println(start==null?"No Cycle":start.data);
	}

	public static boolean hasCycle(ListNode<Integer> head) {
		ListNode<Integer> slow=head;
		ListNode<Integer> fast=head;
		while(fast!=null && fast.next!=null){
			slow=slow.next;
			fast=fast.next.next;
			if(slow==fast){
				return true;
			}
		}
		return false;
	}
	public static ListNode<Integer> startOfCycle(ListNode<Integer> head) {
		ListNode<Integer> slow=head;
		ListNode<Integer> fast=head;
		while(fast!=null && fast.next!=null){
			slow=slow.next;
			fast=fast.next.next;
			//cycle exists
			if(slow==fast){
			  slow=head;
			  while(slow!=fast){
				  slow=slow.next;
				  fast=fast.next;
			  }
			  return slow;
			}
		}
		return null;
	}
	
	public static ListNode<Integer> startOfCycle1(ListNode<Integer> head) {
		ListNode<Integer> slow=head;
		ListNode<Integer> fast=head;
		while(fast!=null && fast.next!=null){
			slow=slow.next;
			fast=fast.next.next;
			//cycle exists
			if(slow==fast){
			 int cycleLen=0;
			 do{
				 ++cycleLen;
				 fast=fast.next;
			 }while(slow!=fast);
			 ListNode<Integer> cycleAdvancedIter=head;
			 while(cycleLen-->0){
				 cycleAdvancedIter=cycleAdvancedIter.next;
			 }
             ListNode<Integer> iter=head;
             while(iter!=cycleAdvancedIter){
            	 iter=iter.next;
            	 cycleAdvancedIter=cycleAdvancedIter.next;
             }
			 return iter;
			}
		}
		return null;
	}
}
