package trees;

public class SumToLeafPaths {
    public static void main(String[] args){
        BinaryTreeNode<Integer> tree=new BinaryTreeNode<Integer>(4);
        tree.left = new BinaryTreeNode<Integer>(9);
        tree.right = new BinaryTreeNode<Integer>(0);
        tree.left.left = new BinaryTreeNode<Integer>(5);
        tree.left.right = new BinaryTreeNode<Integer>(1);


        System.out.println(pathSum(tree));
    }

    public static int pathSum(BinaryTreeNode<Integer> root){
       return pathSumHelper(root,0);
    }

    public static int pathSumHelper(BinaryTreeNode<Integer> root,int partialPathSum){
        if(root==null)
            return 0;
        partialPathSum=partialPathSum*10+root.data;
        if(root.left==null && root.right==null)
            return partialPathSum;

        return pathSumHelper(root.left,partialPathSum)+pathSumHelper(root.right,partialPathSum);
    }

}
