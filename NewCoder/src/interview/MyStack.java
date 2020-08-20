package interview;

import java.util.Stack;

public class MyStack {
    Stack<Integer> stack1 = new Stack<Integer>(); //入
    Stack<Integer> stack2 = new Stack<Integer>(); //出

    public void appendTail(int node) {
        stack1.push(node);
    }

    public int deleteHead() throws Exception {
        if (stack2.isEmpty()){
            while (!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }

        if (stack2.isEmpty()){
            throw new Exception("empty queue");
        }

        return stack2.pop();
    }
}
