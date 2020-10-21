package Top100;

/**
 * 2020.10.21
 * You are given a list of non-negative integers, a1, a2, ..., an, and a target, S. Now you have 2 symbols + and -. For each integer, you should choose one from + and - as its new symbol.
 * Find out how many ways to assign symbols to make sum of integers equal to target S.
 * Input: nums is [1, 1, 1, 1, 1], S is 3.
 * Output: 5
 * Explanation:
 * -1+1+1+1+1 = 3
 * +1-1+1+1+1 = 3
 * +1+1-1+1+1 = 3
 * +1+1+1-1+1 = 3
 * +1+1+1+1-1 = 3
 * There are 5 ways to assign symbols to make the sum of nums be target 3.
 */

public class Target_Sum {
    // sum(P) - sum(N) = S
    // sum(P) + sum(N) + sum(P) - sum(N) = S + sum(All)
    // 2sum(P) = sum(All) + S
    // sum(P) = (sum(All) + S) / 2
    public int findTargetSumWays(int[] nums, int S) {
        int sum  = 0;
        for (int num : nums){
            sum += num;
        }
        if ((sum + S) % 2 != 0 || sum < S){
            return 0;
        }
        sum = (sum + S) / 2;
        return findTarget(nums, sum);
    }
    public int findTarget(int[] nums, int sum){
        // dp[i] 代表凑到 i 的方法有多少种
        int[] dp = new int[sum + 1];
        dp[0] = 1;
        // 对每一个当前的值
        for (int n : nums) {
            for (int j = sum; j >= n; j--)
                // 计算某个值加上 n 得到 j 的方法有几种
                dp[j] += dp[j - n];
        }
        return dp[sum];
    }
}
