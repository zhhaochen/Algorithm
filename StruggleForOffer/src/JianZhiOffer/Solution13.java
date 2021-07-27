package JianZhiOffer;

public class Solution13 {
    public int movingCount(int m, int n, int k) {
        boolean[][] visit = new boolean[m][n];
        return backtrack(m, n, 0, 0, k, visit);
    }

    private int backtrack(int m, int n, int i, int j, int k, boolean[][] visit){
        if (i < 0 || i >= m || j < 0 || j >= n) return 0;
        if (visit[i][j]) return 0;
        if (check(i, j, k)){
            visit[i][j] = true;
            return 1 + backtrack(m, n, i - 1, j, k, visit)
                    + backtrack(m, n, i + 1, j, k, visit)
                    + backtrack(m, n, i, j - 1, k, visit)
                    + backtrack(m, n, i, j + 1, k, visit);
        }
        return 0;
    }

    private boolean check(int row, int col, int k){
        int sum = 0;
        while (row > 0){
            sum += row % 10;
            row /= 10;
        }
        while (col > 0){
            sum += col % 10;
            col /= 10;
        }
        return sum <= k;
    }
}
