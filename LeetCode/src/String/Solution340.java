package String;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Given a string, find the length of the longest substring T that contains at most k distinct characters.
 *
 * Example 1:
 * Input: s = "eceba", k = 2
 * Output: 3
 * Explanation: T is "ece" which its length is 3.
 *
 * Example 2:
 * Input: s = "aa", k = 1
 * Output: 2
 * Explanation: T is "aa" which its length is 2.
 */
public class Solution340 {

    public int lengthOfLongestSubstringKDistinct(String s, int k){
        int max = 0;
        Map<Character, Integer> map = new HashMap<>();
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), i);
            while (map.size() > k){
                if (left == map.get(s.charAt(left))) map.remove(s.charAt(left));
                left++;
            }
            max = Math.max(i - left + 1, max);
        }
        return max;
    }

}
