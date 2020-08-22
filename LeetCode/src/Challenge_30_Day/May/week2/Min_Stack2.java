package Challenge_30_Day.May.week2;

import java.util.Stack;

public class Min_Stack2 {
    private Stack<Integer> stack1 = new Stack<>(); //正常的栈
    private Stack<Integer> stack2 = new Stack<>(); //存放出现过的最小值的栈


    public Min_Stack2() {
    }

    public void push(int x) {
        stack1.push(x);
        if (stack2.isEmpty() || x <= stack2.peek()){
            stack2.push(x);
        }
    }

    public void pop() {
        int x = stack1.pop();
        if (stack2.peek() == x){
            stack2.pop();
        }
    }

    public int top() {
        return stack1.peek();
    }

    //多了一个返回最小值的功能
    public int getMin() {
        return stack2.peek();
    }
}
