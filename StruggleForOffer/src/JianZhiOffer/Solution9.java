package JianZhiOffer;

import java.util.Stack;

public class Solution9 {
    Stack<Integer> in;
    Stack<Integer> out;

    public Solution9() {
        in = new Stack<>();
        out = new Stack<>();
    }

    public void appendTail(int value) {
        in.push(value);
    }

    public int deleteHead() {
        if (in.isEmpty() && out.isEmpty()) return -1;
        if (!out.isEmpty()) return out.pop();
        while (!in.isEmpty()){
            out.push(in.pop());
        }
        return out.pop();
    }
}
