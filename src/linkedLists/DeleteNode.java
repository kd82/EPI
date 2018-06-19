package linkedLists;

public class DeleteNode {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode<Integer> dummyHead=new ListNode<Integer>(10,null);
		dummyHead.next=new ListNode<Integer>(55,null);
		dummyHead.next.next=new ListNode<Integer>(11,null);
		dummyHead.next.next.next=new ListNode<Integer>(9,null);
		dummyHead.next.next.next.next=new ListNode<Integer>(9,null);
	    delete(dummyHead.next);
		print(dummyHead);
	}
    private static void print(ListNode<Integer> dummyHead) {
		// TODO Auto-generated method stub
		while(dummyHead!=null){
			System.out.print(dummyHead.data+"->");
			dummyHead=dummyHead.next;
		}
		System.out.print("NULL");
	}
	private static void delete(ListNode<Integer> nodeToDelete){
    	nodeToDelete.data=nodeToDelete.next.data;
    	nodeToDelete.next=nodeToDelete.next.next;
    }
}
