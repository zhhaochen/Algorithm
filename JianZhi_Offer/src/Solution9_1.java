import java.util.Stack;

/**
 * 用两个栈实现队列
 *
 */
public class Solution9_1 {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    //stack2有东西则pop，没有则先把stack1中的放入再pop
    public int pop() {
        int result;
        if (!stack2.isEmpty()){
            result = stack2.pop();
        }else {
            while (!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
            result = stack2.pop();
        }
        return result;
    }
}
