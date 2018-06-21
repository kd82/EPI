package linkedLists;
public class RemoveDuplicatesFromSortedList {
	public static void main(String[] args) {
		ListNode<Integer> dummyHead=new ListNode<Integer>(10,null);
		dummyHead.next=new ListNode<Integer>(10,null);
		dummyHead.next.next=new ListNode<Integer>(121,null);
		dummyHead.next.next.next=new ListNode<Integer>(12,null);
		dummyHead.next.next.next.next=new ListNode<Integer>(12,null);
		print(removeDuplicates(dummyHead));
    }
	
	public static void print(ListNode<Integer> head){
		while(head!=null){
			System.out.print(head.data+"->");
			head=head.next;
		}
		System.out.print("null");
	}

	public static ListNode<Integer> removeDuplicates(ListNode<Integer> L) {
		ListNode<Integer> dummyHead=new ListNode<Integer>(0,L);
		while(L.next!=null){
		  if(L.data==L.next.data){
			  L.next=L.next.next;
		  }
		  else
		   L=L.next;
		}
	    return dummyHead.next;
	}
}
