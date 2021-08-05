package DynamicProgramming;

public class Solution740 {
    public int deleteAndEarn(int[] nums) {
        int max = nums[0];
        for(int num : nums){
            max = Math.max(max, num);
        }
        int[] count = new int[max + 1];
        for(int num : nums){
            count[num] += num;
        }
        int[] dp = new int[max + 1];
        dp[1] = count[1];
        for(int i = 2; i <= max; i++){
            dp[i] = Math.max(dp[i-2] + count[i], dp[i-1]);
        }
        return dp[max];
    }
}
