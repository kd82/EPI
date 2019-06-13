package trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BinaryTreeFromInOrderPreOrder {

	public static void main(String[] args) {
		
	    List<Integer> inorder=new ArrayList<>();
	    List<Integer> preorder=new ArrayList<Integer>();
	    
	    preorder.add(3);
	    preorder.add(9);
	    preorder.add(20);
	    preorder.add(15);
	    preorder.add(7);
	    
	    inorder.add(9);
	    inorder.add(3);
	    inorder.add(15);
	    inorder.add(20);
	    inorder.add(7);
	    
	    System.out.println(constructBinaryTree(inorder,preorder).data);
           
	}

	private static BinaryTreeNode<Integer> constructBinaryTree(List<Integer> inorder, List<Integer> preorder) {
		Map<Integer,Integer> map=new HashMap<>();
		
	    for(int i=0;i<inorder.size();++i) {
	    	map.put(inorder.get(i), i);
	    }
		return binaryTreeHelper(preorder,0,preorder.size(),0,inorder.size(),map);
	}

	private static BinaryTreeNode<Integer> binaryTreeHelper(List<Integer> preorder,int preOrderStart, int preOrderEnd, int inOrderStart,
			int inOrderEnd,Map<Integer, Integer> map) {
		if(preOrderEnd<=preOrderStart || inOrderEnd<=inOrderStart)
			return null;
		
		int rootInorderIdx=map.get(preorder.get(preOrderStart));
		int leftSubTreeSize=rootInorderIdx-inOrderStart;
		
		return new BinaryTreeNode<Integer>(preorder.get(preOrderStart),
				binaryTreeHelper(preorder,preOrderStart+1,preOrderStart+1+leftSubTreeSize,inOrderStart,rootInorderIdx,map),
				binaryTreeHelper(preorder,preOrderStart+1+leftSubTreeSize,preOrderEnd,rootInorderIdx+1,inOrderEnd,map));
	}

}
