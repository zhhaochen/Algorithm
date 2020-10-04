package Top100;

/**
 * 2020.10.04
 * Given a non-empty array containing only positive integers,
 * find if the array can be partitioned into two subsets such that the sum of elements in both subsets is equal.
 * Input: [1, 5, 11, 5]
 * Output: true
 * Explanation: The array can be partitioned as [1, 5, 5] and [11].
 * 本质是一个背包问题
 */
public class Partition_Equal_Subset_Sum {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums){
            sum += num;
        }
        if (sum % 2 == 1){
            return false;
        }
        sum /= 2;
        // 相当于一个求sum/2容量的背包问题
        boolean[][] dp = new boolean[nums.length + 1][sum + 1];
        for (int i = 0; i <= nums.length; i++)
            dp[i][0] = true;
        // dp[i][j] 表示在容量j的情况下，前i个物品能否装满背包
        // 注意i的索引，从1开始，所以读数组时需要取i-1
        for (int i = 1; i <= nums.length; i++){
            for (int j = 1; j <= sum; j++){
                if (j - nums[i-1] < 0){
                    // 装不下，继承上一个状态
                    dp[i][j] = dp[i-1][j];
                }else {
                    // 装的下，装或者不装
                    dp[i][j] = dp[i-1][j] || dp[i-1][j - nums[i-1]];
                }
            }
        }
        return dp[nums.length][sum];
    }
}
