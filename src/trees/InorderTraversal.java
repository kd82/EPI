package trees;

import java.util.Deque;
import java.util.LinkedList;

public class InorderTraversal {
	public static void main(String[] args){
		BinaryTreeNode<Integer> tree=new BinaryTreeNode<Integer>(1);
		tree.left = new BinaryTreeNode<Integer>(2);; 
        tree.right = new BinaryTreeNode<Integer>(3);; 
        tree.left.left = new BinaryTreeNode<Integer>(4);; 
        tree.left.right = new BinaryTreeNode<Integer>(5);
        
        inOrderRecursive(tree);
        System.out.println();
        inOrderIterative(tree);
        
	}

	private static void inOrderIterative(BinaryTreeNode<Integer> root) {
		if(root==null)
			return;
		
		Deque<BinaryTreeNode> stack=new LinkedList<>();
		
		BinaryTreeNode<Integer> start=root;

		while(start!=null || stack.size()>0){
			while(start!=null)
			{
				stack.addFirst(start);
				start=start.left;
			}
			
			start=stack.removeFirst();
			System.out.print(start.data+" ");
			start=start.right;
		}
		
	}

	private static void inOrderRecursive(BinaryTreeNode<Integer> root) {
		if(root==null)
			return;
		
		inOrderRecursive(root.left);
		
		System.out.print(root.data+" ");
		
		inOrderRecursive(root.right);
	}
}
