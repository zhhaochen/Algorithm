package sort;

import java.util.Arrays;

public class RadixSort {
    public static void main(String[] args) {
        int[] array = new int[]{18, 234, 32, 324, 111, 57, 698, 996, 221, 3, 6, 1, 9};
        radixSort(array);
        System.out.println(Arrays.toString(array));
    }

    //基数排序，从最低位开始排列
    private static void radixSort(int[] array) {
        //获得最大值
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max)
                max = array[i];
        }
        //获取最大值的位数
        int len = (max + "").length();
        //二维数组作为存储容器
        int[][] tmp = new int[10][array.length];
        //存储每个容器存的个数，每一轮将其置空
        int[] counts = new int[10];
        //根据最大长度数确定比较次数
        for (int i = 0, n = 1; i < len; i++, n *= 10) {
            //进行第i轮的位数排序
            for (int j = 0; j < array.length; j++) {
                int ys = array[j] / n % 10;
                tmp[ys][counts[ys]++] = array[j];
            }
            //将本轮的读取出来放回原数组
            int index = 0;
            for (int k = 0; k < 10; k++) {
                for (int j = 0; j < counts[k]; j++) {
                    array[index++] = tmp[k][j];
                }
                counts[k] = 0;
            }
        }
    }
}
