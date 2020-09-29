package Sliding_Window;

import java.util.HashMap;
import java.util.Map;

/**
 * 2020.09.29
 * Longest Substring Without Repeating Characters
 * Given a string s, find the length of the longest substring without repeating characters.
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 */
public class Solution3 {
    public int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        Map<Character, Integer> window = new HashMap<>();
        int left = 0, right = 0, len = 0;
        while (right < chars.length){
            char c = chars[right];
            // 如果当前没有放入，放入后置为1
            if (window.getOrDefault(c, 0).equals(0)){
                window.put(c, 1);
                right++;
                len = Math.max(len, right - left);
            }else {
                // 收缩窗口
                while (!window.getOrDefault(c, 0).equals(0)){
                    char t = chars[left++];
                    window.remove(t);
                }
            }
        }
        return len;
    }
    public int lengthOfLongestSubstring2(String s) {
        char[] chars = s.toCharArray();
        Map<Character, Integer> window = new HashMap<>();
        int left = 0, right = 0, len = 0;
        while (right < chars.length){
            char c = chars[right++];
            // 如果当前没有放入，放入后置为1
            window.put(c, window.getOrDefault(c, 0) + 1);
            while (window.get(c) > 1){
                char t = chars[left++];
                window.put(t, window.get(t) - 1);
            }
            len = Math.max(len, right - left);
        }
        return len;
    }
}
