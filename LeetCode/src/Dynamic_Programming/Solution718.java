package Dynamic_Programming;

public class Solution718 {
    public int findLength(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        int max = 0;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++){
            for (int j = 1; j <= n; j++){
                if (A[i] == B[j]) dp[i][j] = dp[i-1][j-1] + 1;
                else dp[i][j] = 0;
                max = Math.max(max, dp[i][j]);
            }
        }
        return dp[m][n];
    }
}
