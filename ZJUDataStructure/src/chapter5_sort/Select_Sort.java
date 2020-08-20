package chapter5_sort;

import java.util.Arrays;

public class Select_Sort {
    public static void main(String[] args) {
        int[] nums = new int[]{5, 7, 1, 8, 4, 0, 8};
        selectSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void selectSort(int[] nums){
        int n = nums.length;
        for (int i=0; i<n-1; i++){
            //找到最小位置
            int min = i;
            for (int j = i+1; j<n; j++){
                if (nums[j] < nums[min]){
                    min = j;
                }
            }
            int tmp = nums[min];
            nums[min] = nums[i];
            nums[i] = tmp;
        }
    }
}
