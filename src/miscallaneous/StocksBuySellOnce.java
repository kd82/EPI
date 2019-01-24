package miscallaneous;

public class StocksBuySellOnce {
	public static void main(String[] args) {
		
     int[] stocks={310,315,275,295,260,270,290,230,255,250};
     int[] elems={310,275,275,275};
     System.out.println(computeMaxProfit(stocks));
     System.out.println(longestCommonSubArray(elems));
     
	}

	private static int computeMaxProfit(int[] stocks) {
		int maxProfit=0;
		int minPrice=Integer.MAX_VALUE;
		for(int i=0;i<stocks.length;++i)
		{
			minPrice=Math.min(minPrice, stocks[i]);
			maxProfit=Math.max(maxProfit, stocks[i]-minPrice);
		}
		return maxProfit;
	}
	
	private static int longestCommonSubArray(int[] arr) {
		int n=arr.length;
	    int count=0;
	    int maxCount=0,i=0,j=0;
	    while(i<n && j<n)
	    {
	    	if(arr[i]==arr[j])
	    	{
	    		count++;
	    		j++;
	    	}
	    	else
	    	{
	    	 //reset the counter
	    		count=0;
	    		i++;
	    	}
	    	maxCount=Math.max(maxCount, count);
	    }
		return maxCount;
	}

}
