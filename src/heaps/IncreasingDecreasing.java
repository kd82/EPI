package heaps;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class IncreasingDecreasing {

    public static void main(String[] args){
        List<Integer> input=new ArrayList<>();
        input.add(57);
        input.add(131);
        input.add(493);
        input.add(291);
        input.add(221);
        input.add(339);
        input.add(418);
        input.add(452);
        input.add(442);
        input.add(190);

        List<Integer> sorted=increasingDecreasingArray(input);

        for(int i:sorted){
            System.out.print(i+" ");
        }

    }
    public static enum subArrayType {
        INCREASING,DECREASING
    }
    public static List<Integer> increasingDecreasingArray(List<Integer> a){

        List<List<Integer>> sortedArrays=new ArrayList<>();
        int startIdx=0;
        subArrayType arrayType=subArrayType.INCREASING;
        for(int i=1;i<=a.size();i++){
            if(i==a.size()
                    || (a.get(i-1)<a.get(i) && arrayType==subArrayType.DECREASING)
                    || (a.get(i-1)>=a.get(i) && arrayType==subArrayType.INCREASING )){

                List<Integer> subList=a.subList(startIdx,i);
                startIdx=i;
                if(arrayType==subArrayType.DECREASING){
                    Collections.reverse(subList);
                }
                sortedArrays.add(subList);
                arrayType=arrayType==subArrayType.DECREASING?subArrayType.INCREASING:subArrayType.DECREASING;
            }
        }

        return MergeSortedFiles.mergeFiles(sortedArrays);
    }

}
