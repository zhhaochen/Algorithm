package ByteDance;

public class Solution264 {
    public int nthUglyNumber(int n) {
        if(n <= 6) return n;
        int[] dp = new int[n];
        int index_2 = 0, index_3 = 0, index_5 = 0;
        dp[0] = 1;
        for (int i = 1; i < n; i++){
            dp[i] = Math.min(dp[index_2] * 2, Math.min(dp[index_3] * 3, dp[index_5] * 5));
            // 这里不能把所有判断在else if里，因为有可能出现重复，比如 2 * 3 和 3 * 2
            if (dp[i] == dp[index_2] * 2) index_2++;
            if (dp[i] == dp[index_3] * 3) index_3++;
            if (dp[i] == dp[index_5] * 5) index_5++;
        }
        return dp[n-1];
    }
}
