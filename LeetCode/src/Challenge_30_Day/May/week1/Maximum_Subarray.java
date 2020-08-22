package Challenge_30_Day.May.week1;

/**
 * Given an integer array nums,
 * find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
 * Input: [-2,1,-3,4,-1,2,1,-5,4],
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 */
public class Maximum_Subarray {
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int thisSum = 0;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            thisSum += nums[i];
            if (thisSum > maxSum) {
                maxSum = thisSum;
            }
            if (thisSum < 0) { //如果全是负数，并且是递增的负数，这里单独if而不是else if很有必要
                thisSum = 0;
            }
        }
        return maxSum;
    }
}
