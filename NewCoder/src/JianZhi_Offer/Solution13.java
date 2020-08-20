package JianZhi_Offer;

import java.util.ArrayList;
import java.util.List;

/**
 * 2019.11.6
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */
public class Solution13 {

    // 插入排序思想
    public void reOrderArray_(int[] array){
        int len = array.length;
        int index = 0;
        for (int i = 0; i<len; i++){
            if (array[i]%2 == 1){
                // 是奇数的时候就往前移，移到index处
                int tmp = array[i];
                for (int j = i; j>index; j--){
                    array[j] = array[j-1];
                }
                array[index] = tmp;
                index++;
            }
        }
    }
    // 简单暴力做法
    public void reOrderArray(int[] array) {
        int len = array.length;
        List<Integer> odd = new ArrayList<Integer>(); //奇数
        List<Integer> even = new ArrayList<Integer>(); //偶数
        for (int i = 0; i<len; i++){
            if (array[i] % 2 == 1){
                odd.add(array[i]);
            }else {
                even.add(array[i]);
            }
        }
        int size = odd.size();
        for (int i = 0; i<len; i++){
            if (i<size){
                array[i] = odd.get(i);
            }else {
                array[i] = even.get(i-size);
            }
        }
    }
}
