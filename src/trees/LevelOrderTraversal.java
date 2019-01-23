package trees;

import java.util.Deque;
import java.util.LinkedList;

public class LevelOrderTraversal {

	public static void levelOrder(BinaryTreeNode<Integer> root) {
		if(root==null)
			return;
		Deque<BinaryTreeNode<Integer>> queue=new LinkedList<>();
		queue.addLast(root);
		
		while(!queue.isEmpty()){
			BinaryTreeNode<Integer> temp=queue.removeFirst();
			
			System.out.print(temp.data+" ");
			
			if(temp.left!=null)
				queue.addLast(temp.left);
			if(temp.right!=null)
				queue.addLast(temp.right);
		}
	}

	public static void main(String[] args) {
		
		BinaryTreeNode<Integer> tree=new BinaryTreeNode<Integer>(1);
		tree.left = new BinaryTreeNode<Integer>(2);; 
        tree.right = new BinaryTreeNode<Integer>(3);; 
        tree.left.left = new BinaryTreeNode<Integer>(4);; 
        tree.left.right = new BinaryTreeNode<Integer>(5);
        
        levelOrder(tree);
      
	}

}
