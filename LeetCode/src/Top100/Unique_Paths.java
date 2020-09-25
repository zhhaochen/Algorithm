package Top100;

/**
 * 一个m行n列的矩阵，一个机器人从左上角开始运动，只能向右或者向左，到达右下角一共有几条路线
 */
public class Unique_Paths {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int j = 1; j < n; j++) {
            dp[0][j] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
            }
        }
        return dp[m - 1][n - 1];
    }
    // 耗费内存更小方法，只需要一个 2 x n的数组，因为当前状态只与上和左有关
    public int uniquePaths2(int m, int n) {
        int[][] dp = new int[2][n];
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }
        dp[1][0] = 1;
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i % 2][j] = dp[i % 2][j - 1] + dp[(i - 1) % 2][j];
            }
        }
        return dp[(m - 1) % 2][n - 1];
    }
}
