package Array;

/**
 * 2019.10.30
 * Decrease Elements To Make Array Zigzag
 * <p>
 * Given an array nums of integers, a move consists of choosing any element and decreasing it by 1.
 * An array A is a zigzag array if either:
 * Every even-indexed element is greater than adjacent elements, ie. A[0] > A[1] < A[2] > A[3] < A[4] > ...
 * OR, every odd-indexed element is greater than adjacent elements, ie. A[0] < A[1] > A[2] < A[3] > A[4] < ...
 * Return the minimum number of moves to transform the given array nums into a zigzag array.
 * <p>
 * Input: nums = [1,2,3]
 * Output: 2
 * Explanation: We can decrease 2 to 0 or 3 to 1.
 */
public class Solution1144 {

    public static void main(String[] args) {
        int[] nums = new int[]{7, 4, 8, 9, 7, 7, 5};
        int count = movesToMakeZigzag(nums);
        System.out.println(count);
    }

    // 两种情况分别判断，判断是奇数位总是小的还是偶数位总是小的，
    // 如果判断奇偶是否总是大的运算量增大过多，且需将数组实际变化后才可以
    private static int movesToMakeZigzag(int nums[]) {
        int count1 = 0;
        int count2 = 0;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (i % 2 == 0) {
                //偶数位为小的时候
                if (i == 0) {
                    count1 += Math.max(0, nums[i] - nums[i + 1] + 1);
                } else if (i == len - 1) {
                    count1 += Math.max(0, nums[i] - nums[i - 1] + 1);
                } else {
                    count1 += Math.max(0, Math.max(nums[i] - nums[i - 1] + 1, nums[i] - nums[i + 1] + 1));
                }
            } else {
                //奇数位为小的时候
                if (i == len - 1) {
                    count2 += Math.max(0, nums[i] - nums[i - 1] + 1);
                } else {
                    count2 += Math.max(0, Math.max(nums[i] - nums[i - 1] + 1, nums[i] - nums[i + 1] + 1));
                }
            }
        }
        return Math.min(count1, count2);
    }

    private static int movesToMakeZigzag2(int[] nums) {
        int N = nums.length;
        int even = 0, odd = 0;
        for (int i = 0; i < N; i++) {
            int next = (i + 1) < N ? nums[i + 1] : Integer.MAX_VALUE; //前一个
            int prev = (i - 1) >= 0 ? nums[i - 1] : Integer.MAX_VALUE; //后一个
            int change = Math.max(0, nums[i] - Math.min(prev, next) + 1); //如果是中间大两边小则返回减少的步数， 否则返回0
            if (i % 2 == 0) {
                even += change;
            } else {
                odd += change;
            }
        }
        return Math.min(even, odd);
    }

}
