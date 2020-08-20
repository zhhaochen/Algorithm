package String;

import java.util.Stack;

/**
 * 2020.4.16
 * Valid Parentheses
 *
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']',
 * determine if the input string is valid.
 * 1.Open brackets must be closed by the same type of brackets.
 * 2.Open brackets must be closed in the correct order.
 * Input: "()[]{}"
 * Output: true
 */
public class Solution20 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{'){
                stack.push(s.charAt(i));
            }else {
                if (!stack.isEmpty()){
                    char pop = stack.pop();
                    switch (c){
                        case ')':
                            if (pop == '('){
                                break;
                            }else {
                                return false;
                            }
                        case ']':
                            if (pop == '['){
                                break;
                            }else {
                                return false;
                            }
                        case '}':
                            if (pop == '{'){
                                break;
                            }else {
                                return false;
                            }
                        default:
                            break;
                    }
                }
            }
        }
        return stack.isEmpty();
    }

    public boolean isValid2(String s){
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{'){
                stack.push(s.charAt(i));
            }else {
                if (stack.isEmpty()) {return false;}
                if (c == ')' && stack.pop() !='('){return false;}
                if (c == '}' && stack.pop() !='{'){return false;}
                if (c == ']' && stack.pop() !='['){return false;}
            }
        }
        return stack.isEmpty();
    }
}
