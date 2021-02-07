package Sort;

import java.util.Arrays;

// 时间 O(nlogn) O(n^2) 空间 O(nlogn)
public class QuickSort2 {

    public void quickSort(int[] nums){
        quickSort(nums, 0, nums.length -1);
    }

    public void quickSort(int[] nums, int i, int j){
        if (i >= j) return;
        int index = partition(nums, i, j);
        quickSort(nums, i, index - 1);
        quickSort(nums, index + 1, j);
    }

    private int partition(int[] nums, int start, int end){
        int flag = nums[start];
        int index = start;
        for(int i = start + 1; i <= end; i++){
            if(nums[i] < flag){
                nums[index++] = nums[i];
                nums[i] = nums[index];
            }
        }
        nums[index] = flag;
        return index;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 9, 2, 4, 5, 3, 1, 7};
        new QuickSort2().quickSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
