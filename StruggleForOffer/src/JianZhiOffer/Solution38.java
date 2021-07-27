package JianZhiOffer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Solution38 {
    public String[] permutation(String s) {
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        helper(chars, list, sb, 0);
        String[] res = new String[list.size()];
        list.toArray(res);
        return res;
    }
    private void helper(char[] chars, List<String> list, StringBuilder sb, int index){
        if (sb.length() == chars.length){
            list.add(sb.toString());
            return;
        }
        HashSet<Character> set = new HashSet<>();
        for (int i = index; i < chars.length; i++){
            if (!set.contains(chars[i])){
                set.add(chars[i]);
                swap(chars, index, i);
                sb.append(chars[index]);
                helper(chars, list, sb, index + 1);
                sb.deleteCharAt(sb.length() - 1);
                swap(chars, index, i);
            }
        }
    }
    private void swap(char[] chars, int i, int j){
        char tmp = chars[i];
        chars[i] = chars[j];
        chars[j] = tmp;
    }
}
