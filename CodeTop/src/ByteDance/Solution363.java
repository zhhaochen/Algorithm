package ByteDance;

import java.util.TreeSet;

public class Solution363 {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int row = matrix.length, col = matrix[0].length;
        int max = Integer.MIN_VALUE;
        // 左边界
        for (int l = 0; l < col; l++){
            // 记录[l, r]之间的行和
            int[] rowSum = new int[row];
            for (int r = l; r < col; r++){
                // 更新边界内的行和
                for (int i = 0; i < row; i++) rowSum[i] += matrix[i][r];
                TreeSet<Integer> sumSet = new TreeSet<Integer>();
                sumSet.add(0);
                int s = 0;
                for (int v : rowSum) {
                    // 记录的是当前的矩形面积，以[l, r]为左右边界，从上到下
                    s += v;
                    // 查看集合中 当前面积 减去 目标k面积 的矩形面积的面积，需要大于等于的最小值，记录为tmp
                    // 则这两块之间的面积 s - tmp <= k，且是目前接近k的最大值
                    Integer ceil = sumSet.ceiling(s - k);
                    if (ceil != null) {
                        max = Math.max(max, s - ceil);
                    }
                    sumSet.add(s);
                }
            }
        }
        return max;
    }
}
