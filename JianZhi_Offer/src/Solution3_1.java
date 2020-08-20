import java.util.HashMap;
import java.util.Map;

/**
 * 面试三 题目一
 * 找出数组中重复数字
 * 长度为n数组，所有数字在0--n-1范围内，某些数字重复，但不知有几个数字重复，也不知重复几次
 * 找出一个重复数字
 */

public class Solution3_1 {
    public static void main(String[] args) {
        int[] data = new int[]{2, 3, 1, 0, 2, 5, 3};
        System.out.println(getNumber2(data));
    }

    //解法一，遍历+使用哈希表，时间复杂度O(n)，空间复杂度O(n)
    private static int getNumber(int[] data){
        Map<Integer, Integer> map = new HashMap<>();
        int len = data.length;
        for (int i = 0; i < len; i++) {
            if (map.containsKey(data[i]))
                return data[i];
            else {
                map.put(data[i], 0);
            }
        }
        return 0;
    }
    //解法二，根据数组中数据大小范围，时间复杂度O(n)，空间复杂度O(1)
    private static int getNumber2(int[] data){
        int len = data.length;
        int result = -1;
        for (int i = 0; i < len; i++) {
            while (data[i] != i){
                int m = data[i];
                if (data[i] == data[m]){
                    result = m;
                    break;
                }
                else {
                    data[i] = data[m];
                    data[m] = m;
                }
            }
            if (result != -1)
                break;
        }
        return result;
    }
}
