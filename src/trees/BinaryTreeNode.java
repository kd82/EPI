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
<<<<<<< HEAD
=======

	public BinaryTreeNode(T d, BinaryTreeNode<T> left,
			BinaryTreeNode<T> right) {
		this.data=d;
		this.left=left;
		this.right=right;
	}
>>>>>>> c02d66d7ac0d64834bc80a5fd1e480ae0b2a4e69
}
