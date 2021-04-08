package Hot100;

import java.util.Stack;

public class Solution394 {
    public String decodeString(String s) {
        char[] tmp = s.toCharArray();
        Stack<String> stack_res = new Stack<>();
        Stack<Integer> stack_multi = new Stack<>();
        int multi = 0;
        StringBuilder sb = new StringBuilder();
        for (char c : tmp){
            // 把括号之前的结果入栈
            if (c == '['){
                stack_multi.push(multi);
                stack_res.push(sb.toString());
                multi = 0;
                sb = new StringBuilder();
            }
            else if (c >= '0' && c <= '9') multi = multi * 10 + (c - '0');
            else if (c == ']'){
                // 与当前右括号匹配的左括号前的次数
                int cur_multi = stack_multi.pop();
                StringBuilder tmp_s = new StringBuilder();
                // 根据次数拼接当前字符串
                for (int i = 0; i < cur_multi; i++) tmp_s.append(sb);
                // 左括号之前的结果加上
                sb = new StringBuilder(stack_res.pop() + tmp_s);
            }
            // 添加当前结果里的值，可能是括号里的，也可能是括号外的
            else sb.append(c);
        }
        return sb.toString();
    }
}
