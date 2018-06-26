package linkedLists;
public class RemoveDuplicatesFromSortedList {
	public static void main(String[] args) {
		ListNode<Integer> dummyHead=ListHelper.createList(new int[]{10,10,121,12,12});
		ListHelper.print(removeDuplicates(dummyHead));
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
