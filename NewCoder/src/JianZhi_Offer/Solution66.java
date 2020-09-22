package JianZhi_Offer;

/**
 * 地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，
 * 但是不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。
 * 但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
 * 注意，并不是一条路走到头，而是扩散开来，从起始点出发所能到达的所有点
 */
public class Solution66 {
    public int movingCount(int threshold, int rows, int cols) {
        if (threshold < 0 || rows < 1 || cols < 1) {
            return 0;
        }
        boolean[] visited = new boolean[rows * cols];
        for (int i = 0; i < rows * cols; i++) {
            visited[i] = false;
        }
        int count = movingCount(threshold, rows, cols, 0, 0, visited);
        return count;
    }

    private int movingCount(int threshold, int rows, int cols, int row, int col, boolean[] visited) {
        int count = 0;
        if (check(threshold, rows, cols, row, col, visited)) {
            visited[row * cols + col] = true;
            count = 1 + movingCount(threshold, rows, cols, row - 1, col, visited)
                    + movingCount(threshold, rows, cols, row + 1, col, visited)
                    + movingCount(threshold, rows, cols, row, col - 1, visited)
                    + movingCount(threshold, rows, cols, row, col + 1, visited);
        }
        return count;
    }

    private boolean check(int threshold, int rows, int cols, int row, int col, boolean[] visited) {
        return (
                row >= 0 &&
                        row < rows &&
                        col >= 0 &&
                        col < cols &&
                        !visited[row * cols + col]
                        && (getDigitSum(col) + getDigitSum(row)) <= threshold
        );
    }

    private int getDigitSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}
