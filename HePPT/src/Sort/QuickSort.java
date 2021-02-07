package Sort;

import java.util.Arrays;

// 时间 O(nlogn) O(n^2) 空间 O(nlogn)
public class QuickSort {

    public void quickSort(int[] nums){
        quickSort(nums, 0, nums.length -1);
    }

    public void quickSort(int[] nums, int i, int j){
        if (i >= j) return;
        int left = i, right = j;
        // 以开头值作为标准
        while (left < right){
            while (left < right && nums[right] >= nums[i]) right--;
            while (left < right && nums[left] <= nums[i]) left++;
            swap(nums, left, right);
        }
        /*
        最终 left = right
        1、如果是 right-- 得来，则原来的left本来指向的就是小于等于点
        2、如果是 left++ 得来，因为先判断right，则指向的依然是小点
         */
        swap(nums, i, left);
        quickSort(nums, i, left - 1);
        quickSort(nums, left + 1, j);
    }

    private void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
