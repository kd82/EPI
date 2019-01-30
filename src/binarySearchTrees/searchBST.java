package binarySearchTrees;

public class searchBST {

    public static BSTNode<Integer> search(BSTNode<Integer> root,int key){
        if(root==null || root.data==key) {
            return root;
        }
        return (key < root.data) ? search(root.left, key) : search(root.right, key);
    }
}
