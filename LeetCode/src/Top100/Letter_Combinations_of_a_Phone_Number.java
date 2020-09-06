package Top100;

import java.util.LinkedList;
import java.util.List;

/**
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.
 * 拼音九键，组合
 * Input: "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 */
public class Letter_Combinations_of_a_Phone_Number {

    public List<String> letterCombinations(String digits) {
        int len = digits.length();
        List<String> res = new LinkedList<>();
        if (len == 0) {
            return res;
        }
        String[] map = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        for (int i = 0; i < len; i++) {
            List<String> tmp = new LinkedList<>();
            String str = map[digits.charAt(i) - '0'];
            for (int j = 0; j < str.length(); j++) {
                String s = String.valueOf(str.charAt(j));
                if (res.isEmpty()){
                    tmp.add(s);
                }else {
                    for (String r : res){
                        tmp.add(r + s);
                    }
                }
            }
            res = tmp;
        }
        return res;
    }

}
