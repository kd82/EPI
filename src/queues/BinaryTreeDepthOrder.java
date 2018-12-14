package queues;

import java.util.*;

public class BinaryTreeDepthOrder {

	public class BinaryTreeNode<T>{
		public T Data;
		public BinaryTreeNode<T> Left;
		public BinaryTreeNode<T> Right;
		
		public BinaryTreeNode(T data, BinaryTreeNode<T> left,BinaryTreeNode<T> right) {
			   this.Data=data;
			   this.Left=left;
			   this.Right=right;
		}
	}

	public List<List<Integer>> treeDepthOrder(BinaryTreeNode<Integer> node){
		List<List<Integer>> result=new ArrayList<List<Integer>>();
		Deque<BinaryTreeNode<Integer>> queue=new LinkedList<>();
		queue.add(node);
		List<Integer> levelData=new ArrayList<>();
		int nodesToProcess=queue.size();
		while(!queue.isEmpty()){
			BinaryTreeNode<Integer> currNode=queue.poll();
			nodesToProcess--;
			if(currNode!=null){
				levelData.add(currNode.Data);
				queue.add(currNode.Left);
				queue.add(currNode.Right);
			}
			if(nodesToProcess==0){
				nodesToProcess=queue.size();
				if(!levelData.isEmpty()){
					result.add(levelData);
					levelData.clear();
				}
			}
		}
		return result;
	}
	
	public List<List<Integer>> treeDepthOrder_v1(BinaryTreeNode<Integer> node){
		
		// Not working as expected need to re work on it 
		
		List<List<Integer>> result=new ArrayList<List<Integer>>();
		Deque<BinaryTreeNode<Integer>> queue=new LinkedList<>();
		queue.add(node);
		int depth=0;
		List<Integer> levelData=new ArrayList<>();
		int nodesToProcess=queue.size();
		while(!queue.isEmpty()){
			BinaryTreeNode<Integer> currNode=queue.poll();
			nodesToProcess--;
			if(currNode!=null){
				
				levelData.add(currNode.Data);
				if(depth%2==0){
					queue.add(currNode.Left);
					queue.add(currNode.Right);
				}
				else{
					queue.add(currNode.Right);
					queue.add(currNode.Left);
				}
			}
			if(nodesToProcess==0){
				depth++;
				nodesToProcess=queue.size();
				if(!levelData.isEmpty()){
					result.add(levelData);
					levelData.clear();
				}
			}
		}
		return result;
	}

}
