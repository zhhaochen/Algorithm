package sort;

import java.util.Arrays;

public class ShellSort {
    public static void main(String[] args) {
        int[] array = new int[]{5, 12, 18, 15, 3, 9, 6, 4, 0};
        int[] array2 = new int[]{5, 12, 18, 15, 3, 9, 6, 4, 0};
        shellSort(array);
        shellSort2(array2);
        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.toString(array2));
    }

    //此排序在每个循环中将同一组一起排完，不论长度
    private static void shellSort(int[] array) {
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

    //使用此类插入排序时，每个循环中，长度相同的同时排，长度更长的先排完短长度再排剩下的
    private static void shellSort2(int[] array) {
        //定义步长
        int stride = array.length / 2;
        for (; stride > 0; stride /= 2) {
            for (int i = stride; i < array.length; i++) {
                for (int j = i - stride; j >= 0; j -= stride) {
                    if (array[j] > array[j + stride]) {
                        int tmp = array[j];
                        array[j] = array[j + stride];
                        array[j + stride] = tmp;
                    }
                }
            }
        }
    }
}
