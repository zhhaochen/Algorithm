package JianZhi_Offer;

import java.util.ArrayList;

/**
 * 2019.11.7
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，例如，如果输入如下4 X 4矩阵：
 * 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 */
public class Solution19 {

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,2,3,4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        int[][] matrix2 = new int[][]{{1}, {2}, {3}, {4}, {5}};
        ArrayList<Integer> list = printMatrix(matrix2);
        System.out.println(list);
    }

    public static ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        int left = 0;
        int right = matrix[0].length - 1;
        int up = 0;
        int down = matrix.length - 1;
        while (left <=right && up<=down){ //必须在此限定内
            //先从左到右
            for (int i = left; i<=right; i++){
                list.add(matrix[up][i]);
            }
            up++;
            //如果只有一行
            if (up > down){
                break;
            }
            //从上到下
            for (int i = up; i<=down; i++){
                list.add(matrix[i][right]);
            }
            right--;
            //如果只有一列
            if (right < left){
                break;
            }
            //从右到左
            for (int i = right; i>=left; i--){
                list.add(matrix[down][i]);
            }
            down--;

            //从下到上
            for (int i = down; i>=up; i--){
                list.add(matrix[i][left]);
            }
            left++;
        }
        return list;
    }
}
