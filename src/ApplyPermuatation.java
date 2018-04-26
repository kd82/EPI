import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ApplyPermuatation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
       {
       System.out.print(i+" ");
       }
	}

}
