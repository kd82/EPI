package linkedLists;

public class DeleteKthFromList {

	public static void main(String[] args) {
		ListNode<Integer> dummyHead=ListHelper.createList(5);
	    ListHelper.print(removeKthLast(dummyHead,3));
	}
	public static ListNode<Integer> removeKthLast(ListNode<Integer> L, int k) {
	   ListNode<Integer> dummyHead=new ListNode<Integer>(0,L);
	   ListNode<Integer> first=dummyHead.next,second=dummyHead;
	   while(--k>0){
		   first=first.next;
	   }
	   while(first.next!=null){
		   first=first.next;
		   second=second.next;
	   }
	   second.next=second.next.next;
	   return dummyHead.next;
	}

}
