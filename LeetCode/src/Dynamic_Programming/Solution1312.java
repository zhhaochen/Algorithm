package Dynamic_Programming;

/**
 * 2020.10.05
 * Minimum Insertion Steps to Make a String Palindrome
 * Given a string s. In one step you can insert any character at any index of the string.
 * Return the minimum number of steps to make s palindrome.
 * A Palindrome String is one that reads the same backward as well as forward.
 * Input: s = "mbadm"
 * Output: 2
 * Explanation: String can be "mbdadbm" or "mdbabdm".
 */
public class Solution1312 {
    public static void main(String[] args) {
        Solution1312 test = new Solution1312();
        test.minInsertions("mbadm");
    }
    public int minInsertions(String s) {
        if (s == null || s.length() == 0 || s.length() == 1) {
            return 0;
        }
        char[] chars = s.toCharArray();
        int len = chars.length;
        // dp[i][j]为s[i,...,j]构成回文的最小插入次数，对角线上天然为0
        int[][] dp = new int[len][len];
        for (int i = len - 2; i >= 0; i--) {
            for (int j = 1; j < len; j++) {
                if (i >= j) {
                    continue;
                    //dp[i][j] = 0;
                }
                // 需要 i 从大的开始，j从小的开始
                if (chars[i] == chars[j]) {
                    dp[i][j] = dp[i + 1][j - 1];
                } else {
                    // 保证需要的已经算出来
                    dp[i][j] = Math.min(dp[i + 1][j], dp[i][j - 1]) + 1;
                }
            }
        }
        return dp[0][len - 1];
    }
}
