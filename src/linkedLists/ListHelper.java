package linkedLists;

import java.util.Random;

public class ListHelper {
	//Prints the elements of the linkedList from head
	public static <T> void print(ListNode<T> head){
		System.out.println();
		while(head!=null){
			System.out.print(head.data+"->");
			head=head.next;
		}
		System.out.print("null");
    }
	//Create a LinkedList of specified size with Random elements from 0 to 100
	public static ListNode<Integer> createList(int k){
		Random r=new Random();
		ListNode<Integer> head=new ListNode<Integer>(0, null);
		while(k-->0){
			head.next=new ListNode<Integer>(r.nextInt(100),head.next);
		}
		return head.next;
	}
	//Finds the length of the LinkedList
	public static int length(ListNode<Integer> head){
		int count=0;
		while(head!=null){
			++count;
			head=head.next;
		}
		return count;
	}
	//Creates the Linked list from the elements in the array as they are inserted
	public static ListNode<Integer> createList(int[] list){
		ListNode<Integer> head=new ListNode<Integer>(0, null);
		ListNode<Integer> dummyHead=new ListNode<Integer>(0,null);
		head=dummyHead;
		int k=list.length;
		int i=k-1;
		while(i>=0){
			head.next=new ListNode<Integer>(list[i],head.next);
			i--;
		}
		return dummyHead.next;
	}
}
