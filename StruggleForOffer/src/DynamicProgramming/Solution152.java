package DynamicProgramming;

public class Solution152 {
    public int maxProduct(int[] nums) {
        int len = nums.length;
        if(len == 0) return 0;
        int[][] dp = new int[2][len];
        dp[0][0] = nums[0]; dp[1][0] = nums[0];
        int max = nums[0];
        for(int i = 1; i < len; i++){
            // 最大值
            dp[0][i] = Math.max(nums[i], Math.max(nums[i] * dp[0][i-1], nums[i] * dp[1][i-1]));
            // 最小值
            dp[1][i] = Math.min(nums[i], Math.min(nums[i] * dp[0][i-1], nums[i] * dp[1][i-1]));
            max = Math.max(dp[0][i], max);
        }
        return max;
    }
}
