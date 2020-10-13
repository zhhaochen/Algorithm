package Top100;

/**
 * 2020.10.13
 * Given a string, your task is to count how many palindromic substrings in this string.
 * The substrings with different start indexes or end indexes are counted as different substrings even they consist of same characters.
 * Input: "aaa"
 * Output: 6
 * Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
 */
public class Palindromic_Substrings {
    public static void main(String[] args) {
        int res = new Palindromic_Substrings().countSubstrings("aaa");
        System.out.println(res);
    }
    public int countSubstrings(String s) {
        if (s == null || s.length() == 0){
            return 0;
        }
        char[] chars = s.toCharArray();
        int len = chars.length;
        // dp[i][j]代表s[i,...j]是否为回文
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++){
            dp[i][i] = true;
        }
        int count = len;
        for (int i = len-2; i >= 0; i--){
            for (int j = i + 1; j < len; j++){
                if (chars[i] == chars[j]){
                    if (j - i == 1){
                        dp[i][j] = true;
                    }else {
                        dp[i][j] = dp[i+1][j-1];
                    }
                    if (dp[i][j]){
                        count++;
                    }
                }
            }
        }
        return count;
    }
}
