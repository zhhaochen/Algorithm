package Dynamic_Programming;

/**
 * 2020.09.29
 * Best Time to Buy and Sell Stock II
 * 无限次买卖
 */
public class Solution122 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0){
            return 0;
        }
        int[][] dp = new int[prices.length][2];
        for (int i = 0; i < prices.length; i++){
            if (i - 1 < 0){
                dp[i][0] = 0;
                dp[i][1] = -prices[i];
                continue;
            }
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] - prices[i]);
        }
        return dp[prices.length-1][0];
    }
}
