package Top100;

/**
 * 2020.11.27
 * Given an unsorted integer array nums, find the smallest missing positive integer.
 * Follow up: Could you implement an algorithm that runs in O(n) time and uses constant extra space.?
 */
public class First_Missing_Positive {
    public int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; i++){
            // 如果超过长度，或者不为正数，或者与目标索引与值不同，需要交换
            // 三个条件很重要
            if (nums[i] <= nums.length && nums[i] > 0 && nums[nums[i] - 1] != nums[i]){
                int tmp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = tmp;
                i--;
            }
        }
        for (int i = 0; i < nums.length; i++){
            if (nums[i] != i+1){
                return i + 1;
            }
        }
        // 此时长度内包含所有数
        return nums.length + 1;
    }
}
