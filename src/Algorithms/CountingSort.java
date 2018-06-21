package Algorithms;

public class CountingSort {

	public static void main(String[] args) {
	 //Let the input be in the range of 1 to 100 
	// Counting Sort works only when we know the range of the input and operates in O(n) time
	// It takes constant space which is the space needed to maintain the counts
	int[] input=new int[]{99,98,99,96,67,33,22,1,3,5,2,2,2,2,2,2,2,22,22,2,7,11,33};
	int[] sorted=countSort(input);
	for(int i=0;i<sorted.length;i++){
			System.out.print(sorted[i]+" ");
		}
	}

	private static int[] countSort(int[] input) {
		int[] sorted=new int[input.length+1];
		int[] counts=new int[100];
		
		for(int i=0;i<input.length;++i){
			counts[input[i]]++;
		}
		for(int j=1;j<counts.length;++j){
			counts[j]=counts[j-1]+counts[j];
		}
		
		for(int k=0;k<input.length;k++){
			sorted[counts[input[k]]]=input[k];
			counts[input[k]]--;
		}
		return sorted;
	}

}
