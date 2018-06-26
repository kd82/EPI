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
		ListNode<Integer> node1=CycleDetection.startOfCycle1(L1);
		ListNode<Integer> node2=CycleDetection.startOfCycle1(L2);
		//If one of them has no cycle then no overlap
		if((node1==null && node2!=null) || (node1!=null && node2==null)){
			return null;
		}
		// No Cycle exists just go for the normal case
		if(node1==null && node2==null){
			return OverlappingLists.overlappingNoCycleLists(L1,L2);
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
			L1=OverlappingLists.traverseList(L1,stem1Length-stem2Length);
		}
		else{
			L2=OverlappingLists.traverseList(L2,stem2Length-stem1Length);
		}
		
		while(L1!=L2 && L1!=node1 && L2!=node2){
			L1=L1.next;
			L2=L2.next;
		}
		
		return L1==L2?L1:node1;
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
