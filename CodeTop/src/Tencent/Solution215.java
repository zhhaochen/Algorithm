package Tencent;

// 基于快排的解法
public class Solution215 {
    public int findKthLargest(int[] nums, int k) {
        return quickSort(nums, 0, nums.length - 1, k - 1);
    }

    public int quickSort(int[] nums, int left, int right, int k){
        int index = partition(nums, left, right);
        if (index == k) return nums[k];
        else if (index > k) return quickSort(nums, left, index - 1, k);
        else return quickSort(nums, index + 1, right, k);
    }

    public int partition(int[] nums, int start, int end){
        int flag = nums[start];
        for (int i = start + 1; i <= end; i++){
            if (nums[i] >= flag){
                nums[start++] = nums[i];
                nums[i] = nums[start];
            }
        }
        nums[start] = flag;
        return start;
    }
}
