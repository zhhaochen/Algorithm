package Challenge_30_Day.week2;

import java.util.Stack;

public class Min_Stack3 {
    private int min_val = Integer.MAX_VALUE;
    private Stack<Integer> s = new Stack<>();

    public Min_Stack3() {}
    public void push(int x) {
        if (x <= min_val) {
            s.push(min_val);
            min_val = x;
        }
        s.push(x);
    }
    public void pop() {
        if (s.pop() == min_val) { //如果当前的栈顶元素是最小值，说明次栈顶元素是上一个最小值，需要抛出重新赋值
            min_val = s.pop();
        }
    }
    public int top() {
        return s.peek();
    }
    public int getMin() {
        return min_val;
    }
}
