package CodeTop.YuanFuDao;

public class Solution215 {
    public int findKthLargest(int[] nums, int k) {
        quickSort(nums, k - 1, 0, nums.length - 1);
        return nums[k - 1];
    }

    private void quickSort(int[] nums, int k, int i, int j){
        if (i >= j) return;
        int flag = nums[i];
        int left = i, right = j;
        while (left < right){
            while (left < right && nums[right] <= flag) right--;
            while (left < right && nums[left] >= flag) left++;
            swap(nums, left, right);
        }
        swap(nums, i, left);
        if (left == k) return;
        else if (left < k) quickSort(nums, k, left + 1, j);
        else quickSort(nums, k, i, left - 1);
    }

    private void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
