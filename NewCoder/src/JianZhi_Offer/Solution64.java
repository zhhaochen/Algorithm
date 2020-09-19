package JianZhi_Offer;

import java.util.ArrayList;

/**
 * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
 * 如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}；
 */
public class Solution64 {
    public ArrayList<Integer> maxInWindows(int [] num, int size){
        int len = num.length;
        ArrayList<Integer> list = new ArrayList<>();
        if(size > len || size == 0){
            return list;
        }
        int max = getMax(num, 0, size-1);
        list.add(max);
        for(int i = size; i < len; i++){
            // 先判断当前新加的是不是比原来的大
            if(num[i] >= max){
                max = num[i];
            }else if(num[i - size] >= max){
                // 如果去掉的是比原来窗口里大的
                max = getMax(num, i-size+1, i);
            }
            list.add(max);
        }
        return list;
    }
    int getMax(int[] num, int start, int end){
        int max = 0;
        for(int i = start; i <= end; i++){
            max = Math.max(max, num[i]);
        }
        return max;
    }
}
