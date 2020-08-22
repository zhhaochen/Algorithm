package Challenge_30_Day.May.week3;

/**
 * Given an array nums of n integers where n > 1,
 * return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].
 * Input:  [1,2,3,4]
 * Output: [24,12,8,6]
 * Note: Please solve it without division and in O(n).不能用除法
 * Could you solve it with constant space complexity? (The output array does not count as extra space for the purpose of space complexity analysis.)
 * 用除了输出数组之外的O(1)空间复杂度
 */
public class Product_of_Array_Except_Self {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] result = new int[len];
        int left = 1; //将左边数组简化为一个值
        int[] right = new int[len]; //这个应该也可以简化
        right[len-1] = 1;
        for (int i=1; i<len; i++){
            right[len-i-1] = right[len-i] * nums[len-i];
        }
        for (int i = 0; i < len; i++) {
            result[i] = left * right[i];
            left *= nums[i];
        }
        return result;
    }

    //实现O(1)空间复杂度
    public int[] productExceptSelf2(int[] nums) {
        int len = nums.length;
        int[] result = new int[len];
        int right = 1;
        result[0] = 1;
        for (int i = 1; i < len; i++) {
            result[i] = result[i-1] * nums[i-1];
        }
        for (int i = 0; i < len; i++) {
            result[len-i-1] *= right;
            right *= nums[len-i-1];
        }
        return result;
    }
}
