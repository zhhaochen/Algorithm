package sort;

import java.util.Arrays;

public class HeapSort {

    public static void main(String[] args) {
        int[] arr = new int[]{9, 6, 8, 7, 0, 5, 1, 10, 4, 2, 3};
//        //开始位置是最后一个非叶子节点，即最后一个节点的父节点
//        int start = arr.length / 2 - 1;
//        //调整为大顶堆
//        for (int i = start; i >= 0; i--) {
//            maxHeap(arr, arr.length, i);
//        }
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void heapSort(int[] arr){
        int len = arr.length;
        //循环比较arr.lenth-1次
//        for (int i = 0; i< arr.length-1; i++){
//            int start = len/2 - 1;
//            for (int j = start; j >= 0; j--) {
//                maxHeap(arr, len, j);
//            }
//            len--;
//            int tmp = arr[len];
//            arr[len] = arr[0];
//            arr[0] = tmp;
//        }
        //简化版，将len代替i
        for (; len>1;){
            int start = len/2 - 1;
            for (int j = start; j >= 0; j--) {
                maxHeap(arr, len, j);
            }
            len--;
            int tmp = arr[len];
            arr[len] = arr[0];
            arr[0] = tmp;
        }
    }

    private static void maxHeap(int[] arr, int size, int index) {
        int lefNode = 2 * index + 1;
        int rightNode = 2 * index + 2;

        int max = index;
        if (lefNode < size && arr[lefNode] > arr[max]) {
            max = lefNode;
        }
        if (rightNode < size && arr[rightNode] > arr[max]) {
            max = rightNode;
        }
        if (max != index) {
            int tmp = arr[index];
            arr[index] = arr[max];
            arr[max] = tmp;
            //交换位置后可能会破坏之前排好的堆
            maxHeap(arr, size, max);
        }
    }
}
