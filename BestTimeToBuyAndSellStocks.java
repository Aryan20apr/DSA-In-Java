/*You are given an ard prices where prices[i] is the price of a given stock on the ith d.

Find the maximum profit you can achieve. You d complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times) with the following restrictions:

After you sell your stock, you cannot buy stock on the next d (i.e., cooldown one d).
Note: You d not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).*/
import java.util.Arrays;
public class BestTimeToBuyAndSellStocks {


    
    public static void main(String[] args)
    {
        int price[]={1,2,3,0,2};
        //int prices[]={1,2,4};
        BestTimeToBuyAndSellStocks b=new BestTimeToBuyAndSellStocks();
        int max=b.maxProfit(price);
        System.out.println("Max Profit is="+max);

    }
    public int maxProfit(int[] price) {
        int dp[][] = new int[price.length][2];
        for(int i = 0; i < price.length; i++)
            Arrays.fill(dp[i], -1);
        
        return maxProfit(price, 0, 0, dp);
    }
    
    public int maxProfit(int[] prices, int day, int bought, int[][] dp) {
        if(day >= prices.length)
            return 0;
        
        if(dp[day][bought] != -1)
            return dp[day][bought];
        
        if(bought == 0) { // buy
            return dp[day][bought] = Math.max(maxProfit(prices, day + 1, 1, dp) - prices[day], maxProfit(prices, day + 1, bought, dp));
        }
        else { // sell
            return dp[day][bought] = Math.max(prices[day] + maxProfit(prices, day + 2, 0, dp), maxProfit(prices, day + 1, bought, dp));
        }
    }
}
