package Dynamic_Programming;

/**
 * 2020.09.29
 * Best Time to Buy and Sell Stock
 * 只允许买卖一次
 *
 * 状态转移方程
 * dp[i][k][0] = max(dp[i-1][k][0], dp[i-1][k][1] + prices[i]) 选择rest 选择sell
 * dp[i][k][1] = max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i]) 选择rest 选择buy
 * dp[3][2][1] 的含义就是：今天是第三天，我现在手上持有着股票，至今最多进行了 2 次交易。
 * base cases
 * dp[-1][k][0] = 0
 * 解释：因为 i 是从 0 开始的，所以 i = -1 意味着还没有开始，这时候的利润当然是 0 。
 * dp[-1][k][1] = -infinity
 * 解释：还没开始的时候，是不可能持有股票的，用负无穷表示这种不可能。
 * dp[i][0][0] = 0
 * 解释：因为 k 是从 1 开始的，所以 k = 0 意味着根本不允许交易，这时候利润当然是 0 。
 * dp[i][0][1] = -infinity
 * 解释：不允许交易的情况下，是不可能持有股票的，用负无穷表示这种不可能。
 */
public class Solution121 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0){
            return 0;
        }
        int[][] dp = new int[prices.length][2];
        for (int i = 0; i < prices.length; i++){
            if (i - 1 == -1){
                dp[i][0] = 0;
                // 解释：
                //   dp[i][0]
                // = max(dp[-1][0], dp[-1][1] + prices[i])
                // = max(0, -infinity + prices[i]) = 0
                dp[i][1] = -prices[i];
                //解释：
                //   dp[i][1]
                // = max(dp[-1][1], dp[-1][0] - prices[i])
                // = max(-infinity, 0 - prices[i])
                // = -prices[i]
                continue;
            }
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]); // 没持有保持 和 持有了卖出
            dp[i][1] = Math.max(dp[i-1][1], -prices[i]); // 继续持有
        }
        return dp[prices.length-1][0];
    }
}
