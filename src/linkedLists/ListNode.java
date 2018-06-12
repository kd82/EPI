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
	// Search for the given Key
	public ListNode<T> Search(ListNode<T> node,T key){
		while(node.next!=null && node.data!=key){
			node=node.next;
		}
		return node;
	}
	//Inserts After a given Node
	public void InsertAfter(ListNode<T> node,ListNode<T> newNode){
		newNode.next=node.next;
		node.next=newNode;
	}
	//deletes the given Node
	public void Delete(ListNode<T> anode){
		anode.next=anode.next.next;
	}
	public void print(ListNode<T> head){
		while(head.next!=null){
			System.out.print(head.data+"->");
			head=head.next;
		}
	}
}
