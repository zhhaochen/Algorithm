package sort;

import java.util.Arrays;

/**
 * 插入排序与冒泡排序的不同处：
 * 冒泡排序从前向后排列，即每次循环将最大的放到最后
 * 插入排序从后向前排列，不一定是最小的，只是当前最小的放到最前
 */
public class InsertionSort {
    public static void main(String[] args) {
        int[] array = new int[]{5, 12, 18, 15, 3, 9, 6, 4};
        insertionSort2(array);
        System.out.println(Arrays.toString(array));
    }

    //插入排序
    private static void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            //只有当前比前一个小的时候开始循环交换
            if (array[i] < array[i - 1]) { //可以不加这个判断，此判断减少复杂度
                //获取当前数值作为比较
                int current = array[i];
                //为了最后赋值，将k定义在外面
                int k;
                //循环向前比较，如果比前面的小就交换
                for (k = i - 1; k >= 0 && array[k] > current; k--) {
                    array[k + 1] = array[k];
                }
                //将当前数赋值给比当前数小的后面的位置
                array[k + 1] = current;
            }
        }
    }

    private static void insertionSort2(int[] array) {
        for (int i = 1; i < array.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (array[j] > array[j + 1]) {
                    int tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                }
            }
        }
    }
}
