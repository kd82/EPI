package trees;

public class NthNodeOrderTraversal {
    static int count1=0,count2=0;
	public static void main(String[] args) {
		
		 BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(10);  
		    root.left = new BinaryTreeNode<Integer>(20);  
		    root.right = new BinaryTreeNode<Integer>(30);  
		    root.left.left = new BinaryTreeNode<Integer>(40);  
		    root.left.right = new BinaryTreeNode<Integer>(50);  
		    
		    int n = 4;  
		    
		    NthInorder(root, n);  
		    NthPostorder(root, n);
	}

	private static void NthInorder(BinaryTreeNode<Integer> root, int n) {
		if(root==null) 
			return;
		
		if(count1<=n) {
		    NthInorder(root.left, n);
		    count1++;
		    if(count1==n) {
		    	System.out.println(root.data);
		    }
		    NthInorder(root.right, n);
		}
		
	}
	
	
	private static void NthPostorder(BinaryTreeNode<Integer> root, int n) {
		if(root==null) 
			return;
		
		if(count2<=n) {
			NthPostorder(root.left, n);
		    
		    NthPostorder(root.right, n);
		    count2++;
		    if(count2==n) {
		    	System.out.println(root.data);
		    }
		}
		
	}
	
	

}
