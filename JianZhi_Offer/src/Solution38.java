import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution38 {
    public String[] permutation(String s) {
        char[] chars = s.toCharArray();
        List<String> list = new ArrayList<>();
        backtrack(chars, 0, list);
        String[] res = new String[list.size()];
        list.toArray(res);
        return res;
    }

    public void backtrack(char[] chars, int index, List<String> list){
        if (index == chars.length - 1){
            list.add(new String(chars));
            return;
        }
        Set<Character> set = new HashSet<>();
        // 位置交换
        for (int i = index; i < chars.length; i++){
            if (!set.contains(chars[i])){
                set.add(chars[i]);
                swap(chars, i, index);
                backtrack(chars, index + 1, list);
                swap(chars, i, index);
            }
        }
    }

    public void swap(char[] chars, int i, int j){
        char tmp = chars[i];
        chars[i] = chars[j];
        chars[j] = tmp;
    }
}
