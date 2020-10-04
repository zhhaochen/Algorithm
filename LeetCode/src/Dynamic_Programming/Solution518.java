package Dynamic_Programming;

/**
 * 2020.10.04
 * Coin Change 2
 * You are given coins of different denominations and a total amount of money.
 * Write a function to compute the number of combinations that make up that amount.
 * You may assume that you have infinite number of each kind of coin.
 * Input: amount = 5, coins = [1, 2, 5]
 * Output: 4
 * Explanation: there are four ways to make up the amount:
 * 5=5
 * 5=2+2+1
 * 5=2+1+1+1
 * 5=1+1+1+1+1
 */
public class Solution518 {
    public int change(int amount, int[] coins) {
        // dp[i][j] 只使用 coins 中的前 i 个硬币的面值，若想凑出金额 j，有 dp[i][j] 种凑法。
        int[][] dp = new int[coins.length + 1][amount+1];
        for (int i = 0; i <= coins.length; i++){
            dp[i][0] = 1;
        }
        for (int i = 1; i <= amount; i++){
            for (int j = 1; j <= coins.length; j++){
                // 不用当前的硬币
                if (i - coins[j-1] < 0){
                    dp[j][i] = dp[j-1][i];
                }else {
                    // 当前的硬币能凑够时，可以用或不用
                    dp[j][i] = dp[j-1][i] + dp[j][i - coins[j-1]];
                }
            }
        }
        return dp[coins.length][amount];
    }
}
