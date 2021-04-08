package Hot100;

import java.util.PriorityQueue;
import java.util.Stack;

public class Solution739 {
    public int[] dailyTemperatures(int[] T) {
        int[] res = new int[T.length];
        res[T.length - 1] = 0;
        for (int i = T.length - 2; i >= 0; i--){
            if (T[i + 1] > T[i]) res[i] = 1;
            else{
                int tmp_index = i + 1;
                while (tmp_index < T.length){
                    // 主要考虑到达res[] = 0 的情况
                    if (T[tmp_index] > T[i] || res[tmp_index] == 0) break;
                    else tmp_index += res[tmp_index];
                }
                res[i] = tmp_index < T.length && T[tmp_index] > T[i] ? tmp_index - i : 0;
            }
        }
        return res;
    }
    // 维护一个存储下标的栈
    public int[] dailyTemperatures2(int[] T) {
        int[] res = new int[T.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < T.length; i++){
            while (!stack.isEmpty() || T[stack.peek()] < T[i]) res[stack.peek()] = i - stack.pop();
            stack.push(i);
        }
        return res;
    }
}
