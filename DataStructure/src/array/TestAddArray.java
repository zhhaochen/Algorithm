package array;

import java.util.Arrays;

public class TestAddArray {
    public static void main(String[] args) {
        int[] array = new int[] {9, 8, 7};
        System.out.println(Arrays.toString(array));
        int dst = 6;
        array = addArray(array, dst);
        System.out.println(Arrays.toString(array));
    }

    private static int[] addArray(int[] array, int dst){
        int[] newArr = new int[array.length+1];
        for (int i=0; i<array.length; i++){
            newArr[i] = array[i];
        }
        newArr[array.length] = dst;
        return newArr;
    }
}
