package sort;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        int[] array = new int[]{5, 12, 18, 15, 3, 9, 6, 4};
        quickSort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }

    //快速排序
    private static void quickSort(int[] array, int start, int end) {
        //递归结束
        if (start < end) {
            //记录标准数
            int stard = array[start];
            //记录需要排序的标
            int low = start;
            int high = end;
            //循环找比标准数大的数和比标准数小的数
            while (low < high) {
                //右边的数字比标准数大
                while (low < high && stard <= array[high]) {
                    high--;
                }
                //右边数字替换左边的数
                array[low] = array[high];
                //左边的数字比标准数小
                while (low < high && stard >= array[low]) {
                    low++;
                }
                //左边数字替换右边的数
                array[high] = array[low];
            }
            //标准数赋给低所在元素
            array[low] = stard; //此时low = high
            //递归处理所有小数字
            quickSort(array, start, low);
            //递归处理所有大数字
            quickSort(array, low + 1, end);
        }
    }
}
