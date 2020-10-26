package Top100;

/**
 * 2020.10.27
 * Given an integer array nums,
 * find the contiguous subarray within an array (containing at least one number)
 * which has the largest product.
 * Input: [2,3,-2,4]
 * Output: 6
 * Explanation: [2,3] has the largest product 6.
 */
public class Maximum_Product_Subarray {
    public int maxProduct(int[] nums) {
        // dp_[i]表示必须包括num[i]的子数组乘积
        int[] dp_max = new int[nums.length];
        int[] dp_min = new int[nums.length];
        dp_min[0] = nums[0];
        dp_max[0] = nums[0];
        int res = nums[0];
        for (int i = 1; i < nums.length; i++){
            dp_max[i] = Math.max(dp_max[i-1] * nums[i], Math.max(dp_min[i-1] * nums[i], nums[i]));
            dp_min[i] = Math.min(dp_max[i-1] * nums[i], Math.min(dp_min[i-1] * nums[i], nums[i]));
            res = dp_max[i] > res ? dp_max[i] : res;
        }
        return res;
    }
}
