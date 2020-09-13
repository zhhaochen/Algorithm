package Top100;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 2020.09.13
 * Given a list of daily temperatures T, return a list such that, for each day in the input,
 * tells you how many days you would have to wait until a warmer temperature.
 * If there is no future day for which this is possible, put 0 instead.
 * <p>
 * For example, given the list of temperatures T = [73, 74, 75, 71, 69, 72, 76, 73],
 * your output should be [1, 1, 4, 2, 1, 1, 0, 0].
 */
public class Daily_Temperatures {
    public static void main(String[] args) {
        int[] T = new int[]{89,62,70,58,47,47,46,76,100,70};
        int[] res = dailyTemperatures2(T);
        System.out.println(Arrays.toString(res));
    }
    public static int[] dailyTemperatures(int[] T) {
        int len = T.length;
        int[] out = new int[len];
        int index = 0;
        while (index < len){
            for (int i = index+1; i<len; i++){
                if (T[i] > T[index]){
                    out[index] = i - index;
                    break;
                }
            }
            index++;
        }
        return out;
    }

    public static int[] dailyTemperatures2(int[] T){
        // 维护一个递减栈，栈中的值为索引，索引对应的T中的数值是递减的
        Stack<Integer> stack = new Stack<>();
        int[] out = new int[T.length];
        for (int i = 0; i<T.length; i++){
            // 对每一个新值，与栈顶元素不停比较，直到比栈顶元素小
            while (!stack.isEmpty() && T[i] > T[stack.peek()]){
                int tmp = stack.pop();
                out[tmp] = i - tmp;
            }
            stack.push(i);
        }
        return out;
    }
}
