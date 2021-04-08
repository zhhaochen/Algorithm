package Tencent;

import java.util.HashMap;
import java.util.Map;

public class Solution3 {
    public int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        int start = 0;
        int max = 0;
        for (int i = 0; i < chars.length; i++){
            if (map.containsKey(chars[i]) && start <= map.get(chars[i])){
                max = Math.max(max, i - start);
                start = map.get(chars[i]) + 1;
            }
            map.put(chars[i], i);
        }
        return Math.max(max, chars.length - start);
    }
}
