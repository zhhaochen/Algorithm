package Hot100;

public class Solution494 {
    int res = 0;
    public int findTargetSumWays(int[] nums, int S) {
        backtrack(nums, 0, S);
        return res;
    }

    public void backtrack(int[] nums, int index, int S){
        if (index >= nums.length){
            if (S == 0) res++;
            return;
        }
        backtrack(nums, index + 1, S - nums[index]);
        backtrack(nums, index + 1, S + nums[index]);
    }

    // 背包问题 动态规划
    public int findTargetSumWays2(int[] nums, int S){
        int sum = 0;
        for (int num : nums) sum += num;
        // x + y = sum x - y = S x = (sum + S) / 2 求组成x的方法有几种
        if (S > sum || (sum + S) % 2 == 1) return 0;
        int target = (sum + S) / 2;
        // 背包问题
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int num : nums){
            for (int j = target; j >= num; j--){
                dp[j] += dp[j - num];
            }
        }
        return dp[target];
    }
}
