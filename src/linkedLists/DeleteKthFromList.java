package linkedLists;

public class DeleteKthFromList {

	public static void main(String[] args) {
		ListNode<Integer> dummyHead=new ListNode<Integer>(10,null);
		dummyHead.next=new ListNode<Integer>(55,null);
		dummyHead.next.next=new ListNode<Integer>(11,null);
		dummyHead.next.next.next=new ListNode<Integer>(9,null);
		dummyHead.next.next.next.next=new ListNode<Integer>(9,null);
	    print(removeKthLast(dummyHead,3));
	}
	public static void print(ListNode<Integer> head){
		while(head!=null){
			System.out.print(head.data+"->");
			head=head.next;
		}
		System.out.print("null");
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
