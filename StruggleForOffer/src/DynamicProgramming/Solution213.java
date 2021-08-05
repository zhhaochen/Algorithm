package DynamicProgramming;

public class Solution213 {
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        return Math.max(rob(nums, 0, nums.length - 2), rob(nums, 1, nums.length - 1));
    }

    private int rob(int[] nums, int i, int j){
        if(i > j) return 0;
        if(i == j) return nums[i];
        int[] dp = new int[j - i + 1];
        dp[0] = nums[i];
        dp[1] = Math.max(nums[i], nums[i + 1]);
        for(int k = 2; k < dp.length; k++){
            dp[k] = Math.max(dp[k - 2] + nums[i + k], dp[k - 1]);
        }
        return dp[j - i];
    }
}
