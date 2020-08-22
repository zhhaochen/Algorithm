package Challenge_30_Day.May.week3;

/**
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.
 * Note: You can only move either down or right at any point in time.
 * <p>
 * Input:
 * [
 * [1,3,1],
 * [1,5,1],
 * [4,2,1]
 * ]
 * Output: 7
 * Explanation: Because the path 1→3→1→1→1 minimizes the sum.
 */
public class Minimum_Path_Sum {
    public static void main(String[] args) {
        int[][] grid = new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
    }

    public int minPathSum(int[][] grid) {
        return dfs(grid, 0, 0);
    }

    private int dfs(int[][] grid, int i, int j) {
        if (i >= grid.length || j >= grid[0].length) {
            return -1; //如果用0的话，会导致比较时出错，没有相应地运动，所以在-1时处理
        }
        int right = dfs(grid, i, j + 1);
        int down = dfs(grid, i + 1, j);
        if (right == -1 && down == -1) {
            return grid[i][j];
        } else if (right == -1 || down == -1) {
            return grid[i][j] + Math.max(right, down);
        }
        return grid[i][j] + Math.min(right, down);
    }
}
