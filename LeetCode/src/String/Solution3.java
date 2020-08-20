package String;

import java.util.HashMap;
import java.util.Map;

/**
 * 2020.5.16
 * Longest Substring Without Repeating Characters
 *
 * Given a string, find the length of the longest substring without repeating characters.
 * Input: "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 */
public class Solution3 {
    public static void main(String[] args) {
        String s = "abba";
        lengthOfLongestSubstring(s);
    }
    public static int lengthOfLongestSubstring(String s) {
        int res = 0;
        int len = s.length();
        int left = -1;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (map.get(c) != null && map.get(c) > left){ //TODO 根据位置判断是否在这个窗口内，最重要的地方
                left = map.get(c);
            }
            map.put(c, i);
            res = Math.max(res, i-left);
        }
        return res;
    }
}
