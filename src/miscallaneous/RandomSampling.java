package miscallaneous;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class RandomSampling {

	public static void main(String[] args) {
		 List<Integer> A=new ArrayList<Integer>();
			A.add(1);
			A.add(2);
			A.add(3);
			A.add(4);
		System.out.println("Random Sampling:");
		randomSampling(A,3);
		System.out.println("\nRandom permutation:");
		List<Integer> permutation=randomPermutation(50);
		for(int i=0;i<50;i++)
		{
			System.out.print(permutation.get(i)+" ");
		}
	}

	private static List<Integer> randomSampling(List<Integer> A, int K) {
		Random r=new Random();
		for(int i=0;i<A.size();i++)
		{
			Collections.swap(A, i, r.nextInt(A.size()-1));
		}
		for(int i=0;i<A.size();i++)
		{
			System.out.print(A.get(i)+" ");
		}
		return A;
	}
	private static List<Integer> randomPermutation(int n)
	{
		List<Integer> permutation=new ArrayList<Integer>(n);
		for(int i=0;i<n;++i)
		{
			permutation.add(i);
		}
		permutation=randomSampling(permutation,permutation.size());
		return permutation;
	}

}
