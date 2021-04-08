package Tencent;

import java.util.Stack;

public class Solution20 {
    public boolean isValid(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char c : chars){
            if (c == ')' && !stack.isEmpty() && stack.peek() == '(') stack.pop();
            else if (c == ']' && !stack.isEmpty() && stack.peek() == '[') stack.pop();
            else if (c == '}' && !stack.isEmpty() && stack.peek() == '{') stack.pop();
            else stack.push(c);
        }
        return stack.isEmpty();
    }
}
