package Dynamic_Programming;

/**
 * 2020.10.02
 * House Robber
 * 给定一个代表每个房屋存放金额的非负整数数组，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警
 * 计算你不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
 */
public class Solution198 {
    public int rob_dp(int[] nums){
        if (nums == null || nums.length == 0){
            return 0;
        }
        int[] dp = new int[nums.length + 2];
        for (int i = 0; i < nums.length; i++){
            dp[i + 2] = Math.max(dp[i + 1], nums[i] + dp[i]);
        }
        return dp[nums.length  + 1];
    }
    public int rob_simple(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int dp_i_1 = 0;
        int dp_i_2 = 0;
        int res = 0;
        for(int i = 0; i < nums.length; i++){
            res = Math.max(dp_i_1, nums[i] + dp_i_2);
            dp_i_2 = dp_i_1;
            dp_i_1 = res;
        }
        return res;
    }
}
