package JianZhiOffer;

public class Solution46 {
    public int translateNum(int num) {
        char[] chars = ("" + num).toCharArray();
        int[] dp = new int[chars.length + 1];
        dp[0] = 1; dp[1] = 1;
        for (int i = 2; i < dp.length; i++){
            if (chars[i - 2] - '0' == 1) dp[i] = dp[i - 1] + dp[i - 2];
            else if (chars[i - 2] - '0' == 2 && chars[i - 1] - '0' < 6) dp[i] = dp[i - 1] + dp[i - 2];
            else dp[i] = dp[i - 1];
        }
        return dp[dp.length - 1];
    }
}
