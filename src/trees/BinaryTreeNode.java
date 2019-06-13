package trees;

import binarySearchTrees.BSTNode;

public class BinaryTreeNode<T> {
	public T data;
    public BinaryTreeNode<T> left,right,parent;

    public BinaryTreeNode(T item)
    {
        this.data = item;
        this.left = this.right=this.parent = null;
    }

	public BinaryTreeNode(T d, BinaryTreeNode<T> left,
			BinaryTreeNode<T> right) {
		this.data=d;
		this.left=left;
		this.right=right;
	}
}
