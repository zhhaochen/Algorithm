package Challenge_30_Day.May.week3;

import java.util.Stack;

/**
 * Given a string containing only three types of characters: '(', ')' and '*',
 * write a function to check whether this string is valid. We define the validity of a string by these rules:
 * 1.Any left parenthesis '(' must have a corresponding right parenthesis ')'.
 * 2.Any right parenthesis ')' must have a corresponding left parenthesis '('.
 * 3.Left parenthesis '(' must go before the corresponding right parenthesis ')'.
 * 4.'*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string.
 * 5.An empty string is also valid.
 * Input: "(*)"
 * Output: True
 * Input: "(*))"
 * Output: True
 */
public class Valid_Parenthesis_String {
    public static void main(String[] args) {
        String s = "()()"; //true
        System.out.println(checkValidString(s));
    }
    public static boolean checkValidString(String s) {
        Stack<Character> stack = new Stack<>();
        int index = 0;
        while (!stack.isEmpty() || index<s.length()){
            if (s.charAt(index)!=')'){
                stack.push(s.charAt(index++));
            }
        }
        return true;
    }
}
