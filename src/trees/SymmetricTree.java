package trees;

public class SymmetricTree {

	public  static boolean isSymmetricTree(BinaryTreeNode<Integer> root) {
		return root==null || checkSymmetric(root.left,root.right);
	}

	public static boolean checkSymmetric(BinaryTreeNode<Integer> tree0,BinaryTreeNode<Integer> tree1){
		//base case
		if(tree0==null && tree1==null)
			return true;
		else if(tree0!=null && tree1!=null)
			return tree0.data==tree1.data && checkSymmetric(tree0.left,tree1.right) && checkSymmetric(tree0.right,tree1.left);
		return false;
	}

	public static void main(String[] args) {

	}

}
