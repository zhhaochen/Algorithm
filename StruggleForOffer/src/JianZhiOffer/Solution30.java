package JianZhiOffer;

import java.util.Stack;

public class Solution30 {
    private int min;
    private Stack<Long> stack;
    public Solution30() {
        stack = new Stack<>();
    }

    public void push(int x) {
        if (stack.isEmpty()) min = x;
        // 注意这里的数值范围
        stack.push((long)x - (long)min);
        if (x < min) min = x;
    }

    public void pop() {
        long pop = stack.pop();
        if (pop < 0) min = (int) (min - pop);
    }

    public int top() {
        if (stack.peek() <= 0) return min;
        return (int) (stack.peek() + min);
    }

    public int min() {
        return min;
    }
}
