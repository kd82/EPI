package trees;

import binarySearchTrees.BSTNode;

public class BinaryTreeNode<T> {
	public T data;
    public BinaryTreeNode<T> left,right;

    public BinaryTreeNode(T item)
    {
        this.data = item;
        this.left = this.right = null;
    }
}
