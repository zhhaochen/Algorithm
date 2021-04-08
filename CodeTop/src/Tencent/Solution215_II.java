package Tencent;

// 基于堆排序的解法
public class Solution215_II {
    public int findKthLargest(int[] nums, int k) {
        // 建立堆，自底向上建立大顶堆
        for (int i = nums.length / 2 - 1; i >= 0; i--) {
            adjustHeap(nums, i, nums.length - 1);
        }
        // 排序
        for (int i = 0; i < k; i++){
            swap(nums, 0, nums.length - 1 - i);
            adjustHeap(nums, 0, nums.length - 2 - i);
        }
        return nums[nums.length - k];
    }

    public void adjustHeap(int[] nums, int start, int end) {
        int flag = nums[start];
        for (int k = start * 2 + 1; k <= end; k = 2 * k + 1) {
            if (k + 1 <= end && nums[k] < nums[k + 1]) k++;
            if (nums[k] > flag) {
                nums[start] = nums[k];
                start = k;
            }else break;
        }
        nums[start] = flag;
    }

    public void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,3,1,2,4,5,5,6};
        int res = new Solution215_II().findKthLargest(nums, 4);
        System.out.println(res);
    }
}
