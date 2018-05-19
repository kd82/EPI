import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class OnlineRandomSample {

	public static void main(String[] args) {
		List<Integer> seqList=new ArrayList<Integer>();
		Random r=new Random();
		for(int i=0;i<10;i++)
		{
			seqList.add(r.nextInt(10));
		}
		Iterator<Integer> seq=seqList.iterator();
		List<Integer> sample=randomSample(seq,3);
		System.out.println("Random Sample:");
		for(int i=0;i<3;i++)
		{
			System.out.print(sample.get(i)+" ");
		}
		System.out.println("\nRandom Subset:");
		List<Integer> permutation=randomSubset(10, 5);
		for(int i=0;i<5;i++)
		{
			System.out.print(permutation.get(i)+" ");
		}
	}

	private static List<Integer> randomSample(Iterator<Integer> sequence, int k) {
        List<Integer> resultSample=new ArrayList<Integer>();
        //fill the elements up to K 
        for(int i=0;i<k && sequence.hasNext();i++)
        {
        	resultSample.add(sequence.next());
        }
        //Have filled the values up to K
        int numSoFar=k;
        Random randomIdxGen=new Random();
        while(sequence.hasNext())
        {
        	//Get the next number from the sequence
        	Integer x=sequence.next();
        	//increase the k value for the random to generate from the given range
        	//otherwise it would return 0 to k-1
        	++numSoFar;
        	int idxToReplace=randomIdxGen.nextInt(numSoFar);
        	if(idxToReplace<k) // if it falls in between 0 and k-1 then replace
        		resultSample.set(idxToReplace, x);
        }
		return resultSample;
	}
	
	private static List<Integer> randomSubset(int n,int k)
	{
		// Hash Map to reduce the space 
		Map<Integer, Integer> changedElems = new HashMap<>();
	    Random randIdxGen = new Random();
	    for (int i = 0; i < k; ++i) {
	      // Generate random int in [0, n-i-1].
	      int randIdx = randIdxGen.nextInt(n - i - 1);
	      Integer ptr1 = changedElems.get(randIdx);
	      Integer ptr2 = changedElems.get(i);
	      if (ptr1 == null && ptr2 == null) {
	        changedElems.put(randIdx, i);
	        changedElems.put(i, randIdx);
	      } else if (ptr1 == null && ptr2 != null) {
	        changedElems.put(randIdx, ptr2);
	        changedElems.put(i, randIdx);
	      } else if (ptr1 != null && ptr2 == null) {
	        changedElems.put(i, ptr1);
	        changedElems.put(randIdx, i);
	      } else {
	        changedElems.put(i, ptr1);
	        changedElems.put(randIdx, ptr2);
	      }
	    }

	    List<Integer> result = new ArrayList<>(k);
	    for (int i = 0; i < k; ++i) {
	      result.add(changedElems.get(i));
	    }
	    return result;
	}
}
