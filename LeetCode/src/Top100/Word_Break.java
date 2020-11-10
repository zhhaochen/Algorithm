package Top100;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 2020.11.10
 * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words,
 * determine if s can be segmented into a space-separated sequence of one or more dictionary words.
 * The same word in the dictionary may be reused multiple times in the segmentation.
 * You may assume the dictionary does not contain duplicate words.
 *
 * Input: s = "leetcode", wordDict = ["leet", "code"]
 * Output: true
 * Explanation: Return true because "leetcode" can be segmented as "leet code".
 */
public class Word_Break {
    public boolean wordBreak(String s, List<String> wordDict) {
        Map<String, Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        for (String word : wordDict){
            map.put(word, 0);
        }
        // dp[i][j] 表示 s[i,...,j]能否查到
        boolean[][] dp = new boolean[chars.length][chars.length];
        // 从右下角开始
        for (int i = chars.length-1; i >= 0; i--){
            for (int j = i; j < chars.length; j++){
                if (map.containsKey(s.substring(i, j+1))){
                    dp[i][j] = true;
                }else {
                    // 判断其他组合能否可以
                    for (int k = i; k < j; k++){
                        dp[i][j] |= dp[i][k] && dp[k+1][j];
                    }
                }
            }
        }
        return dp[0][chars.length-1];
    }
}
