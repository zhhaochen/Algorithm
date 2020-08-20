package sort;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] array = new int[]{5, 12, 18, 15, 3, 9, 6, 4, 0};
        mergeSort(array, 0, array.length - 1);
//        int[] array = new int[]{5, 12, 15, 18, 3, 6, 8, 9, 13, 22, 88, 99};
//        merge(array, 0, 3, array.length-1);
        System.out.println(Arrays.toString(array));
    }

    private static void mergeSort(int[] array, int start, int end) {
        int mid = (start + end) / 2;
        if (start != end) {//没有此终止条件时，会栈溢出
            //排左边
            mergeSort(array, start, mid);
            //排右边
            mergeSort(array, mid + 1, end);
            //合并
            merge(array, start, mid, end);
        }
    }

    //归并
    private static void merge(int[] array, int start, int mid, int end) {
        //临时存储数组
        int[] tmp = new int[end - start + 1];
        //记录两部分的开始位置
        int low1 = start;
        int low2 = mid + 1;
        //记录存储位置
        int index = 0;
        while (low1 <= mid && low2 <= end) {
//            if (array[low1] <= array[low2]) {
//                tmp[index] = array[low1];
//                index++;
//                low1++;
//            } else {
//                tmp[index] = array[low2];
//                index++;
//                low2++;
//            }
            tmp[index++] = array[low1] <= array[low2] ? array[low1++] : array[low2++];
        }
        while (low1 <= mid) {
//            tmp[index] = array[low1];
//            index++;
//            low1++;
            tmp[index++] = array[low1++];
        }
        while (low2 <= end) {
//            tmp[index] = array[low2];
//            index++;
//            low2++;
            tmp[index++] = array[low2++];
        }
        for (int i = 0; i < tmp.length; i++) {
            array[i + start] = tmp[i];
        }
    }
}
