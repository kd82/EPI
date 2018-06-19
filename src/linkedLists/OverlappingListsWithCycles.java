package linkedLists;

public class OverlappingListsWithCycles {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  ListNode<Integer> head1=new ListNode<Integer>(1,null);
		  ListNode<Integer> head2=new ListNode<Integer>(9,null);
	      head1.next=new ListNode<Integer>(2,head2);
	      head2.next=new ListNode<Integer>(8,head2);
	      System.out.println(overlappingLists(head1, head2).data);
	}
	// This problem is an example of Case by Case Analysis for Technical Interviews and
	// it goes as follows 1.Solve the base cases first and add the special cases later 
	public static ListNode<Integer> overlappingLists(ListNode<Integer> L1,ListNode<Integer> L2){
		ListNode<Integer> node1=hasCycle(L1);
		ListNode<Integer> node2=hasCycle(L2);
		//If one of them has no cycle then no overlap
		if((node1==null && node2!=null) || (node1!=null && node2==null)){
			return null;
		}
		// No Cycle exists just go for the normal case
		if(node1==null && node2==null){
			return overlappingNoCycleLists(L1,L2);
		}
		// Now the case where both the lists have cycles
		ListNode<Integer> temp=node2;
		do{
			temp=temp.next;
		}while(temp!=node1 && temp!=node2);
		
		//First case where they don't end up at the same node
		if(temp!=node1){
			return null;
		}
		// L1 and L2 has ended in the same tail node 
		int stem1Length=getDistance(L1, node1),stem2Length=getDistance(L2, node2);
		if(stem1Length>stem2Length){
			L1=traverseList(L1,stem1Length-stem2Length);
		}
		else{
			L2=traverseList(L2,stem2Length-stem1Length);
		}
		
		while(L1!=L2 && L1!=node1 && L2!=node2){
			L1=L1.next;
			L2=L2.next;
		}
		
		return L1==L2?L1:node1;
	}
	private static ListNode<Integer> hasCycle(ListNode<Integer> head) {
		ListNode<Integer> slow=head;
		ListNode<Integer> fast=head;
		while(fast!=null && fast.next!=null){
			slow=slow.next;
			fast=fast.next.next;
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
	public static int getDistance(ListNode<Integer> a,ListNode<Integer> b){
		int dis=0;
		while(a!=b){
			a=a.next;
			b=b.next;
			++dis;
		}
		return dis;
	}
}
