package Sliding_Window;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 2020.09.29
 * Find All Anagrams in a String
 *
 * Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.
 * Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.
 * The order of output does not matter.
 * Input:
 * s: "cbaebabacd" p: "abc"
 * Output:
 * [0, 6]
 * Explanation:
 * The substring with start index = 0 is "cba", which is an anagram of "abc".
 * The substring with start index = 6 is "bac", which is an anagram of "abc".
 */
public class Solution438 {
    public static void main(String[] args) {
        Solution438 res = new Solution438();
        res.findAnagrams("abaacbabc", "abc");
    }
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        char[] chars_s = s.toCharArray();
        char[] chars_p = p.toCharArray();
        if (chars_s.length < chars_p.length){
            return res;
        }
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for (int i = 0; i<chars_p.length; i++){
            need.put(chars_p[i], need.getOrDefault(chars_p[i], 0) + 1);
        }
        int left = 0, right = 0, valid = 0;
        while (right < chars_s.length){
            char t = chars_s[right];
            right++;
            if (need.containsKey(t)){
                window.put(t, window.getOrDefault(t, 0) + 1);
                if (window.get(t).equals(need.get(t))){
                    valid++;
                }
            }
            // 1、这里实行的是长度够了就校验的策略
            while (right - left >= chars_p.length){
                if (valid == need.size()){
                    res.add(left);
                }
                char f = chars_s[left];
                left++;
                if (need.containsKey(f)){
                    if (window.get(f).equals(need.get(f))){
                        valid--;
                    }
                    window.put(f, window.get(f) - 1);
                }
            }
            // 2、也可以实行符合标准就校验的策略
//            while (valid == need.size()){
//                char f = chars_s[left];
//                left++;
//                if (need.containsKey(f)){
//                    if (window.get(f).equals(need.get(f))){
//                        valid--;
//                        if(right - left + 1 == chars_p.length){
//                            res.add(left - 1);
//                        }
//                    }
//                    window.put(f, window.get(f) - 1);
//                }
//            }
        }
        return res;
    }
}
