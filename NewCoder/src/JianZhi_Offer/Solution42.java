package JianZhi_Offer;

import java.util.ArrayList;

/**
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，
 * 如果有多对数字的和等于S，输出两个数的乘积最小的。
 */
public class Solution42 {
    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(array.length < 2){
            return result;
        }
        int start = 0;
        int end = array.length - 1;
        int curSum  = array[start] + array[end];
        while(start < end){
            if(curSum == sum){
                result.add(array[start]);
                result.add(array[end]);
                break;
            }else if(curSum < sum){
                curSum -= array[start++];
                curSum += array[start];
            }else{
                curSum -= array[end--];
                curSum += array[end];
            }
        }

        return result;
    }
}
