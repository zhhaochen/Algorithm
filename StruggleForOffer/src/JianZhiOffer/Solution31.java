package JianZhiOffer;

import java.util.Stack;

public class Solution31 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int push_index = 0, pop_index = 0;
        while (push_index < pushed.length){
            while (push_index < pushed.length && (stack.isEmpty() || stack.peek() != popped[pop_index])){
                stack.push(pushed[push_index++]);
            }
            while (!stack.isEmpty() && stack.peek() == popped[pop_index]){
                stack.pop();
                pop_index++;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        int[] pushed = {1, 2, 3, 4, 5};
        int[] poped = {4, 5, 3, 2, 1};
        boolean res = new Solution31().validateStackSequences(pushed, poped);
    }
}
