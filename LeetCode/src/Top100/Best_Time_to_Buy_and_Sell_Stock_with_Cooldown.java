package Top100;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times) with the following restrictions:
 * You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 * After you sell your stock, you cannot buy stock on next day. (ie, cooldown 1 day)
 *
 * Input: [1,2,3,0,2]
 * Output: 3
 * Explanation: transactions = [buy, sell, cooldown, buy, sell]
 */
public class Best_Time_to_Buy_and_Sell_Stock_with_Cooldown {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0 || prices.length == 1){
            return 0;
        }
        int n = prices.length;
        // dp[i][0]表示第i天手中没有股票；dp[i][1]表示第i天手中有股票
        int[][] dp = new int[n+1][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        // 因为涉及到i-2，所以这里也初始化了一下
        dp[1][0] = 0;
        dp[1][1] = -prices[0];
        for (int i = 2; i <= n; i++){
            // 今天没有股票，要么昨天没有，要么今天卖了
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i - 1]);
            // 今天有了股票，要么昨天就有，要么今天买了，如果昨天没有，应该看前天是否本来就没有
            dp[i][1] = Math.max(dp[i-1][1], dp[i-2][0] - prices[i - 1]);
        }
        return dp[n][0];
    }
}
