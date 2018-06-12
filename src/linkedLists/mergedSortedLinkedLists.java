package linkedLists;


public class MergedSortedLinkedLists {
    public static void main(String[] args) {
    
    }
	public static ListNode<Integer> mergeSortedLinkedList(ListNode<Integer> L1,ListNode<Integer> L2){
		ListNode<Integer> dummyHead=new ListNode<Integer>(0,null);
		ListNode<Integer> current=dummyHead,p1=L1,p2=L2;
		while(p1.next!=null || p2.next!=null){
			if(p1.data<p2.data){
				current.next=p1;
				p1=p1.next;	
			}
			else
			{
				current.next=p2;
				p2=p2.next;
			}
			current=current.next;
		}
		current.next=p1.next!=null?p1:p2;
		return dummyHead.next;
	}
	public static ListNode<Integer> mergeSortedDoubleLinkedList(ListNode<Integer> L1,ListNode<Integer> L2){
		ListNode<Integer> dummyHead=new ListNode<Integer>(0,null,null);
		ListNode<Integer> current=dummyHead,p1=L1,p2=L2;
		while(p1!=null || p2!=null){
			if(p1.data<p2.data){
				current.next=p1;
				current.prev=p1.prev;
				p1=p1.next;	
				p1.prev=current;
			}
			else
			{
				current.next=p2;
				current.prev=p2.prev;
				p2=p2.next;
				p2.prev=current;
			}
			current.prev=current;
			current=current.next;
		}
		current.next=p1!=null?p1:p2;
		return dummyHead.next;
	}
}

