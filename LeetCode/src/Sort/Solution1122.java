package Sort;

import java.util.Arrays;

/**
 * 2019.10.1
 * Relative Sort Array
 *
 * Given two arrays arr1 and arr2, the elements of arr2 are distinct, and all elements in arr2 are also in arr1.
 * Sort the elements of arr1 such that the relative ordering of items in arr1 are the same as in arr2.
 * Elements that don't appear in arr2 should be placed at the end of arr1 in ascending order.
 *
 * Input: arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
 * Output: [2,2,2,1,4,3,3,9,6,7,19]
 */
public class Solution1122 {
    public static void main(String[] args) {
        int[] arr1 = new int[]{1, 2, 2, 3, 6, 1, 5, 9, 2};
        int[] arr2 = new int[]{1, 9, 2};
        int[] res = relativeSortArray(arr1, arr2);
        System.out.println(Arrays.toString(res));
    }
    public static int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] res = new int[arr1.length];
        Arrays.sort(arr1);
        int index = 0;
        for(int i=0; i<arr2.length; i++){
            for(int j = 0; j<arr1.length; j++){
                if (arr1[j] == arr2[i])
                    res[index++] = arr1[j];
            }
        }
        for (int i = 0; i<arr1.length; i++) {
            boolean flag = true;
            for (int j = 0; j < arr2.length; j++) {
                if (arr1[i] == arr2[j])
                    flag = false;
                continue;
            }
            if (flag)
                res[index++] = arr1[i];
        }
        return res;
    }
}
