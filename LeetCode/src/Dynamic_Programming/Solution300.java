package Dynamic_Programming;

/**
 * 2020.10.6
 * Longest Increasing Subsequence
 * Input: [10,9,2,5,3,7,101,18]
 * Output: 4
 * Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
 */
public class Solution300 {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        // dp[i][j]代表数组nums[i,...,j]中最长升序列的长度，返回应该为dp中最大的值
        int[] dp = new int[len];
        int max = 1;
        // 状态转移，从后往前
        for (int i = 1; i < len; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            if (dp[i] > max) max = dp[i];
        }
        return max;
    }
}
