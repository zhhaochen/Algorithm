package ByteDance;

import java.util.Arrays;

public class Solution312 {
    public int maxCoins(int[] nums) {
        int[] tmp = new int[nums.length + 2];
        tmp[0] = 1; tmp[tmp.length - 1] = 1;
        for (int i = 0; i < nums.length; i++) tmp[i + 1] = nums[i];
        // dp[i][j]表示在(i, j)开区间中戳完气球得到的最大利润
        int[][] dp = new int[tmp.length][tmp.length];
        // dp[i][j] = dp[i][k] + tmp[i] * tmp[k] * tmp[j] + dp[k][j]
        // 按照这个顺序，i行j列取决于i行k列和k行j列，i < k < j,应该从底向上，从左向右
        for (int i = tmp.length - 3; i >= 0; i--){
            for (int j = i + 2; j < tmp.length; j++){
                dp[i][j] = maxCoins(dp, i, j, tmp);
            }
        }
        return dp[0][tmp.length - 1];
    }

    private int maxCoins(int[][] dp, int i, int j, int[] tmp){
        int max = 0;
        for (int k = i + 1; k < j; k++){
            max = Math.max(max, dp[i][k] + tmp[i] * tmp[k] * tmp[j] + dp[k][j]);
        }
        return max;
    }
}
