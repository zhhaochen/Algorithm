package Baidu;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Offer_Solution38 {
    public String[] permutation(String s) {
        List<String> res = new ArrayList<>();
        char[] chars = s.toCharArray();
        backtrack(chars, 0, res);
        String[] strings = new String[res.size()];
        res.toArray(strings);
        return strings;
    }

    public void backtrack(char[] chars, int index, List<String> res){
        if (index == chars.length - 1){
            res.add(new String(chars));
            return;
        }
        Set<Character> set = new HashSet<>();
        for (int i = index; i < chars.length; i++){
            if (!set.contains(chars[i])){
                set.add(chars[i]);
                swap(chars, index, i);
                backtrack(chars, index + 1, res);
                swap(chars, index, i);
            }
        }
    }

    public void swap(char[] chars, int i, int j){
        char tmp = chars[i];
        chars[i] = chars[j];
        chars[j] = tmp;
    }
}
