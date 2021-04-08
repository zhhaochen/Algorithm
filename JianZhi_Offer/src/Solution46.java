public class Solution46 {
    public int translateNum(int num) {
        char[] nums = (num + "").toCharArray();
        int[] dp = new int[nums.length + 1];
        dp[0] = 0; dp[1] = 1;
        for (int i = 1; i < nums.length; i++){
            if (nums[i - 1] == '1') dp[i+1] = dp[i] + dp[i-1];
            else if(nums[i-1] == '2' && nums[i] < '6') dp[i+1] = dp[i] + dp[i-1];
            else dp[i+1] = dp[i];
        }
        return dp[nums.length];
    }
}
