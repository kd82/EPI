package linkedLists;

public class AddTwoNumbers {

	public static void main(String[] args) {
       ListNode<Integer> numHead1=ListHelper.createList(new int[]{3,1,4});
       ListNode<Integer> numHead2=ListHelper.createList(new int[]{7,0,2});;
       ListHelper.print(numHead1);
       ListHelper.print(numHead2);
       ListHelper.print(addTwoNumbers(numHead1,numHead2));
	}

	private static ListNode<Integer> addTwoNumbers(ListNode<Integer> L1, ListNode<Integer> L2)
	{
	   ListNode<Integer> dummyHead=new ListNode<Integer>(0,null);
	   ListNode<Integer> iter=dummyHead;
	   int carry=0;
	   while(L1!=null || L2!=null){
		   int sum=carry;
		   if(L1!=null){
			   sum+=L1.data;
			   L1=L1.next;
		   }
		   if(L2!=null){
			   sum+=L2.data;
			   L2=L2.next;
		   }
		   iter.next=new ListNode<Integer>(sum%10, null);
		   carry=sum/10;
		   iter=iter.next;
	   }
	   if(carry>0){
		   iter.next=new ListNode<Integer>(carry,null);
	   }
	   return dummyHead.next;
	}

}
