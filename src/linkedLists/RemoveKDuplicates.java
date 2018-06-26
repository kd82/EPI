package linkedLists;

public class RemoveKDuplicates {
	public static void main(String[] args) {
		ListNode<Integer> dummyHead=ListHelper.createList(new int[]{10,12,12,12});
		ListHelper.print(removeKDuplicates(dummyHead,2));
    }
	private static ListNode<Integer> removeKDuplicates(ListNode<Integer> L, int m) {
		ListNode<Integer> slow=L,fast=L;
		while(slow!=null){
			fast=slow.next;
			int count=m;
			while(fast!=null && slow.data==fast.data){
				fast=fast.next;
				count--;
			}
			if(count<=0){
				slow=fast;
			}
			else{
				slow.next=fast;
				slow=fast;
			}
		}
		
	    return L;
	}
}
