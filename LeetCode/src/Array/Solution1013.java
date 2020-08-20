package Array;

/**
 * 2019.10.9
 * Partition Array Into Three Parts With Equal Sum
 * <p>
 * Given an array A of integers, return true if and only if we can partition the array into three non-empty parts with equal sums.
 * Formally, we can partition the array if we can find indexes i+1 < j with (A[0] + A[1] + ... + A[i]==
 * A[i+1] + A[i+2] + ... + A[j-1] == A[j] + A[j-1] + ... + A[A.length - 1])
 * 3 <= A.length <= 50000
 * -10000 <= A[i] <= 10000
 * Input: [0,2,1,-6,6,-7,9,1,2,0,1]
 * Output: true
 * Explanation: 0 + 2 + 1 = -6 + 6 - 7 + 9 + 1 = 2 + 0 + 1
 */
public class Solution1013 {
    public static void main(String[] args) {
        int[] a = new int[]{0, 2, 1, -6, 6, -7, 9, 1, 2, 0, 1};
        System.out.println(canThreePartsEqualSum(a));
    }

    public static boolean canThreePartsEqualSum(int[] A) {
        int len = A.length;
        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum += A[i];
        }
        if (sum % 3 != 0) {
            return false;
        }
        int part = sum / 3;
        sum = 0;
        for (int i = 0; i < len; i++) {
            sum += A[i];
            if (sum == part) {
                sum = 0;
                for (int j = i + 1; j < len; j++) {
                    sum += A[j];
                    if (sum == part) {
                        sum = 0;
                        for (int k = j + 1; k < len; k++) {
                            sum += A[k];
                            if (sum == part) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    // 第一次的方法，当数组内元素个数过多会导致超时
    public boolean canThreePartsEqualSum2(int[] A) {
        boolean flag = false;
        int len = A.length;
        for (int index1 = 0; index1 < len - 2; index1++) {
            if (flag) {
                break;
            }
            for (int index2 = index1 + 1; index2 < len - 1; index2++) {
                int sum1 = 0, sum2 = 0, sum3 = 0;
                for (int i = 0; i < len; i++) {
                    if (i <= index1) {
                        sum1 += A[i];
                    } else if (i <= index2) {
                        sum2 += A[i];
                    } else sum3 += A[i];
                }
                if (sum1 == sum2 && sum1 == sum3) {
                    flag = true;
                    break;
                }
            }
        }
        return flag;
    }
}
