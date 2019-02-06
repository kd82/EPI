package trees;

public class LCAWithParent {
    public BinaryTreeNode<Integer> LCA(BinaryTreeNode<Integer> node1, BinaryTreeNode<Integer> node2){

        int depth1= depth(node1),depth2=depth(node2);

        if(depth2>depth1){
            BinaryTreeNode<Integer> t=node1;
            node1=node2;
            node2=t;
        }
        int depthDiff=Math.abs(depth1-depth2);

        while(depthDiff-->0){
            node1=node1.parent;
        }

        while(node1!=node2){
            node1=node1.parent;
            node2=node2.parent;
        }

        return node1;
    }

    public int depth(BinaryTreeNode<Integer> root){
        int count=0;
        while(root.parent!=null){
            root=root.parent;
            count++;
        }
        return count;
    }
}


