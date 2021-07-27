package JianZhiOffer;

public class Solution29 {
    public int[] spiralOrder(int[][] matrix) {
        int m = matrix.length;
        if (m == 0) return new int[0];
        int n = matrix[0].length;
        int[] res = new int[m * n];
        int left = 0, top = 0;
        int right = n - 1, bottom = m - 1;
        int index = 0;
        while (left <= right && top <= bottom){
            // 左到右
            for (int i = left; i <= right; i++) res[index++] = matrix[top][i];
            // 上到下
            for (int i = top + 1; i <= bottom; i++) res[index++] = matrix[i][right];
            // 右到左
            if (top != bottom){
                for (int i = right - 1; i >= left; i--) res[index++] = matrix[bottom][i];
            }
            // 下到上
            if (left != right){
                for (int i = bottom - 1; i > top; i--) res[index++] = matrix[i][left];
            }
            left++; top++; bottom--; right--;
        }
        return res;
    }
}
