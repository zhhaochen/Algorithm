package Dynamic_Programming;

public class Solution377 {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        // 对每个容量，判断之前能否占满
        for (int i = 1; i <= target; i++){
            for (int num : nums){
                if (i - num >= 0) dp[i] += dp[i-num];
            }
        }
        return dp[target];
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        int res = new Solution377().combinationSum4(nums, 4);
    }
}
