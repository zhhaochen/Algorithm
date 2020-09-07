package Top100;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 2020.09.07
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 * For example, given n = 3, a solution set is:
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 */
public class Generate_Parentheses {
    // 对每一个左括号，后面加一个全括号，巧妙解法，但无法理解，速度慢
    public List<String> generateParenthesis1(int n) {
        // 用set去重
        Set<String> res = new HashSet<>();
        if (n == 0){
            res.add("");
        }else {
            List<String> pre = generateParenthesis1(n-1);
            for (String str : pre){
                for (int i = 0; i<str.length(); i++){
                    if (str.charAt(i) == '('){
                        String tmp = str.substring(0, i+1) + "()" + str.substring(i+1, str.length());
                        res.add(tmp);
                    }
                }
            }
        }
        return new ArrayList(res);
    }

    // 神仙解法，容易理解，且速度快
    public List<String> generateParenthesis2(int n){
        List<String> res = new ArrayList<>();
        subGenerate(n, n, "", res);
        return res;
    }
    private void subGenerate(int left, int right, String out, List<String> res){
        // 当left > right的时候，说明组合的出现了类似"())"形式的情况，为了配对成功，必须先放"("
        if(left < 0 || right < 0 || left > right){
            return;
        }
        if (left == 0 && right == 0){
            res.add(out);
            return;
        }
        subGenerate(left - 1, right, out + "(", res);
        subGenerate(left, right - 1, out + ")", res);
    }
}
