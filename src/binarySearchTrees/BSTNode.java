package binarySearchTrees;

import trees.BinaryTreeNode;

public class BSTNode <T> {
    public T data;
    public BSTNode<T> left,right;

    public BSTNode(T item)
    {
        this.data = item;
        this.left = this.right = null;
    }
}