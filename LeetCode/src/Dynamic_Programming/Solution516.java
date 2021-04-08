package Dynamic_Programming;

public class Solution516 {
    public int longestPalindromeSubseq(String s) {
        char[] chars = s.toCharArray();
        int len = chars.length;
        int[][] dp = new int[len][len];
        // dp[i][j] 表示i j 内的回文子序列长度
        for (int i = len - 1; i >= 0; i--){
            // 单个字符肯定构成
            dp[i][i] = 1;
            for (int j = i + 1; j < len; j++){
                if (chars[i] == chars[j]) dp[i][j] = dp[i + 1][j - 1] + 2;
                else dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
            }
        }
        return dp[0][len - 1];
    }
}
