import java.awt.Color;
import java.io.*;
import java.util.*;

import org.omg.CosNaming.NamingContextExtPackage.AddressHelper;

public class Array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int[] in={1,3,3,3,2,2,2};//,5,6,8,8,9,9,9,9};
        //Random random=new Random();
        //for(int i=0;i<10;i++)
        //{
        	//in[i]=random.nextInt();
        //}
       //for(int j=0;j<10;j++)
      // System.out.print(in[j]+" ");
        boolean[] boolArr={false,true,false,true,false,true,true};
        //evenOdd(in);
        //quickSort(in);
        //sortProblem(in, 0);
        //DNF3(in);
        //boolDNF(randomBools(10));
        
        //findNonRecurring(in);
        List<Integer> li=new ArrayList();
        li.add(9);
        li.add(9);
        li.add(9);
        //plusOne(li);
        addBinary("11","1");
        
	}
   
    public static boolean[]  randomBools(int len) {
		Random random=new Random();
	    boolean[] arr = new boolean[len];
	    for(int i = 0; i < len; i++) {
	        arr[i] = random.nextBoolean();
	    }
	    return arr;
	}

	private static void evenOdd(int[] in) {
		int i=0, j=in.length-1;
		while(i<j)
		{
			if((in[i]%2)==0)
			{
				i++;
			}
			else
			{
				int temp=in[i];
				in[i]=in[j];
				in[j--]=temp;
			}
		}
		System.out.println("\nSorted");
		System.out.println(Arrays.hashCode(in));
	}
	
	public static void quickSort(int[] arr)
	{
		quickSort(arr,0,arr.length-1);
		System.out.println(Arrays.toString(arr));
	}

	private static void quickSort(int[] arr, int left, int right) {
		// TODO Auto-generated method stub
		if(left>=right)
			return;
		int pivot=arr[(left+right)/2];
		int index=partition(arr,left,right,pivot);
		quickSort(arr,left,index-1);
		quickSort(arr,index+1,right);
	}

	private static int partition(int[] arr, int left, int right, int pivot) {
		while(left<=right)
		{
			while(arr[left]<pivot)
				left++;
			  	
		    while(arr[right]>pivot)
		    	right--;
		   
		    if(left<=right) 
		    {
		    int temp=arr[left];
		    arr[left]=arr[right];
		    arr[right]=temp;
		    left++;
		    right--;
		    }
		}
		return left;
	}
	
	private static void sortProblem(final int[] a, final int index)
	{
		int pivot=a[index];
		int i=0;
		int j=a.length-1;
		while(i<j)
		{
			if(a[i]<pivot)
			{
				i++;
			}
			if(a[j]>pivot)
			{
				j--;
			}
			if(i<=j)
			{
				int temp=a[i];
				a[i]=a[j];
				a[j]=temp;
				i++;
				j--;
			}
		}
	}
    
	private static void boolDNF(boolean[] arr)
	{
		int left=0,right=arr.length-1;
		while(left<right)
		{
		            /* Increment left index while we see 0 at left */
		            while (arr[left] == false && left < right)
		               left++;
		 
		            /* Decrement right index while we see 1 at right */
		            while (arr[right] == true && left < right)
		                right--;
		 
		            /* If left is smaller than right then there is a 1 at left
		               and a 0 at right.  Exchange arr[left] and arr[right]*/
		            if (left < right) 
		            {
		                arr[left] = false;
		                arr[right] = true;
		                left++;
		                right--;
		            }
		}
		
		for(int k=0;k<arr.length;k++)
			System.out.println(arr[k]);
	}
    
	private static int findNonRecurring(int[] arr)
	{
		 int[] bitSum = new int[32];
		    for(int i = 0; i < 32; ++i) {
		        bitSum[i] = 0;
		    }
		       
		    for(int i = 0; i < arr.length; ++i) {
		        int bitMask = 1;
		        for(int j = 31; j >= 0; --j) {
		            int bit = arr[i] & bitMask;
		            if(bit != 0) {
		                bitSum[j] += 1;
		            }
		            bitMask = bitMask << 1;
		            System.out.print(bitMask+" ");
		        }
		    }
		       
		    int result = 0;
		    for(int i = 0; i < 32; ++i) {
		        result = result << 1;
		        result += bitSum[i] % 3;
		    }
		    System.out.println(result);
		    return result;
	}
   
	private static List<Integer> plusOne(List<Integer> in)
	{
	   int n=in.size()-1;
	   in.set(n, in.get(n)+1);
	   for(int i=n;i>0 && in.get(i)==10;--i)
	   {
		   in.set(i, 0);
		   in.set(i-1, in.get(i-1)+1);
	   }
	   if(in.get(0)==10)
	   {
		   in.set(0,0);
		   in.add(0,1);
	   }
	   System.out.println(in);
	   return in;
	}
   
	private static void addBinary(String a,String b)
	{
		StringBuilder sb=new StringBuilder();
		
		int i=a.length()-1;
		int j=b.length()-1;
		int carry=0;
		while(i>=0 || j>=0)
		{
			int sum=0;
			if(i>=0 && a.charAt(i)=='1')
				sum++;
			if(j>=0 && b.charAt(j)=='1')
				sum++;
			
			sum+=carry;
			
			if(sum>=2)
			{
				carry=1;
			}
			else
			{
				carry=0;
			}
			
			sb.insert(0, (char) ((sum%2) + '0'));
			i--;
			j--;
		}
		if(carry==1)
			sb.insert(0, '1');
		System.out.println(sb);
	}
}
