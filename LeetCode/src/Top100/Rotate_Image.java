package Top100;

/**
 * 2020.09.10
 * 旋转图像，给一副 n x n 的图像，顺时针旋转90度
 * 只准直接在数组上操作，不能另建一个数组进行操作
 * <p>
 * Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * Output: [[7,4,1],[8,5,2],[9,6,3]]
 */
public class Rotate_Image {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {5, 1, 9, 11},
                {2, 4, 8, 10},
                {13, 3, 6, 7},
                {15, 14, 12, 16}
        };
        rotate(matrix);
    }

    public static void rotate(int[][] matrix) {
        // 记录每个正方形的边长
        int len = matrix.length;
        int start = 0;
        while (len != 1 && len != 0) {
            // 同一个正正方形上循环变动的次数
            for (int i = start; i < start + len - 1; i++) {
                // 注意每个坐标与start和len的关系
                int tmp = matrix[start][i];
                matrix[start][i] = matrix[2 * start + len - 1 - i][start];
                matrix[2 * start + len - 1 - i][start] = matrix[start + len - 1][2 * start + len - 1 - i];
                matrix[start + len - 1][2 * start + len - 1 - i] = matrix[i][start + len - 1];
                matrix[i][start + len - 1] = tmp;
            }
            start++;
            len -= 2;
        }
    }
}
