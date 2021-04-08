import java.util.HashMap;
import java.util.Map;

public class Solution48 {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        int start = -1;
        char[] chars = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < chars.length; i++){
            if (map.containsKey(chars[i]) && start < map.get(chars[i])){
                max = Math.max(max, i - start - 1);
                start = map.get(chars[i]);
            }
            map.put(chars[i], i);
        }
        return Math.max(max, chars.length - 1 - start);
    }
}
