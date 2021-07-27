package ByteDance;

import java.util.LinkedList;
import java.util.Queue;

public class Solution1269 {
    public int numWays_dp(int steps, int arrLen) {
        // 注意这里需要判断最远能走到哪座位优化
        int maxColumn = Math.min(arrLen - 1, steps);
        int[][] dp = new int[2][maxColumn + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= steps; i++){
            for (int j = 0; j <= maxColumn; j++){
                dp[i % 2][j] = dp[(i + 1) % 2][j];
                if (j != 0) dp[i % 2][j] += dp[(i + 1) % 2][j-1];
                dp[i % 2][j] %= 1000000007;
                if (j != arrLen - 1) dp[i % 2][j] += dp[(i + 1) % 2][j+1];
                dp[i % 2][j] %= 1000000007;
            }
        }
        return dp[steps % 2][0];
    }
    // 超时做法
    public int numWays_bfs(int steps, int arrLen) {
        int[] count = new int[arrLen];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        count[0] = 1;
        for (int i = 0; i < steps; i++) {
            int size = queue.size();
            while (size > 0) {
                int cur = queue.poll();
                queue.offer(cur);
                if (cur - 1 >= 0) {
                    count[cur - 1]++;
                    count[cur - 1] %= 1000000007;
                    queue.offer(cur - 1);
                }
                if (cur + 1 < arrLen) {
                    count[cur + 1]++;
                    count[cur + 1] %= 1000000007;
                    queue.offer(cur + 1);
                }
                size--;
            }
        }
        return count[0];
    }
}
