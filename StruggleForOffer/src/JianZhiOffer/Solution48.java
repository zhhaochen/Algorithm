package JianZhiOffer;

import java.util.HashMap;
import java.util.Map;

public class Solution48 {
    public int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        int left = -1;
        for (int i = 0; i < chars.length; i++){
            int pre = map.getOrDefault(chars[i], -1);
            if (pre >= left) left = pre + 1;
            max = Math.max(max, i - left + 1);
            map.put(chars[i], i);
        }
        return max;
    }
}
