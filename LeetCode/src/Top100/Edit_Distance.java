package Top100;

/**
 * 2020.10.8
 * Given two words word1 and word2, find the minimum number of operations required to convert word1 to word2.
 * You have the following 3 operations permitted on a word:
 * Insert a character
 * Delete a character
 * Replace a character
 * Input: word1 = "horse", word2 = "ros"
 * Output: 3
 * Explanation:
 * horse -> rorse (replace 'h' with 'r')
 * rorse -> rose (remove 'r')
 * rose -> ros (remove 'e')
 */
public class Edit_Distance {
    // 方法1，递归
    private int[][] memo;
    public int minDistance(String word1, String word2) {
        memo = new int[word1.length()][word2.length()];
        return dp(word1.toCharArray(), word2.toCharArray(), word1.length() - 1, word2.length() - 1);
    }

    public int dp(char[] word1, char[] word2, int i, int j) {
        if (i < 0 || j < 0) {
            return Math.abs(i - j);
        }

        if (memo[i][j] != 0){
            return memo[i][j];
        }

        if (word1[i] == word2[j]) {
            memo[i][j] = dp(word1, word2, i - 1, j - 1);
        } else {
            int add = dp(word1, word2, i, j - 1);
            int update = dp(word1, word2, i - 1, j - 1);
            int del = dp(word1, word2, i - 1, j);
            memo[i][j] = 1 + Math.min(add, Math.min(update, del));
        }
        return memo[i][j];
    }

    // 方法2，从方法1拓展过来，自底向上
    public int minDistance2(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m+1][n+1];
        for (int i = 1; i <= m; i++){
            dp[i][0] = i;
        }
        for (int j = 1; j <= n; j++){
            dp[0][j] = j;
        }
        char[] word1s = word1.toCharArray();
        char[] word2s = word2.toCharArray();
        for (int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                if (word1s[i - 1] == word2s[j - 1]){
                    dp[i][j] = dp[i-1][j-1];
                }else {
                    int add = dp[i][j - 1];
                    int update = dp[i - 1][j - 1];
                    int del = dp[i - 1][j];
                    dp[i][j] = 1 + Math.min(add, Math.min(update, del));
                }
            }
        }
        return dp[m][n];
    }
}
