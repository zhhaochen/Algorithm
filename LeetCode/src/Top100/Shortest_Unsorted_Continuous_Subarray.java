package Top100;

import java.util.Arrays;

/**
 * 2020.09.05
 * 从数组中找到一个最小的子串，排序后使得整个数组排序正确，输出长度
 * Input: [2, 6, 4, 8, 10, 9, 15]
 * Output: 5
 * Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.
 */
public class Shortest_Unsorted_Continuous_Subarray {
    // 解法1，确定子序列的开头结尾，通过不断比较
    public int findUnsortedSubarray1(int[] nums) {
        int len = nums.length;
        if (len == 0 || len == 1) {
            return 0;
        }
        int start = len;
        int end = len - 1;
        for (int i = 1; i < len; i++) {
            if (nums[i] < nums[i - 1]) {
                for (int j = 0; j < i; j++) {
                    if (nums[j] > nums[i]) {
                        // 开头与结尾的更新
                        end = i;
                        start = Math.min(j, start);
                        int tmp = nums[j];
                        nums[j] = nums[i];
                        nums[i] = tmp;
                    }
                }
            }
        }
        return end - start + 1;
    }
    // 解法2：先排序后比较
    public int findUnsortedSubarray2(int[] nums) {
        int[] arr_copy = Arrays.copyOf(nums, nums.length);
        Arrays.sort(arr_copy);
        int len = nums.length;
        int start = 0;
        int end = len - 1;
        while (start < len && nums[start] == arr_copy[start]){
            start++;
        }
        while (end > start && nums[end] == arr_copy[end]){
            end--;
        }
        return end - start + 1;
    }
    // 解法3：神仙解法
    public int findUnsortedSubarray3(int[] nums){
        int len = nums.length;
        if(len ==0 || len == 1){
            return 0;
        }
        int start = -1;
        int end = -2;
        int min = nums[len-1];
        int max = nums[0];
        for(int i = 1; i<len; i++){
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[len-i-1]);
            if(max > nums[i]){
                end = i;
            }
            if(min < nums[len-i-1]){
                start = len-i-1;
            }
        }
        return end - start + 1;
    }
}
