package Challenge_30_Day.week3;

/**
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.
 * Note: You can only move either down or right at any point in time
 * Input:
 * [
 * [1,3,1],
 * [1,5,1],
 * [4,2,1]
 * ]
 * Output: 7
 * Explanation: Because the path 1→3→1→1→1 minimizes the sum.
 * 本来以为是用dfs，然而在数据量大的时候超时，后来知道这是一个动态规划问题
 */
public class Minimum_Path_Sum_ {
    public static void main(String[] args) {
        int[][] grid = new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
    }

    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        //首行和首列上的最小路径是固定的
        for (int i=1; i<m; i++){
            dp[i][0] = grid[i][0] + dp[i-1][0];
        }
        for (int j=1; j<n;j++){
            dp[0][j] = grid[0][j] + dp[0][j-1];
        }
        for (int i=1; i<m; i++){
            for (int j=1; j<n; j++){
                dp[i][j] = grid[i][j] + Math.min(dp[i-1][j], dp[i][j-1]);
            }
        }
        return dp[m-1][n-1];
    }
    public int minPathSum2(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        //首行和首列上的最小路径是固定的
        for (int i=0; i<m; i++){
            for (int j=0; j<n; j++){
                if (i==0 && j!=0){
                    grid[i][j] += grid[i][j-1];
                }else if (i!=0&&j==0){
                    grid[i][j] += grid[i-1][j];
                }
                if (i!=0 && j!=0){
                    grid[i][j] += Math.min(grid[i-1][j], grid[i][j-1]);
                }
            }
        }
        return grid[m-1][n-1];
    }
}
