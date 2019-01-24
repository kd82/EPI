package miscallaneous;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Permutations {

	public static void main(String[] args) {
		List<Integer> A=new ArrayList<Integer>();
		A.add(1);
		A.add(2);
		A.add(3);
		A.add(4);

	    List<Integer> nextPerm=nextPermutation(A);
	    System.out.print("Next Permutation:");
	    for(int i=0;i<nextPerm.size();++i)
	    {
	    	System.out.print(nextPerm.get(i)+" ");
	    }
	    System.out.println();
	    List<Integer> previousPerm=previousPermutation(nextPerm);
	    System.out.print("Previous Permutation:");
	    for(int i=0;i<previousPerm.size();++i)
	    {
	    	System.out.print(nextPerm.get(i)+" ");
	    }
	    System.out.println();
	    // Compute permutations starting from 123
	    //A clear explanation can be found in the below link
	    //https://stackoverflow.com/questions/31216097/given-n-and-k-return-the-kth-permutation-sequence
	 	for(int i = 0; i < 6; i++)
	 	  kthPermutation(3, i);
	 	kthPermutation(100, 100-1);
	}

	private static void kthPermutation(int n, int k) {

		int[] numbers = new int[n];
		int[] indices = new int[n];
 
        // initialize the numbers 1, 2, 3...
        for (int i = 0; i < n; i++)
        	numbers[i] = i + 1;
 
        int divisor = 1;
        for (int place = 1; place <= n; place++)
        {
        	if((k / divisor) == 0)
        		break;	// all the remaining indices will be zero
 
        	// compute the index at that place:
        	indices[n-place] = (k / divisor) % place;
        	divisor *= place;
        }
        
        // permute the numbers array according to the indices:
        for (int i = 0; i < n; i++)
        {
        	int index = indices[i] + i;
 
        	// take the element at index and place it at i, moving the rest up
        	if(index != i)
        	{
        		int temp = numbers[index];
        		for(int j = index; j > i; j--)
        		   numbers[j] = numbers[j-1];
        		numbers[i] = temp;
        	}
        }
 
        System.out.println(Arrays.toString(numbers));
	}

	private static List<Integer> previousPermutation(List<Integer> perm) {
		 int k=perm.size()-2;
		   while(k>=0 && perm.get(k)>=perm.get(k+1))
		   {
			   --k;
		   }
		   if(k==-1)
			   return Collections.emptyList();
		   for(int i=perm.size()-1;i>k;--i)
		   {
			   if(perm.get(i)<perm.get(k))
			   {
				   Collections.swap(perm, k, i);
			       break;
			   }
		   }
		   Collections.reverse(perm.subList(k+1,perm.size()));
		   return perm;
	}

	private static List<Integer> nextPermutation(List<Integer> perm) {
	   int k=perm.size()-2;
	   while(k>=0 && perm.get(k)>=perm.get(k+1))
	   {
		   --k;
	   }
	   if(k==-1)
		   return Collections.emptyList();
	   for(int i=perm.size()-1;i>k;--i)
	   {
		   if(perm.get(i)>perm.get(k))
		   {
			   Collections.swap(perm, k, i);
		       break;
		   }
	   }
	   Collections.reverse(perm.subList(k+1,perm.size()));
	   return perm;
	}

}
