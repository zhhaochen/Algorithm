package DynamicProgramming;

public class Solution918 {
    public int maxSubarraySumCircular(int[] nums) {
        int cur = nums[0];
        int max = nums[0];
        int sum = nums[0];
        for (int i = 1; i < nums.length; i++){
            sum += nums[i];
            cur = nums[i] + Math.max(cur, 0);
            max = Math.max(max, cur);
        }

        int min = 0;
        cur = nums[0];
        for (int i = 1; i < nums.length - 1; i++){
            cur = nums[i] + Math.min(cur, 0);
            min = Math.min(min, cur);
        }
        return Math.max(sum - min, max);
    }
}
