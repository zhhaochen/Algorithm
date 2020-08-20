package JianZhi_Offer;

import java.util.Stack;

/**
 * 2019.9.18
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 */
public class Solution5 {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void appendTail(int node) {
        stack1.push(node);
    }

    public int deleteHead() {
        if (!stack1.isEmpty()){
            throw new RuntimeException("Queue is empty!");
        }
        int len = stack1.size();
        for (int i = 0; i< len - 1; i++){
            stack2.push(stack1.pop());
        }
        int result = stack1.pop();
        while (!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
        return result;
    }
}
