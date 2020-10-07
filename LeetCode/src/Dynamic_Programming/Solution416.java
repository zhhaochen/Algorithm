package Dynamic_Programming;

/**
 * 2020.10.7
 * Partition Equal Subset Sum
 * Given a non-empty array containing only positive integers,
 * find if the array can be partitioned into two subsets such that the sum of elements in both subsets is equal.
 * Input: [1, 5, 11, 5]
 * Output: true
 * Explanation: The array can be partitioned as [1, 5, 5] and [11].
 */
public class Solution416 {
    public boolean canPartition(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length == 1){
            return false;
        }
        int sum = 0;
        for (int num : nums){
            sum += num;
        }
        if (sum % 2 == 1){
            return false;
        }
        sum /= 2;
        int len = nums.length;
        // 相当于一个求sum/2容量的背包问题
        // dp[i][j] 表示在容量j的情况下，前i个物品能否装满背包
        boolean[][] dp = new boolean[len + 1][sum + 1];
        for (int i = 0; i <= nums.length; i++)
            dp[i][0] = true;
        for (int i = 1; i <= len; i++){
            for (int j = 1; j <= sum; j++){
                if (nums[i - 1] > j){
                    // 装不下，继承上一个状态
                    dp[i][j] = dp[i-1][j];
                }else {
                    // 装得下，选择装或者不装
                    dp[i][j] = dp[i-1][j] || dp[i-1][j - nums[i - 1]];
                }
            }
        }
        return dp[len][sum];
    }
}
