package Sliding_Window;

import java.util.HashMap;
import java.util.Map;

/**
 * 2020.09.29
 * Permutation in String
 * 给定两个字符串，判断s1的一个排列是否为s2字串
 * Input: s1 = "ab" s2 = "eidbaooo"
 * Output: True
 * Explanation: s2 contains one permutation of s1 ("ba").
 *
 * Input:s1= "ab" s2 = "eidboaoo"
 * Output: False
 */
public class Solution567 {
    public boolean checkInclusion(String s1, String s2) {
        char[] chars_1 = s1.toCharArray();
        char[] chars_2 = s2.toCharArray();
        if (chars_1.length > chars_2.length){
            return false;
        }
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for (int i = 0; i < chars_1.length; i++){
            need.put(chars_1[i], need.getOrDefault(chars_1[i], 0) + 1);
        }
        int left = 0, right = 0, valid = 0;
        while (right < chars_2.length){
            // 放入窗口的字符
            char c = chars_2[right];
            // 窗口右移
            right++;
            // 数据操作
            if (need.containsKey(c)){
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c))){
                    valid++;
                }
            }
            // 缩小窗口
            while (right - left >= chars_1.length){
                // 是否满足
                if (valid == need.size()){
                    return true;
                }
                // 当前字符
                char d = chars_2[left];
                // 窗口缩小
                left++;
                if (need.containsKey(d)){
                    if (window.get(d).equals(need.get(d))){
                        valid--;
                    }
                    window.put(d, window.get(d) - 1);
                }
            }
        }
        return false;
    }
}
