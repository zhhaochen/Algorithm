package Challenge_30_Day.May.week2;

import java.util.Stack;

/**
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> Returns -3.
 * minStack.pop();
 * minStack.top();      --> Returns 0.
 * minStack.getMin();   --> Returns -2.
 */
public class Min_Stack {

    /** initialize your data structure here. */
    private Stack<Integer> stack1 = new Stack<>(); //正常的栈
    private Stack<Integer> stack2 = new Stack<>(); //存放最小值的栈
    private Stack<Integer> stack3 = new Stack<>(); //缓冲区

    public Min_Stack() {
    }

    public void push(int x) {
        stack1.push(x); //正常顺序入栈
        //根据比较最小的入栈
        while (!stack2.isEmpty()){
            int temp = stack2.peek(); //获取栈顶元素并不抛出，如果比新的小就入缓冲栈
            if (temp < x){
                stack3.push(stack2.pop()); //放入缓冲
            }else {
                break;
            }
        }
        //按照大小顺序入栈
        stack2.push(x);
        while (!stack3.isEmpty()){
            stack2.push(stack3.pop());
        }
    }

    public void pop() {
        int pop = stack1.pop();
        while (!stack2.isEmpty()){
            int temp = stack2.peek(); //获取栈顶元素并不抛出，如果比新的小就入缓冲栈
            if (temp != pop){
                stack3.push(stack2.pop()); //放入缓冲
            }else {
                break;
            }
        }
        stack2.pop();
        while (!stack3.isEmpty()){
            stack2.push(stack3.pop());
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
