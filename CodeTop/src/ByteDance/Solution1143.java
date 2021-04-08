package ByteDance;

public class Solution1143 {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];
        for (int i = 1; i <= text1.length(); i++){
            for (int j = 1; j <= text2.length(); j++){
                int left_top = dp[i-1][j-1];
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) left_top++;
                dp[i][j] = Math.max(left_top, Math.max(dp[i-1][j], dp[i][j-1]));
            }
        }
        return dp[text1.length()][text2.length()];
    }
}
