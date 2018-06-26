package linkedLists;

import java.util.Arrays;
import java.util.List;

public class EvenOddMerge {
	public static void main(String[] args) {
		ListNode<Integer> dummyHead=ListHelper.createList(8);
		ListHelper.print(dummyHead);
		System.out.println("Even Odd Merged ");
		ListHelper.print(evenOddMerge(dummyHead));
	}
	private static ListNode<Integer> evenOddMerge(ListNode<Integer> L) {
		if(L==null){
			return L;
		}
		ListNode<Integer> evenDummyHead=new ListNode<Integer>(0, null);
		ListNode<Integer> oddDummyHead=new ListNode<Integer>(0, null);
		//Allocate a list to maintain the tails
		List<ListNode<Integer>> tails=Arrays.asList(evenDummyHead,oddDummyHead);
		int turn =0;
		for(ListNode<Integer> iter=L;iter!=null;iter=iter.next){
			tails.get(turn).next=iter;
			tails.set(turn,tails.get(turn).next);
			turn^=1;
		}
        tails.get(1).next=null;
        tails.get(0).next=oddDummyHead.next;
		return evenDummyHead.next;
	}
}
