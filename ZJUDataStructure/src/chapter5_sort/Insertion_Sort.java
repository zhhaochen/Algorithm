package chapter5_sort;

import java.util.Arrays;

public class Insertion_Sort {
    public static void main(String[] args) {
        int[] nums = new int[]{5, 7, 1, 8, 4, 0, 8};
        insertionSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    //模拟打牌时如何排序
    //好On 坏On^2
    public static void insertionSort(int[] nums){
        int n = nums.length;
        for (int p = 1; p<n; p++){
            int tmp = nums[p];
            int i = p;
            for (; i>0&&nums[i-1] > tmp; i--){
                nums[i] = nums[i-1];
            }
            nums[i] = tmp;
        }
    }
}
