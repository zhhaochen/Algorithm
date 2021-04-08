package Dynamic_Programming;

public class Solution91 {
    public int numDecodings(String s) {
        char[] chars = s.toCharArray();
        int[] dp = new int[chars.length + 1];
        if (chars.length > 0 && chars[0] == '0') return 0;
        dp[0] = 1; dp[1] = 1;
        for (int i = 1; i < chars.length; i++){
            int cur = chars[i] - '0';
            // 判断是不是 0
            if (cur == 0){
                if (chars[i-1] != '1' && chars[i-1]!='2') return 0;
                else dp[i + 1] = dp[i - 1];
            }else{
                // 判断前一位是不是 1 和 2
                if (chars[i-1] == '1') dp[i + 1] = dp[i] + dp[i-1];
                else if(chars[i-1] == '2' && cur < 7) dp[i + 1] = dp[i] + dp[i-1];
                else dp[i + 1] = dp[i];
            }
        }
        return dp[chars.length];
    }
}
