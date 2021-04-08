package Tencent;

public class Solution59 {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int left = 0, top = 0, right = n - 1, bottom = n - 1;
        int cur = 1;
        while (left <= right && top <= bottom){
            // 上面一行走到头
            for (int i = left; i <= right; i++) res[top][i] = cur++;
            // 竖着一列走到头
            for (int i = top + 1; i <= bottom; i++) res[i][right] = cur++;
            // 避免只有一行或者一列的情况
            if (top != bottom){
                for (int i = right - 1; i >= left; i--) res[bottom][i] = cur++;
            }
            if (left != right){
                for (int i = bottom - 1; i > top; i--) res[i][left] = cur++;
            }
            left++; top++; right--; bottom--;
        }
        return res;
    }
}
