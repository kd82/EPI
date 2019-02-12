package miscallaneous;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AddToArray {


    public static void main(String[] args){
        int[] res={2,7,4};

        List<Integer> reas=addToArrayForm(res,181);
        for(int i=0;i<reas.size();i++){
            System.out.print(reas.get(i));
        }
    }

    public static List<Integer> addToArrayForm(int[] A, int K) {
        List<Integer> res=new ArrayList<>();
        int carry=0;
        for(int j=A.length-1;j>=0;j--){
            int val=A[j]+K%10;
            val+=carry;
            if(val>9){
                carry=val/10;
                res.add(val%10);
            }
            else
            {
                res.add(val);
                carry=0;
            }
            K=K/10;
        }
        while(K!=0)
        {
            if(K%10+carry>9){
                carry=(K%10+carry)/10;
                res.add((K%10+carry)%10);
            }
            else{
                res.add(K%10+carry);
                carry=0;
            }
            K=K/10;
        }
        if(carry!=0)
            res.add(carry);
        Collections.reverse(res);
        return res;
    }
}
