package trees;

public class HasPathSum {
    public static void main(String[] args){
        BinaryTreeNode<Integer> tree=new BinaryTreeNode<Integer>(5);
        tree.left = new BinaryTreeNode<Integer>(4);
        tree.right = new BinaryTreeNode<Integer>(8);
        tree.left.left = new BinaryTreeNode<Integer>(11);
        tree.left.left.right = new BinaryTreeNode<Integer>(2);
        tree.left.left.left=new BinaryTreeNode<>(7);


        System.out.println(hasPathSum(tree,22));
    }

    public static boolean hasPathSum(BinaryTreeNode<Integer> root,int sum){
        return pathSum(root,0,sum);
    }

    public static boolean pathSum(BinaryTreeNode<Integer> root,int partialPathSum,int sum){
        if(root==null)
            return false;
        partialPathSum+=root.data;
        if(root.left==null && root.right==null)
            return partialPathSum==sum;

        return pathSum(root.left,partialPathSum,sum)|| pathSum(root.right,partialPathSum,sum);
    }
}
