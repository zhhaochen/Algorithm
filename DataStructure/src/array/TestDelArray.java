package array;

import java.util.Arrays;

public class TestDelArray {

    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(array));
        array = delArray(array, 4);
        System.out.println(Arrays.toString(array));
    }

    private static int[] delArray(int[] array, int i){
        int[] newArr = new int[array.length-1];
        for (int j = 0; j<newArr.length; j++){
            if (j<i){
                newArr[j] = array[j];
            }else {
                newArr[j] = array[j+1];
            }
        }

        return newArr;
    }
}
