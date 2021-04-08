import java.util.Arrays;

public class Solution60 {
    // 感觉是个背包问题
    public double[] dicesProbability(int n) {
        int[] dp = new int[6 * n + 1];
        // 扔完第一个骰子
        for (int i = 1; i <= 6; i++) dp[i] = 1;
        // 从第2个骰子开始
        for (int i = 2; i <= n; i++){
            // 有 i 个骰子时的最大最小值范围
            for (int j = 6 * i; j >= i; j--){
                // 防止上一个骰子留下的脏数据，现在3个骰子，dp[j]是用两个骰子组成j的方法数，是脏数据
                // 因为是倒着来的，不用担心会损失数据
                dp[j] = 0;
                for (int cur = 1; cur <= 6; cur++){
                    // 上一轮的最小值
                    if (j - cur < i - 1) break;
                    dp[j] += dp[j - cur];
                }
            }
        }
        double ans = Math.pow(6, n);
        double[] res = new double[5 * n + 1];
        for (int i = 6 * n; i >= n; i--) {
            res[i - n] = dp[i] / ans;
        }
        return res;
    }

    public static void main(String[] args) {
        double[] res = new Solution60().dicesProbability(2);
        System.out.println(Arrays.toString(res));
    }
}
