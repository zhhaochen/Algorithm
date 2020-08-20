package Bit_Manipulation;

/**
 * 2019.10.29
 * Maximum of Absolute Value Expression
 *
 * Given two arrays of integers with equal lengths, return the maximum value of:
 * |arr1[i] - arr1[j]| + |arr2[i] - arr2[j]| + |i - j|
 * where the maximum is taken over all 0 <= i, j < arr1.length.
 * Input: arr1 = [1,-2,-5,0,10], arr2 = [0,-2,-1,-7,-4]
 * Output: 20
 *
 * 2 <= arr1.length == arr2.length <= 40000
 * -10^6 <= arr1[i], arr2[i] <= 10^6
 *
 * 本题主要注意当数组长度过长时的超时问题
 */
public class Solution1131 {

    //实际上共八种情况，根据arr1[i]/arr2[i]、arr1[j]/arr2[j]、i/j两两大小比较化解，最后其实等价于就四种情况
    public int maxAbsValExpr(int[] arr1, int[] arr2) {
        int len = arr1.length;
        int max1 = Integer.MIN_VALUE;
        int min1 = Integer.MAX_VALUE;
        int max2 = Integer.MIN_VALUE;
        int min2 = Integer.MAX_VALUE;
        int max3 = Integer.MIN_VALUE;
        int min3 = Integer.MAX_VALUE;
        int max4 = Integer.MIN_VALUE;
        int min4 = Integer.MAX_VALUE;
        for (int i = 0; i < len; i++) {
            // 1i>2i 1j>2j i>j
            max1 = Math.max(max1, arr1[i] + arr2[i] + i);
            min1 = Math.min(min1, arr1[i] + arr2[i] + i);
            // 1i>2i 1j>2j i<j
            max2 = Math.max(max2, arr1[i] + arr2[i] - i);
            min2 = Math.min(min2, arr1[i] + arr2[i] - i);
            // 1i>2i 1j<2j i>j
            max3 = Math.max(max3, arr1[i] - arr2[i] + i);
            min3 = Math.min(min3, arr1[i] - arr2[i] + i);
            // 1i>2i 1j<2j i<j
            max4 = Math.max(max4, arr1[i] - arr2[i] - i);
            min4 = Math.min(min4, arr1[i] - arr2[i] - i);
        }
        int max = Math.max(max1 - min1, max2 - min2);
        max = Math.max(max, max3 - min3);
        max = Math.max(max, max4 - min4);
        return max;
    }

    //超时，在数组长度过长
    public int maxAbsValExpr2(int[] arr1, int[] arr2) {
        int len = arr1.length;
        int max = Math.abs(arr1[0] - arr1[1]) + Math.abs(arr2[0] - arr2[1]) + 1;
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                int tmp = Math.abs(arr1[i] - arr1[j]) + Math.abs(arr2[i] - arr2[j]) + j - i;
                if (max < tmp) {
                    max = tmp;
                }
            }
        }

        return max;
    }
}
