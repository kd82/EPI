package linkedLists;

public class CyclicRightShift {

	public static void main(String[] args) {
		ListNode<Integer> dummyHead=ListHelper.createList(10);
		ListHelper.print(dummyHead);
		System.out.println();
		ListHelper.print(cyclicRightShift(dummyHead,3));

	}
	public static ListNode<Integer> cyclicRightShift(ListNode<Integer> L,int k){
		if(L==null){
			return L;
		}
		ListNode<Integer> tail=L;
		int n=1;
		while(tail.next!=null){
			n++;
			tail=tail.next;
		}
		if(k%n==0){
			return L;
		}
		tail.next=L;
		int stepsToNewHead=n-k;
		ListNode<Integer> newTail=tail;
		while(stepsToNewHead-->0){
			newTail=newTail.next;
		}
		ListNode<Integer> newHead=newTail.next;
		newTail.next=null;
		return newHead;
	}
}
