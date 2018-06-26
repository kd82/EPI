package linkedLists;

public class IsPalindromic {

	public static void main(String[] args) {
		ListNode<Integer> dummyHead=ListHelper.createList(new int[]{10,55,51,55,10});
		ListHelper.print(dummyHead);
		System.out.println(isPalindromicList(dummyHead));
	}

	private static boolean isPalindromicList(ListNode<Integer> L) {
		if(L==null){
			return false;
		}
		ListNode<Integer> slow=L,fast=L;
		while(fast!=null && fast.next!=null){
			slow=slow.next;
			fast=fast.next.next;
		}
		ListNode<Integer> secondHalf=ReverseLinkedList.reverseLinkedList(slow);
		ListNode<Integer> firstHalf=L;
		while(secondHalf!=null && firstHalf!=null){
			 if(secondHalf.data!=firstHalf.data){
				 return false;
			 }
			 secondHalf=secondHalf.next;
			 firstHalf=firstHalf.next;
		}
		return true;
	}

}
