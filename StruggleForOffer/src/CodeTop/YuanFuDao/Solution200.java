package CodeTop.YuanFuDao;

public class Solution200 {
    public int numIslands(char[][] grid) {
        boolean[][] visit = new boolean[grid.length][grid[0].length];
        int res = 0;
        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[0].length; j++){
                if (grid[i][j] == '1' && !visit[i][j]){
                    dfs(grid, visit, i, j);
                    res++;
                }
            }
        }
        return res;
    }

    private void dfs(char[][] grid, boolean[][] visit, int i, int j){
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || visit[i][j]) return;
        if (grid[i][j] == '0') return;
        visit[i][j] = true;
        dfs(grid, visit, i - 1, j);
        dfs(grid, visit, i + 1, j);
        dfs(grid, visit, i, j - 1);
        dfs(grid, visit, i, j + 1);
    }
}
