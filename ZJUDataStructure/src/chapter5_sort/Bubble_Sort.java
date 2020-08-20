package chapter5_sort;

import java.util.Arrays;

public class Bubble_Sort {

    public static void main(String[] args) {
        int[] nums = new int[]{5, 7, 1, 8, 4, 0, 8};
        bubbleSort(nums);
        System.out.println(Arrays.toString(nums));
    }
    //好：On    差：On^2
    public static void bubbleSort(int[] nums){
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int flag = 1;
            for (int j = 1; j<n-i; j++){
                if (nums[j-1] > nums[j]){
                    flag = 0;
                    int tmp = nums[j];
                    nums[j] = nums[j-1];
                    nums[j-1] = tmp;
                }
            }
            if (flag == 1){ //说明全程无交换，已经排好序
                break;
            }
        }
    }
}
