package Amazon;

public class Solution1310 {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int[] dp = new int[arr.length];
        dp[0] = arr[0];
        for (int i = 1; i < arr.length; i++) dp[i] = arr[i] ^ dp[i-1];
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++){
            if (queries[i][0] == 0) res[i] = dp[queries[i][1]];
            else res[i] = dp[queries[i][1]] ^ dp[queries[i][0] - 1];
        }
        return res;
    }
}
