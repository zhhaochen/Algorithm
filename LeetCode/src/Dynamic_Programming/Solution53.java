package Dynamic_Programming;

/**
 * 2020.10.7
 * Maximum Subarray
 * Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 */
public class Solution53 {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        int len = nums.length;
        // 以 nums[i] 为结尾的「最大子数组和」为 dp[i]。因为子数组一定是连续的
        int[] dp = new int[len];
        dp[0] = nums[0];
        int max = nums[0];
        for (int i = 1; i < len; i++){
            // 要么自成一派，要么和前面的子数组合并
            dp[i] = Math.max(nums[i], nums[i] + dp[i-1]);
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
