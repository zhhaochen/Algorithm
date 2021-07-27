package JianZhiOffer;

public class Solution60 {
    public double[] dicesProbability(int n) {
        double[] res = new double[5 * n + 1];
        double base = 1 / 6.0;
        double[][] dp = new double[n][6 * n];
        for (int i = 0; i < 6; i++) dp[0][i] = base;
        for (int i = 1; i < n; i++){
            for (int j = i; j < 6 * (i + 1); j++){
                for (int k = 1; k <= Math.min(6, j); k++){
                    dp[i][j] += dp[i-1][j - k] * base;
                }
            }
        }
        for (int i = 0; i < res.length; i++) res[i] = dp[n-1][i + n - 1];
        return res;
    }
}
