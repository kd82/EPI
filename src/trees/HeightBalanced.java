package trees;

public class HeightBalanced {
    public static class BalancedWithStatus{
    	int height;
    	boolean balanced;
    	
    	public BalancedWithStatus(boolean b,int h){
    		this.height=h;
    		this.balanced=b;
    	}
    }
	
	public static boolean isHeightBalanced(BinaryTreeNode<Integer> root) {
		
		return checkHeights(root).balanced;
	}

	private static BalancedWithStatus checkHeights(BinaryTreeNode<Integer> root) {
		//base case
		if(root==null){
			return new BalancedWithStatus(true,-1);
		}
		
		BalancedWithStatus leftSubTree=checkHeights(root.left);
		
		if(!leftSubTree.balanced)
			return leftSubTree;
		
		BalancedWithStatus rightSubTree=checkHeights(root.right);
		
		if(!rightSubTree.balanced)
			return rightSubTree;
		
		boolean isBalanced=Math.abs(leftSubTree.height-rightSubTree.height)<=1;
		int height=Math.max(leftSubTree.height, rightSubTree.height)+1;
		
		return new BalancedWithStatus(isBalanced,height);
	}

	public static void main(String[] args) {
		BinaryTreeNode<Integer> tree=new BinaryTreeNode<Integer>(1);
		tree.left = new BinaryTreeNode<Integer>(2); 
        tree.right = new BinaryTreeNode<Integer>(3);
        tree.left.left = new BinaryTreeNode<Integer>(4);
        tree.left.left.left = new BinaryTreeNode<Integer>(5);
        
        
        System.out.println(isHeightBalanced(tree));

	}

}
