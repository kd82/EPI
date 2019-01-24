package miscallaneous;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ApplyPermuatation {

	public static void main(String[] args) {
    List<Integer> A=new ArrayList<Integer>();
	A.add(1);
	A.add(2);
	A.add(3);
	A.add(4);
    List<Integer> perm=new ArrayList<Integer>();
    perm.add(2);
    perm.add(3);
    perm.add(0);
    perm.add(1);
    applyPermuatation(perm,A);
    int arr[] = {2, 3, 4, 5, 1};
    int size = arr.length;
    //variant asking for an inverse permutation
    //With no additional space and O(N2) time
    inversePermutation1(arr, size);
    //With O(N) time and O(N) space
    inversePermuatation2(arr,size);
	}

	private static void inversePermuatation2(int[] arr, int size) {
		int[] inv=new int[size];
		for(int i=0;i<size;++i)
			inv[arr[i]-1]=i+1;
		
		for(int j=0;j<size;++j)
			System.out.print(inv[j]+" ");
	}

	private static void inversePermutation1(int[] arr, int size) {
		for(int i=0;i<size;++i)
		{
			for(int j=0;j<size;++j)
			{
				if(arr[j]==i+1)
				{
					System.out.print(j+1+" ");
					break;
				}
			}
		}
	}

	private static void applyPermuatation(List<Integer> perm, List<Integer> A) {
       for(int i=0;i<A.size();++i)
       {
    	   int next=i;
    	   while(perm.get(next)>=0)
    	   {
    		   Collections.swap(A, i, perm.get(next));
    		   int temp=perm.get(next);
    		   perm.set(next, perm.get(next)-perm.size());
    		   next=temp;
    	   }
       }
       for(int i:A)
         System.out.print(i+" ");
	}

}
