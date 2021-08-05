package DynamicProgramming;

public class Solution1567 {
    public int getMaxLen(int[] nums) {
        int len = nums.length;
        if(len == 0) return 0;
        int[][] dp = new int[2][len];
        dp[0][0] = nums[0] > 0 ? 1 : 0;
        dp[1][0] = nums[0] < 0 ? 1 : 0;
        int max = dp[0][0];
        for(int i = 1; i < len; i++){
            if(nums[i] > 0){
                dp[0][i] = dp[0][i-1] + 1;
                dp[1][i] = dp[1][i-1] > 0 ? dp[1][i-1] + 1 : 0;
            }else if(nums[i] < 0){
                dp[0][i] = dp[1][i-1] > 0 ? dp[1][i-1] + 1 : 0;
                dp[1][i] = dp[0][i-1] + 1;
            }else{
                dp[0][i] = 0;
                dp[1][i] = 0;
            }
            max = Math.max(max, dp[0][i]);
        }
        return max;
    }
}
