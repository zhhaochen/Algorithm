package Tencent;

public class Solution213 {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        return Math.max(rob(nums, 0, nums.length - 2), rob(nums, 1, nums.length - 1));
    }

    public int rob(int[] nums, int start, int end){
        int[] dp = new int[end - start + 2];
        dp[1] = nums[start];
        for (int i = start + 1; i <= end; i++){
            dp[i - start + 1] = Math.max(dp[i - start - 1] + nums[i], dp[i - start]);
        }
        return dp[end - start + 1];
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 2};
        new Solution213().rob(nums);
    }
}
