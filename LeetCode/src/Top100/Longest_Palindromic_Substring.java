package Top100;

/**
 * 2020.08.22
 * Given a string s, find the longest palindromic substring in s.
 * You may assume that the maximum length of s is 1000.
 * <p>
 * Example 1:
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 * <p>
 * Example 2:
 * Input: "cbbd"
 * Output: "bb"
 */
public class Longest_Palindromic_Substring {
    private String res = "";

    public String longestPalindrome(String s) {
        int len = s.length();
        if (len == 0 || len == 1) {
            return s;
        }
        for (int i = 0; i < len; i++) {
            check(s, i, i);
            check(s, i, i + 1);
        }
        return res;
    }

    private void check(String s, int i, int j) {
        while (i >= 0 && j < s.length()) {
            if (s.charAt(i) == s.charAt(j)) {
                if (j - i + 1 > res.length()){
                    res = s.substring(i, j+1);
                }
                i--;
                j++;
            } else {
                break;
            }
        }
    }
}
