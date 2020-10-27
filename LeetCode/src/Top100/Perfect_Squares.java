package Top100;

/**
 * 2020.10.27
 * Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.
 * Input: n = 12
 * Output: 3
 * Explanation: 12 = 4 + 4 + 4.
 * Input: n = 13
 * Output: 2
 * Explanation: 13 = 4 + 9.
 */
public class Perfect_Squares {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        // dp[i]表示组成 i 需要的平方数的最少个数
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            // 最大肯定是 i 个 1
            dp[i] = i;
            // j用于记录平方 1, 4, 9, 16, ...
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i - j * j] + 1, dp[i]);
            }
        }
        return dp[n];
    }
}
