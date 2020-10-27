package Top100;

import java.util.Stack;

/**
 * 2020.10.27
 * 解码字符串
 * Input: s = "3[a]2[bc]"
 * Output: "aaabcbc"
 */
public class Decode_String {
    public String decodeString(String s) {
        if (s == null || s.length() == 0){
            return "";
        }
        char[] chars = s.toCharArray();
        int len = chars.length;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < len; i++){
            if (chars[i] == ']'){
                String tmp = "";
                while (!stack.isEmpty()){
                    if (stack.peek() != '['){
                        tmp = stack.pop().toString() + tmp;
                    }else {
                        // 把 '[' 抛出
                        stack.pop();
                        String count_s = "";
                        // 确定 [] 前的数字，注意不要空栈，因为会出现100[leetcode]
                        while (!stack.isEmpty() && stack.peek() - '0' >= 0 && stack.peek() - '0' <= 9){
                            count_s =stack.pop() + count_s;
                        }
                        int count = Integer.valueOf(count_s);
                        char[] tmp_chars = tmp.toCharArray();
                        for (int j = 0; j < count; j++){
                            for (int k = 0; k < tmp_chars.length; k++){
                                stack.push(tmp_chars[k]);
                            }
                        }
                        break;
                    }
                }
            }else {
                stack.push(chars[i]);
            }
        }
        char[] res = new char[stack.size()];
        while (!stack.isEmpty()){
            res[stack.size() - 1] = stack.pop();
        }
        return new String(res);
    }
}
