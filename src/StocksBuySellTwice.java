import java.util.ArrayList;
import java.util.List;

public class StocksBuySellTwice {

	public static void main(String[] args) {
		 int[] stocks={310,315,275,295,260,270,290,230,255,250};
		 int[] stocks1={12,11,13,9,12,8,14,13,15};
	     System.out.println(computeMaxProfit(stocks));
	     System.out.println(maxProfit(stocks1));
	}
    /*O(n) solution and O(n) space*/
	private static double computeMaxProfit(int[] stocks) {
		double maxTotalProfit=0.0;
		int minPrice=Integer.MAX_VALUE;
		List<Double> firstBuySellProfits=new ArrayList<>();
		for(int price:stocks)
		{
			minPrice=Math.min(minPrice,price);
			maxTotalProfit=Math.max(maxTotalProfit, price-minPrice);
			firstBuySellProfits.add(maxTotalProfit);
		}
		double maxPrice=Double.MIN_VALUE;
		for(int i=stocks.length-1;i>0;--i)
		{
			maxPrice=Math.max(maxPrice, stocks[i]);
			maxTotalProfit=Math.max(maxTotalProfit, maxPrice-stocks[i]+firstBuySellProfits.get(i-1));
		}
		return maxTotalProfit;
	}
	/*O(n) solution and O(1) space*/
	private static int maxProfit(int[] prices) {
		int sell1 = 0, sell2 = 0, buy1 = Integer.MIN_VALUE, buy2 = Integer.MIN_VALUE;
		for (int i = 0; i < prices.length; i++) {
			buy1 = Math.max(buy1, -prices[i]);
			System.out.print(buy1+" ");
			sell1 = Math.max(sell1, buy1 + prices[i]);
			System.out.print(sell1+" ");
			buy2 = Math.max(buy2, sell1 - prices[i]);
			System.out.print(buy2+" ");
			sell2 = Math.max(sell2, buy2 + prices[i]);
			System.out.print(sell2);
			System.out.println();
		}
		return sell2;
	}

}
