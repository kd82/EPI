package trees;

public class LongestCommonLCA {

    public static class Status{
        int numTargetNodes;
        BinaryTreeNode<Integer> ancestor;

        public Status(int nodes,BinaryTreeNode<Integer> root){
            this.numTargetNodes=nodes;
            this.ancestor=root;
        }
    }

    public static void main(String[] args){

        BinaryTreeNode<Integer> tree=new BinaryTreeNode<Integer>(1);
        tree.left = new BinaryTreeNode<Integer>(2);;
        tree.right = new BinaryTreeNode<Integer>(3);;
        tree.left.left = new BinaryTreeNode<Integer>(4);;
        tree.left.right = new BinaryTreeNode<Integer>(5);

        System.out.println(LCA(tree,tree.left.left,tree.left.right).data);
    }

    private static BinaryTreeNode<Integer> LCA(BinaryTreeNode<Integer> tree, BinaryTreeNode<Integer> tree0, BinaryTreeNode<Integer> tree1) {

        return LCAHelper(tree,tree0,tree1).ancestor;
    }

    private static Status LCAHelper(BinaryTreeNode<Integer> tree, BinaryTreeNode<Integer> tree0, BinaryTreeNode<Integer> tree1) {

        //base case
        if(tree==null) {
            return new Status(0,null);
        }

        Status left=LCAHelper(tree.left,tree0,tree1);

        if(left.numTargetNodes==2)
        {
            return left;
        }

        Status right=LCAHelper(tree.right,tree0,tree1);

        if(right.numTargetNodes==2)
        {
            return right;
        }

        int numTargetNodes=left.numTargetNodes+right.numTargetNodes+(tree==tree0?1:0)+(tree==tree1?1:0);

        return new Status(numTargetNodes,numTargetNodes==2?tree:null);
    }
}
