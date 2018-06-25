package linkedLists;

import java.util.Random;

public class ListHelper {
	//Prints the elements of the linkedList from head
	public static <T> void print(ListNode<T> head){
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
}
