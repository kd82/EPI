package trees;

import java.util.Deque;
import java.util.LinkedList;

public class PreOrderTraversal {
	
	public static void main(String[] args){
		BinaryTreeNode<Integer> tree=new BinaryTreeNode<Integer>(1);
		tree.left = new BinaryTreeNode<Integer>(2);; 
        tree.right = new BinaryTreeNode<Integer>(3);; 
        tree.left.left = new BinaryTreeNode<Integer>(4);; 
        tree.left.right = new BinaryTreeNode<Integer>(5);
        
        preOrderRecursive(tree);
        System.out.println();
        preOrderIterative(tree);
        
	}

	private static void preOrderRecursive(BinaryTreeNode<Integer> root) {
		if(root==null)
			return;
	    System.out.print(root.data+" ");
	    
	    preOrderRecursive(root.left);
	    
	    preOrderRecursive(root.right);
	    
	}
	
	private static void preOrderIterative(BinaryTreeNode<Integer> root) {
		if(root==null)
			return;

		Deque<BinaryTreeNode<Integer>> stack=new LinkedList<>();
	    stack.addFirst(root);
	    
	    while(!stack.isEmpty()){
	    	BinaryTreeNode<Integer> temp=stack.removeFirst();
	    	System.out.print(temp.data+" ");
	        
	        if(temp.right!=null)
	        	stack.addFirst(temp.right);
	        
	        if(temp.left!=null)
	        	stack.addFirst(temp.left);
	        
	    }
	}
}

