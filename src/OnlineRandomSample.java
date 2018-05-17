import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
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
		for(int i=0;i<3;i++)
		{
			System.out.print(sample.get(i)+" ");
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
        	if(idxToReplace<k)
        		resultSample.set(idxToReplace, x);
        }
		return resultSample;
	}

}
