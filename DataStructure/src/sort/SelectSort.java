package sort;

import java.util.Arrays;

public class SelectSort {
    public static void main(String[] args) {
        int[] array = new int[]{5, 12, 18, 15, 3, 9, 6, 4, 0};
        selectSort(array);
        System.out.println(Arrays.toString(array));
    }

    //选择排序，循环选择每次最小的放到当前位置
    private static void selectSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int current = array[i - 1];
            int key = i - 1; //若key从i开始，则进行交换时需要先判断array[i-1]>current?
            for (int j = i; j < array.length; j++) {
                if (array[j] < current) {
                    key = j;
                    current = array[key];
                }
            }
//          1  --------------------------------------
            if (key != i-1){
                array[key] = array[i - 1];
                array[i - 1] = current;
            }
//          2,key = i-1开始时可以不判断  ------------
//            array[key] = array[i - 1];
//            array[i - 1] = current;
            System.out.println(Arrays.toString(array));
        }
    }
}
