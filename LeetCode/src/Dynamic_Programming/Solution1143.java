package Dynamic_Programming;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;

public class Solution1143 {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m+1][n+1];
        for (int i = 1; i <= m; i++){
            for (int j = 1; j <= n; j++){
                int left_top = dp[i-1][j-1];
                if (text1.charAt(i-1) == text2.charAt(j-1)) left_top++;
                dp[i][j] = Math.max(left_top, Math.max(dp[i-1][j], dp[i][j-1]));
            }
        }
        return dp[m][n];
    }
}
