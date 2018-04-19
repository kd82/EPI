

public class Practice {

	class Node {
	     int data;
	     Node next;
	  }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr={2,4,0,1,1,2,3};
		int[] arr1={2,2,2,3,5,5,5,7,11,11,11,13};
	   // System.out.println(advanceArray(arr));
	    deleteDuplicates(arr1,2);
	}
	private static boolean advanceArray(int[] arr) {
	  boolean possible=false;
	  int i=0,moves=0;
	  while(i<arr.length-1)
	   {
		   if(i+arr[i]<arr.length-1 && arr[i+arr[i]]==0)
		   {
			   i++;
		   }
		   else if(i+arr[i]>=arr.length-1)
		   {
			   possible=true;
			   moves++;
			   break;
		   }
		   else
		   {
			   int[] a=new int [arr[i]];
			   while(i<arr[i])
			   {
				 a[i]=arr[i];
				 i++;
			   }
			   
               i=getMaxValIndex(a);
               System.out.println(i);
			   i+=arr[i];
			   moves++; 
		   }
	   }
	  System.out.println(moves);
	  return possible;
	}

	public static int getMaxValIndex(int[] numbers){
		  int maxValue = numbers[0];
		  int maxIndex=0;
		  for(int i=1;i < numbers.length;i++){
		    if(numbers[i] > maxValue){
			  maxValue = numbers[i];
			  maxIndex=i;
			}
		  }
		  return maxIndex;
		}
	
	private static boolean advanceArrayBook(int[] arr)
	{
		int lastIndex=arr.length-1;
		int farthest=0;
		for(int i=0;i<=farthest && farthest<lastIndex;++i)
		{
			farthest=Math.max(farthest, i+arr[i]);
		}
		return farthest>=lastIndex;
	}
    
	private static void deleteDuplicates(int a[],int key)
	{
		int index=1;
		int keyCount=0;
        for(int i=1;i<a.length;i++)
        {
        	if(a[index-1]!=a[i])
        	{ 
        	  a[index++]=a[i];
        	}
        	else if(a[i]==key)
        	{
        		keyCount++;
        		if(keyCount>=2)
        		  a[index++]=a[i];
        	}
        }
	    for(int k=0;k<a.length;++k)
	    {
	    	System.out.print(a[k]+" ");
	    }
	}
}
