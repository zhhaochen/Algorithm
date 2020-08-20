package Array;

import java.util.Arrays;

/**
 * 2019.10.8
 * Duplicate Zeros
 * <p>
 * Given a fixed length array arr of integers, duplicate each occurrence of zero, shifting the remaining elements to the right.
 * Note that elements beyond the length of the original array are not written.
 * Do the above modifications to the input array in place, do not return anything from your function.
 * <p>
 * Input: [1,0,2,3,0,4,5,0]
 * Output: null
 * Explanation: After calling your function, the input array is modified to: [1,0,0,2,3,0,0,4]
 */
public class Solution1089 {
    public static void main(String[] args) {
        int[] arr = new int[]{0, 0, 0, 0, 0, 0, 0};
        duplicateZeros(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void duplicateZeros(int[] arr) {
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            if (arr[i] == 0) {
                for (int j = len - 1; j > i + 1; j--) {
                    arr[j] = arr[j - 1];
                }
                if (i<len-1){
                    arr[i + 1] = 0;
                    i++; // 多加一次
                }
            }
        }
    }
}
