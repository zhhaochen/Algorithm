package Sliding_Window;

import java.util.HashMap;
import java.util.Map;

/**
 * 2020.09.29
 * Minimum Window Substring
 * Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).
 * Input: S = "ADOBECODEBANC", T = "ABC"
 * Output: "BANC"
 */
public class Solution76 {
    public String minWindow(String s, String t) {
        char[] chars_s = s.toCharArray();
        char[] chars_t = t.toCharArray();
        if (s.length() < t.length()){
            return "";
        }
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for (int i = 0; i < chars_t.length; i++){
            need.put(chars_t[i], need.getOrDefault(chars_t[i], 0) + 1);
        }
        int left = 0, right = 0, valid = 0;
        // 记录最小覆盖子串的起始索引及长度
        int start = 0, len = Integer.MAX_VALUE;
        while (right < chars_s.length){
            // 移入窗口的字符
            char c = chars_s[right];
            // 右移窗口
            right++;
            // 进行窗口内数据的一系列更新
            if (need.containsKey(c)){
               window.put(c, window.getOrDefault(c, 0) + 1);
               if (window.get(c).equals(need.get(c))){
                   valid++;
               }
            }
            // 判断左侧窗口是否需要收缩
            while (valid == need.size()){
                // 这里不需要 + 1，因为right已经右移
                if (right - left < len){
                    start = left;
                    len = right - left;
                }
                // 移出窗口的字符
                char d = chars_s[left];
                // 左移窗口
                left++;
                // 进行窗口内数据的一系列更新
                if (need.containsKey(d)){
                    if (window.get(d).equals(need.get(d))){
                        valid--;
                    }
                    window.put(d, window.get(d) - 1);
                }
            }
        }
        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }
}
