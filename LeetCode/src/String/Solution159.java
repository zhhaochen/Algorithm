package String;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string s , find the length of the longest substring t  that contains at most 2 distinct characters.
 *
 * Example 1:
 * Input: "eceba"
 * Output: 3
 * Explanation: tis "ece" which its length is 3.
 *
 * Example 2:
 * Input: "ccaabbb"
 * Output: 5
 * Explanation: tis "aabbb" which its length is 5.
 */
public class Solution159 {
    public int lengthOfLongestSubstringTwoDistinct(String s){
        int max = 0;
        Map<Character, Integer> map = new HashMap<>();
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), i);
            while (map.size() > 2){
                if (left == map.get(s.charAt(left))) map.remove(s.charAt(left));
                left++;
            }
            max = Math.max(i - left + 1, max);
        }
        return max;
    }
}
