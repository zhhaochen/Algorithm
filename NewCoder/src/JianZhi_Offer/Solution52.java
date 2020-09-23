package JianZhi_Offer;

/**
 * 请实现一个函数用来匹配包括'.'和'*'的正则表达式。
 * 模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（包含0次）。
 * 注意 * 必须前面必须要有值
 * 在本题中，匹配是指字符串的所有字符匹配整个模式。例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
 */
public class Solution52 {
    public static void main(String[] args) {
        char[] str = "aaa".toCharArray();
        char[] pattern = "a*a".toCharArray();
        boolean is_match = match(str, pattern);
        System.out.println(is_match);
    }
    public static boolean match(char[] str, char[] pattern) {
        int m = str.length, n = pattern.length;
        // 动态规划数组
        boolean[][] dp = new boolean[m + 1][n + 1];
        // 起始状态为true
        dp[0][0] = true;
        for (int i = 1; i <= n; i++)
            if (pattern[i - 1] == '*')
                // 因为出现 * 要求 * 前面要有值，所以从 i - 2开始，不会出现开头就有*的情况
                dp[0][i] = dp[0][i - 2];
        // 遍历 str
        for (int i = 1; i <= m; i++)
            // 遍历 pattern
            for (int j = 1; j <= n; j++)
                // 如果对应相等或者出现替代符号，则当前字符匹配成功，状态与上一个状态相等
                if (str[i - 1] == pattern[j - 1] || pattern[j - 1] == '.')
                    dp[i][j] = dp[i - 1][j - 1];
                // 如果当前为 pattern 的符号为 *
                else if (pattern[j - 1] == '*')
                    // 如果 * 前一个符号与当前str的符号相等或者前一个符号为. 为.意味着可以匹配任意字符
                    if (pattern[j - 2] == str[i - 1] || pattern[j - 2] == '.') {
                        // 来一波或操作，穷举三种情况进行匹配，有一种成功即可
                        dp[i][j] |= dp[i][j - 1]; // a* 前面的a只匹配了1次，即看通配符前面的
                        dp[i][j] |= dp[i - 1][j]; // a* 前面的a匹配了多次，即pattern的指针不变，还可以接着匹配
                        dp[i][j] |= dp[i][j - 2]; // a* 前面的a一次也没匹配，即跳过前一个和通配符*
                    } else
                        // 说明前一个匹配失败，直接跳过
                        dp[i][j] = dp[i][j - 2];  // a* 前面的a一次没匹配

        return dp[m][n];
    }
}
