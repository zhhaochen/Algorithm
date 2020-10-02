package Dynamic_Programming;

/**
 * 2020.10.02
 * House Robber II
 * 抢劫问题，此时房子是环形的
 * 相当于三种情况：
 * 1、首尾都不抢
 * 2、抢首不抢尾
 * 3、抢尾不抢首
 * 其实比较首尾两种情况即可
 */
public class Solution213 {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        if (nums.length == 1){
            return nums[0];
        }
        return Math.max(rob(nums, 0, nums.length - 1), rob(nums, 1, nums.length));
    }

    public int rob(int[] nums, int start, int end){
        int dp_i_1 = 0;
        int dp_i_2 = 0;
        int res = 0;
        for (int i = start; i < end; i++){
            res = Math.max(dp_i_1, dp_i_2 + nums[i]);
            dp_i_2 = dp_i_1;
            dp_i_1 = res;
        }
        return res;
    }
}
