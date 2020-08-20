package Array;

/**
 * 2020.4.16
 * Remove Duplicates from Sorted Array
 * Given a sorted array nums, remove the duplicates in-place such that each element appear only once and return the new length.
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 *
 * Given nums = [0,0,1,1,1,2,2,3,3,4],
 * Your function should return length = 5, with the first five elements of nums being modified to 0, 1, 2, 3, and 4 respectively.
 * It doesn't matter what values are set beyond the returned length.
 * 不仅返回个数，数组的前几个也要相应修改
 */
public class Solution26 {
    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        if(len == 0){ return 0;}
        int tmp = nums[0];
        int index = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == tmp){
                len--;
            }else {
                nums[index++] = nums[i];
                tmp = nums[i];
            }
        }
        return len;
    }
}
