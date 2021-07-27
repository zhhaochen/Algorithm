package JianZhiOffer;

public class Solution47 {
    public int maxValue(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        dp[0][0] = grid[0][0];
        for (int i = 0; i < dp[0].length; i++){
            for (int j = 0; j < dp.length; j++){
                if (i == 0 && j != 0) dp[i][j] = grid[i][j] + dp[i][j - 1];
                else if (i != 0 && j == 0) dp[i][j] = grid[i][j] + dp[i - 1][j];
                else if (i > 0)dp[i][j] = grid[i][j] + Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }
        return dp[dp.length - 1][dp[0].length - 1];
    }
}
