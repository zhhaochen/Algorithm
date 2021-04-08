package Hot100;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution17 {
    public List<String> letterCombinations(String digits) {
        Map<Integer, String> map = new HashMap<>();
        String[] memo = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        StringBuilder sb = new StringBuilder();
        List<String> res = new ArrayList<>();
        backtrack(memo, res, sb, digits.toCharArray(), 0);
        return res;
    }
    private void backtrack(String[] memo, List<String> res, StringBuilder sb, char[] digits, int index){
        if (index >= digits.length){
            res.add(sb.toString());
            return;
        }
        char[] tmp = memo[(digits[index] - '2')].toCharArray();
        for (char c : tmp){
            sb.append(c);
            backtrack(memo, res, sb, digits, index + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
