package linkedLists;

public class OverlappingLists {

	public static void main(String[] args) {
	  ListNode<Integer> head1=new ListNode<Integer>(1,null);
	  ListNode<Integer> head2=new ListNode<Integer>(9,null);
      head1.next=new ListNode<Integer>(2,head2);
      head2.next=new ListNode<Integer>(8,null);
      System.out.println(overlappingNoCycleLists(head1, head2).data);
	}
	public static ListNode<Integer> overlappingNoCycleLists(ListNode<Integer> L1,ListNode<Integer> L2){
		int len1=length(L1);
		int len2=length(L2);
		if(len1>len2){
		L1=traverseList(L1,len1-len2);
		}
		else{
	    L2=traverseList(L2,len2-len1);
		}
		while(L1!=null && L2!=null && L1!=L2){
			L1=L1.next;
			L2=L2.next;
		}
		return L1;
	}
	private static ListNode<Integer> traverseList(ListNode<Integer> start, int d) {
		while(d-->0){
			start=start.next;
		}
		return start;
	}
	public static int length(ListNode<Integer> head){
		int count=0;
		while(head!=null){
			++count;
			head=head.next;
		}
		return count;
	}
}
