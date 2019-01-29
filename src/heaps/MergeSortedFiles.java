package heaps;

import java.util.*;

public class MergeSortedFiles {

    public static void main(String[] args){
       List<List<Integer>> input=new ArrayList<>();

       List<Integer> a=new ArrayList<>();
       a.add(9);
       a.add(10);
       a.add(11);
       input.add(a);

        List<Integer> b=new ArrayList<>();
        b.add(2);
        b.add(3);
        b.add(14);

        input.add(b);

        List<Integer> c=new ArrayList<>();
        c.add(2);
        c.add(3);
        input.add(c);

        List<Integer> sorted=mergeFiles(input);

        for(int i=0;i<sorted.size();i++){
            System.out.print(sorted.get(i)+" ");
        }
    }
    public static class ArrayEntry{
        public Integer value;
        public Integer arrayId;

        public ArrayEntry(Integer v,Integer id){
            this.value=v;
            this.arrayId=id;
        }
    }

    public static final int INTIAL_CAPACITY=16;

    public static List<Integer> mergeFiles(List<List<Integer>> sortedFiles){

        PriorityQueue<ArrayEntry> minHeap=new PriorityQueue<>(INTIAL_CAPACITY, new Comparator<ArrayEntry>() {
            @Override
            public int compare(ArrayEntry o1, ArrayEntry o2) {
                return Integer.compare(o1.value,o2.value);
            }
        });

        // Store the initial elements of all the arrays in the heap in an array

        List<Integer> heads=new ArrayList<>(sortedFiles.size());

        for(int i=0;i<sortedFiles.size();i++){
            if(sortedFiles.get(i).size()>0){
                minHeap.add(new ArrayEntry(sortedFiles.get(i).get(0),i));
                heads.add(1);
            }
            else
                heads.add(0);
        }

        List<Integer> result=new ArrayList<>();
        ArrayEntry minElement;

        while((minElement= minHeap.poll())!=null){
            result.add(minElement.value);

            List<Integer> smallestArray=sortedFiles.get(minElement.arrayId);

            int smallestArrayHead=heads.get(minElement.arrayId);

            if(smallestArrayHead<smallestArray.size()){
                minHeap.add(new ArrayEntry(smallestArray.get(smallestArrayHead),minElement.arrayId));
                heads.set(minElement.arrayId,heads.get(minElement.arrayId)+1);
            }
        }

        return result;
    }


}
