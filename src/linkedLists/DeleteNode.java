package linkedLists;

public class DeleteNode {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode<Integer> dummyHead=ListHelper.createList(10);
	    delete(dummyHead.next);
		ListHelper.print(dummyHead);
	}
	private static void delete(ListNode<Integer> nodeToDelete){
    	nodeToDelete.data=nodeToDelete.next.data;
    	nodeToDelete.next=nodeToDelete.next.next;
    }
}
