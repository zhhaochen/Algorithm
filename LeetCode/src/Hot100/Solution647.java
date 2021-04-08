package Hot100;

public class Solution647 {
    public int countSubstrings(String s) {
        int len = s.length();
        int res = 0;
        int[][] dp = new int[len][len];
        char[] tmp = s.toCharArray();
        for (int i = len - 1; i >= 0; i--){
            for (int j = i; j < len; j++){
                if (i == j) dp[i][j] = 1;
                if (tmp[i] == tmp[j]){
                    if (j == i + 1) dp[i][j] = 1;
                    else dp[i][j] = dp[i-1][j+1];
                }
                res += dp[i][j];
            }
        }
        return res;
    }
}
