package linkedLists;

public class ListNode<T> {
	public T data;
	public ListNode<T> next;
	public ListNode<T> prev;
	
	// For Single LinkedList(SLL)
	public ListNode(T data, ListNode<T> next) {
	   this.data=data;
	   this.next=next;
	}
	// For Double LinkedList(DLL)
	public ListNode(T data, ListNode<T> next,ListNode<T> prev) {
		   this.data=data;
		   this.next=next;
		   this.prev=prev;
	}
}
