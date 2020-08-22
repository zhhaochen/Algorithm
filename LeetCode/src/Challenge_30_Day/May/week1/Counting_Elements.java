package Challenge_30_Day.May.week1;

import java.util.HashMap;
import java.util.Map;

/**
 * Input: arr = [1,2,3]
 * Output: 2
 * Explanation: 1 and 2 are counted cause 2 and 3 are in arr.
 *
 * Input: arr = [1,3,2,3,5,0]
 * Output: 3
 * Explanation: 0, 1 and 2 are counted cause 1, 2 and 3 are in arr.
 * 统计数组中有多少+1后还在数组中
 */
public class Counting_Elements {
    public static void main(String[] args) {
        int[] arr = new int[]{1,3,2,3,5,0};
        System.out.println(countElements(arr));
    }
    public static int countElements(int[] arr) {
        Map<Integer,Integer> map = new HashMap<>();
        int count = 0;
        for (int num: arr){
            map.put(num, 0);
        }
        for (int num: arr){
            if (map.get(num+1) != null){
                count++;
            }
        }
        return count;
    }
}
