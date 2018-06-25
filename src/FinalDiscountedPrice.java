
public class FinalDiscountedPrice {

	public static void main(String[] args) {
		int[] prices={1,3,3,2,5};
		System.out.println(finalDiscountedPrice(prices));
	}

	private static int finalDiscountedPrice(int[] prices) {
		int finalPrice=0;
		for(int i=0;i<prices.length;i++){
		 boolean found=false; 
		 for(int j=i+1;j<prices.length;j++){
		  if(prices[i]>prices[j]){
			  found=true;
			  finalPrice+=prices[i]-prices[j];
			  System.out.println(prices[i]-prices[j]);
			  break;
		  }
		 }
		 if(!found){
			 finalPrice+=prices[i];
			 System.out.println(prices[i]);
		 }
		}
		return finalPrice;
	}
}
