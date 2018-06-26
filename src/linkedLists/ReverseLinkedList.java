package linkedLists;

public class ReverseLinkedList {

	public static void main(String[] args) {
		ListNode<Integer> dummyHead=ListHelper.createList(14);
		ListHelper.print(dummyHead);
		ListHelper.print(reverseLinkedList(dummyHead));
		ListHelper.print(reverseList(dummyHead,1,10));
	}
	
	public static ListNode<Integer> reverseList(ListNode<Integer> head,int start,int finish){
		if(start==finish){
			return head;
		}
		// Time complexity is O(k) which is required to traverse the list to find the start
		ListNode<Integer> dummyHead=new ListNode<Integer>(0,head);
		int k=1;
		ListNode<Integer> subListHead=dummyHead;
		while(k++<start){
			subListHead=subListHead.next;
		}
        ListNode<Integer> subListIter=subListHead.next;
        while(start++<finish){
        	ListNode<Integer> temp=subListIter.next;
        	subListIter.next=temp.next;
        	temp.next=subListHead.next;
        	subListHead.next=temp;
        }
		return dummyHead.next;
	}
	public static ListNode<Integer> reverseLinkedList(ListNode<Integer> head){
	  ListNode<Integer> prev=null;
	  ListNode<Integer> curr=head;
	  ListNode<Integer> nextNode=null;
	  while(curr!=null){
		 nextNode=curr.next;
		 curr.next=prev;
		 prev=curr;
		 curr=nextNode;
	  }
	  return prev;
	}
}
