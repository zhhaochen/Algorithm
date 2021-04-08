package Matrix;

public class Solution498 {
    public int[] findDiagonalOrder(int[][] matrix) {
        int m = matrix.length;
        if(m == 0) return new int[0];
        int n = matrix[0].length;
        if(m * n == 0) return new int[0];
        int[] res = new int[m * n];
        int index = 0;
        // 遍历次数为 m + n - 1
        int count = m + n - 1;
        // 其实每一趟的 row + col = i 即坐标和为趟数
        int row = 0, col = 0;
        for (int i = 0; i < count; i++){
            // 此时为从下网上走 行数-1 列数+1
            if (i % 2 == 0){
                // 开始坐标
                while (row >= 0 && col < n) res[index++] = matrix[row--][col++];
                // 更新 row 和 col，先恢复到正常的步骤
                row++; col--;
                // 优先 clo+1，否则 row + 1
                if(col + 1 < n) col++;
                else row++;
            }
            // 从上往下走，行数+1， 列数-1
            else{
                while (row < m && col >= 0) res[index++] = matrix[row++][col--];
                // 更新 row 和 col，先恢复到正常的步骤
                row--; col++;
                // 优先 clo+1，否则 row + 1
                if(row + 1 < m) row++;
                else col++;
            }
        }
        return res;
    }
}
