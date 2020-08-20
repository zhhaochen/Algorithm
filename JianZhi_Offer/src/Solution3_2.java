/**
 * 面试三 题目二
 * 找出数组中重复数字
 * 长度为n+1数组，所有数字在1--n范围内，必有数字重复，但不知有几个数字重复，也不知重复几次
 * 找出一个重复数字
 * 不能修改输入数组
 */
public class Solution3_2 {
    public static void main(String[] args) {
        int[] data = new int[]{2, 3, 5, 4, 3, 2, 6, 7};
        System.out.println(getNumber(data));
    }

    // 二分查找思路，时间复杂度O(nlogn),空间复杂度O(1)，不能找出所有重复数字
    // 理解起来比较困难
    private static int getNumber(int[] data){
        int len = data.length; // len>=2
        int start = 1;
        int end = len -1;
        while (start<end){ // logn次
            int mid = (start + end) / 2;
            int count1 = 0;
            for (int i = 0; i < len; i++) { //n次
                if (data[i] >= start && data[i] <= mid){
                    count1++;
                }
            }
            if (count1 > (mid - start + 1)){
                end = mid;
            }else {
                start = mid + 1;
            }
        }
        return start;
    }
}
