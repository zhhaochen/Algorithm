package ByteDance;

public class Solution91 {
    public int numDecodings(String s) {
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        if (s.charAt(0) != '0') dp[1] = 1;
        for (int i = 1; i < s.length(); i++){
            // 当前为 0
            if (s.charAt(i) == '0'){
                if (s.charAt(i-1) == '1' || s.charAt(i-1) == '2') dp[i+1] = dp[i-1];
                else return 0;
            }else if (s.charAt(i) <= '6'){
                if (s.charAt(i-1) == '1' || s.charAt(i-1) == '2') dp[i+1] = dp[i-1] + dp[i];
                else dp[i+1] = dp[i];
            }else {
                if (s.charAt(i-1) == '1') dp[i+1] = dp[i-1] + dp[i];
                else dp[i+1] = dp[i];
            }
        }
        return dp[s.length()];
    }
}
