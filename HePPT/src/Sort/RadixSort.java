package Sort;

import java.util.Arrays;

/**
 * 计数排序：数组count[k]记录 0-k 之间的数字出现次数，最后赋值给原数组
 * 桶排序：将数组分到有限数量的桶，桶有各自范围。每个桶再个别排序（别的排序算法或是以递归方式继续使用桶排序进行排序），最后依次把各个桶中的记录列出来记得到有序序列。
 * 基数排序：从低位开始，每一位进行计数并分配桶，并对每一个数进行桶排序
 * 时间复杂度为O(d*(r+n))。数组中最大的数是d位数，基数为r（如基数为10
 * 空间复杂度O(r+n)
 */
public class RadixSort {

    public void radixSort_simple(int[] nums){
        int max = Integer.MIN_VALUE;
        int[] count = new int[10];
        for (int num : nums){
            if (num > max) max = num;
        }
        int len = (max + "").length();
        int[] tmp = new int[nums.length];
        for (int i = 0, digit = 1; i < len; i++, digit *= 10){
            // 索引清零
            for (int j = 0; j < 10; j++) count[j] = 0;
            // 计数
            for (int num : nums){
                count[num / digit % 10]++;
            }
            // 记录索引结束位置
            for (int j = 1; j < 10; j++){
                count[j] += count[j - 1];
            }
            // 此处从后往前进行赋值
            for (int j = nums.length - 1; j >= 0; j--){
                tmp[--count[nums[j] / digit % 10]] = nums[j];
            }
            // 赋值回去
            for (int j = 0; j < nums.length; j++) nums[j] = tmp[j];
        }
    }

    // 这个用的额外空间过多
    public void radixSort(int[] nums){
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            if (num > max) max = num;
        }
        // 获取最大值位数
        int len = (max + "").length();
        // 二维数组作为存储容器
        int[][] tmp = new int[10][nums.length];
        // 存储每个容器存的个数，每一轮将其置空
        int[] count = new int[10];
        // 根据最大长度确定比较次数
        for (int i = 0, n = 1; i < len; i++, n *= 10){
            // 进行第 i 轮的位数排序
            for (int j = 0; j < nums.length; j++){
                int ys = nums[j] / n % 10;
                tmp[ys][count[ys]++] = nums[j];
            }
            // 将本轮的存回数组
            int index = 0;
            for (int k = 0; k < 10; k++){
                for (int j = 0; j < count[k]; j++){
                    nums[index++] = tmp[k][j];
                }
                count[k] = 0;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 0, 2, 5, 8, 3, 11, 0, 1};
        new RadixSort().radixSort_simple(nums);
        System.out.println(Arrays.toString(nums));
    }
}
