package chapter5_sort;

import java.util.Arrays;

public class Shell_Sort {

    public static void main(String[] args) {
        int[] nums = new int[]{5, 7, 1, 8, 4, 0, 8};
        shellSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    //间隔不同的插入排序
    public static void shellSort(int[] nums){
        int n = nums.length;
        int d = n;
        while (d!=1){
            d /= 2; //间隔更新
            //对不同间隔进行插入排序
            for (int p=d; p<n; p++){ //注意这里从间隔d开始，依然是到n-1结束
                int i = p;
                int tmp = nums[p];
                for (; i >=d && nums[i-d] > tmp; i -=d){
                    nums[i] = nums[i-d];
                }
                nums[i] = tmp;
            }
        }
    }

    //写法二，此时对同一个分组进行排序
    private static void shellSort2(int[] array) {
        //定义步长
        int stride = array.length / 2;
        for (; stride > 0; stride /= 2) {
            //遍历所有元素
            for (int i = 0; i < stride; i++) { //每一个分组
                //对每个分组进行插入排序
                for (int j = i + stride; j < array.length; j += stride) {
                    if (array[j] < array[j - stride]) {
                        int current = array[j];
                        int k;
                        for (k = j - stride; k >= 0 && array[k] > current; k -= stride) {
                            array[k + stride] = array[k];
                        }
                        array[k + stride] = current;
                    }
                }
            }
        }
    }
}
