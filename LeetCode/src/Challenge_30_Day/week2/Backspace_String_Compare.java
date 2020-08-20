package Challenge_30_Day.week2;

import java.util.Stack;

/**
 * Given two strings S and T, return if they are equal when both are typed into empty text editors.
 * # means a backspace character. 删除键
 * Input: S = "ab#c", T = "ad#c"
 * Output: true
 * Explanation: Both S and T become "ac".
 *
 * Input: S = "ab##", T = "c#d#"
 * Output: true
 * Explanation: Both S and T become "".
 *
 * Input: S = "a#c", T = "b"
 * Output: false
 * Explanation: S becomes "c" while T becomes "b".
 *
 * Can you solve it in O(N) time and O(1) space?
 */
public class Backspace_String_Compare {
    public static void main(String[] args) {
        String s = "xywrrmp";
        String T = "xywrrmu#p";
        System.out.println(backspaceCompare2(s, T));
    }

    //这个是基本解法，还可以提高
    public static boolean backspaceCompare(String S, String T) {
        Stack<Character> stack1 = new Stack<>();
        Stack<Character> stack2 = new Stack<>();
        for (char s: S.toCharArray()){
            if (s == '#'){
                if (!stack1.isEmpty()){
                    stack1.pop();
                }
            }else {
                stack1.push(s);
            }
        }
        for (char t: T.toCharArray()){
            if (t == '#'){
                if (!stack2.isEmpty()){
                    stack2.pop();
                }
            }else {
                stack2.push(t);
            }
        }
        while (!stack1.isEmpty() && !stack2.isEmpty()){
            if (!stack1.pop().equals(stack2.pop())){
                return false;
            }
        }
        return stack1.isEmpty()&&stack2.isEmpty();
    }

    /**
     * 如果想要O(1)的空间复杂度，不能使用stack
     * TODO 应该从后开始向前遍历，因为退格是退前面的格子，用双指针解法
     * TODO 注意统计退格数
     */
    public static boolean backspaceCompare2(String S, String T){
        int i = S.length()-1;
        int j = T.length()-1;
        int cnt1 = 0;
        int cnt2 = 0;
        while (i >=0 || j>=0){
            //如果当前是退格键或者还没退完格
            while (i >= 0 && (S.charAt(i) == '#' || cnt1 > 0)){
                cnt1 = S.charAt(i--) == '#' ? ++cnt1 : --cnt1; //如果当前是退格键就统计+1，无论如何都要向前
            }
            while (j >= 0 && (T.charAt(j) == '#' || cnt2 > 0)){
                cnt2 = T.charAt(j--) == '#' ? ++cnt2 : --cnt2;
            }
            if (i < 0 || j < 0) { //当某一个已经遍历完了，进行比较
                return i == j;
            }
            //等两个暂时退到了可以比较的部分，就进行比较并向前一格
            if (S.charAt(i--) != T.charAt(j--)){
                return false;
            }
        }
        return i==j;
    }

}
