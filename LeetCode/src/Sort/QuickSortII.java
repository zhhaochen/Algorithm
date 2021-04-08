package Sort;

import java.util.Arrays;

public class QuickSortII {
    public void quickSort(int[] nums){
        quickSort(nums, 0, nums.length - 1);
    }

    private void quickSort(int[] nums, int left, int right){
        if (left >= right) return;
        int k = partition(nums, left, right);
        quickSort(nums, left, k - 1);
        quickSort(nums, k + 1, right);
    }

    private int partition(int[] nums, int left, int right){
        int tmp = nums[left];
        int index = left;
        for (int i = left + 1; i <= right; i++){
            if (nums[i] <= tmp){
                nums[index++] = nums[i];
                nums[i] = nums[index];
            }
        }
        nums[index] = tmp;
        return index;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 1, 1};
        new QuickSortII().quickSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
