package Challenge_30_Day.week1;

import java.util.Arrays;

/**
 * 原283题
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 * <p>
 * Example:
 * <p>
 * Input: [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 * Note:
 * TODO You must do this in-place without making a copy of the array. 不能用额外空间，只能在这个上进行
 * Minimize the total number of operations. 操作尽量少
 */
public class Move_Zeros {
    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 1, 3, 0};
        moveZeroes2(nums);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 思路：双指针，一个迭代数组，一个迭代非0元素
     * 并不意味着要一下子把0移动到末尾，可以先就近交换，然后接着往后遍历
     */
    public static void moveZeroes(int[] nums) {
        int len = nums.length;
        int index1 = 0; //找不是0
        int index2 = 0; //找是0
        while (index2 < len) {
            //不断迭代找到为0的位置
            while (index1 < len && nums[index1] != 0) {
                index1++;
            }

            index2 = index1 + 1;
            //找到为0的位置
            while (index2 < len && nums[index2] == 0) {
                index2++;
            }

            //当index2还没有越界，说明可以交换
            if (index2 < len) {
                nums[index1] = nums[index2];
                nums[index2] = 0;
            }
        }
    }

    //大佬in-place双指针解法：只要
    public static void moveZeroes2(int[] nums) {
        int len = nums.length;
        for (int i=0, j=0; i<len; i++){
            /**
             * 只有当交换的时候j才加一
             * i与j同时开始，假设开始全是非0，则每次交换后数组未变，i和j同时移动
             * 当遇到第一个0时，i继续移动找非0，此时因为没有交换过，j卡住，停留在这个0的位置
             * 当i遇到0之后的第一个非0，与j位置进行互换，j只要++即可，因为有两种情况
             * 一种是j的0之后还是0，所以++指向下一个0
             * 另一种是j的0之后非0，则++即可与i指向同一个
             */
            if (nums[i]!=0){
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j++] = tmp;
            }
        }
    }

}
