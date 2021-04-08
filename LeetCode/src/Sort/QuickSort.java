package Sort;

import java.util.Arrays;

public class QuickSort {
    public void quickSort(int[] nums){
        quickSort(nums, 0, nums.length - 1);
    }

    private void quickSort(int[] nums, int left, int right){
        if (left >= right) return;
        int l = left, r = right;
        int start = nums[left];
        while (l < r){
            while (l < r && nums[r] > start) r--;
            while (l < r && nums[l] <= start) l++;
            swap(nums, l, r);
        }
        swap(nums, left, l);
        quickSort(nums, left, l - 1);
        quickSort(nums, l + 1, right);
    }

    private void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 1, 1};
        new QuickSort().quickSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
