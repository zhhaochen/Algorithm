package Hot100;

import java.util.HashMap;
import java.util.Map;

public class Solution279 {
    public int numSquares(int n) {
        if (n <= 3) return n;
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++){
            if (i <= 3){
                dp[i] = i;
                continue;
            }
            dp[i] = i;
            for (int j = 1; j <= i / 2; j++){
                if (j * j == i){
                    dp[i] = 1;
                    break;
                }
                dp[i] = Math.min(dp[i], dp[j] + dp[i-j]);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int res = new Solution279().numSquares(7168);
        System.out.println(res);
    }
}
