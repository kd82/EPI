package trees;

import java.util.Deque;
import java.util.LinkedList;

public class PostOrderTraversal {
	public static void main(String[] args){
		BinaryTreeNode<Integer> tree=new BinaryTreeNode<Integer>(1);
		tree.left = new BinaryTreeNode<Integer>(2);; 
        tree.right = new BinaryTreeNode<Integer>(3);; 
        tree.left.left = new BinaryTreeNode<Integer>(4);; 
        tree.left.right = new BinaryTreeNode<Integer>(5);
        
        postOrderRecursive(tree);
        System.out.println();
        postOrderIterative(tree);
        System.out.println();
        postOrderIterativeOneStack(tree);
	}
	
    //using two stacks
	private static void postOrderIterative(BinaryTreeNode<Integer> root) {
		if(root==null)
			return;
		Deque<BinaryTreeNode<Integer>> s1=new LinkedList<>();
		Deque<BinaryTreeNode<Integer>> s2=new LinkedList<>();
		s1.addFirst(root);
		while(!s1.isEmpty()){
			BinaryTreeNode<Integer> temp=s1.removeFirst();
			
			s2.addFirst(temp);
			
			if(temp.left!=null)
				s1.addFirst(temp.left);
			
			if(temp.right!=null)
				s1.addFirst(temp.right);
			
		}
		
		while(!s2.isEmpty()){
			System.out.print(s2.removeFirst().data+" ");
		}
	}
	
	//using two stacks
		private static void postOrderIterativeOneStack(BinaryTreeNode<Integer> root) {
			if(root==null)
				return;
			Deque<BinaryTreeNode<Integer>> s1=new LinkedList<>();
			s1.addFirst(root);
			BinaryTreeNode<Integer> prev=null;
			while(!s1.isEmpty()){
				BinaryTreeNode<Integer> curr=s1.peek();
				if(prev==null || prev.left==curr || prev.right==curr){
					if(curr.left!=null)
						s1.addFirst(curr.left);
					
					else if(curr.right!=null)
						s1.addFirst(curr.right);
				}
				else if(curr.left==prev){
					if(curr.right!=null)
						s1.addFirst(curr.right);
				}
				else{
					System.out.print(curr.data+" ");
					s1.removeFirst();
				}
				
			   prev=curr;
			}
		
		}

	private static void postOrderRecursive(BinaryTreeNode<Integer> root) {
		if(root==null)
			return;
		postOrderRecursive(root.left);
		postOrderRecursive(root.right);
		System.out.print(root.data+" ");
	}
}
