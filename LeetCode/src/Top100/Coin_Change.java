package Top100;

/**
 * 给定不同面额的硬币 coins 和一个总金额 amount。
 * 编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回-1。
 * Input: coins = [1,2,5], amount = 11
 * Output: 3
 * Explanation: 11 = 5 + 5 + 1
 *
 * 动态规划的解题框架
 * https://labuladong.gitbook.io/algo/di-ling-zhang-bi-du-xi-lie/dong-tai-gui-hua-xiang-jie-jin-jie
 */
public class Coin_Change {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        dp[0] = 0;
        for(int i = 1; i <= amount; i++){
            dp[i] = amount+1;
        }
        for(int i = 1; i <= amount; i++){
            for(int j = 0; j < coins.length; j++){
                if(i - coins[j] < 0){
                    continue;
                }
                dp[i] = Math.min(dp[i], 1 + dp[i - coins[j]]);
            }
        }
        return dp[amount] == amount + 1? -1 : dp[amount];
    }
}
