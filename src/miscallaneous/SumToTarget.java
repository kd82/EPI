package miscallaneous;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SumToTarget {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       int[] input={1,10,11,15,17,19,21};
       int target=62;
       System.out.println(sumEqualToTarget(input,target));
	}

	private static boolean sumEqualToTarget(int[] input, int k) {
		HashMap<Integer,List<Integer>> sumMap=new HashMap<Integer,List<Integer>>();
		for(int i=0;i<input.length;i++){
			for(int j=i+1;j<input.length;j++){
				int sum=input[i]+input[j];
				if(sumMap.containsKey(k-sum)){
					List<Integer> values=sumMap.get(k-sum);
					if(input[values.get(0)]+input[values.get(1)]+k-sum==k){
						System.out.println(input[values.get(0)]+" "+input[values.get(1)]);
						return true;
					}
				}
				else{
					List<Integer> indices=new ArrayList<Integer>();
					indices.add(i);
					indices.add(j);
					sumMap.put(k-sum,indices);
				}
			}
		}
		return false;
	}

}
