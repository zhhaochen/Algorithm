package Hot100;

import Linked_List.Solution2;

public class Solution221 {

    public int maximalSquare2(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int max = 0;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (matrix[i][j] == '0') dp[i][j] = 0;
                else{
                    if (i == 0 || j == 0) dp[i][j] = 1;
                    else dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1])) + 1;
                }
                max = Math.max(max, dp[i][j]);
            }
        }
        return max * max;
    }
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int max = 0;
        // 记录正方形边长
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (matrix[i][j] == '0') dp[i][j] = 0;
                else{
                    dp[i][j] = 1;
                    if (i > 0 && j > 0 && dp[i-1][j-1] > 0){
                        // 注意这里从大到小进行尝试
                        for (int k = dp[i-1][j-1]; k > 0; k--){
                            if (check(matrix, i, i, j - k, j - 1) &&
                                    check(matrix, i - k, i - 1, j, j)){
                                dp[i][j] = k + 1;
                                break;
                            }
                        }
                    }
                }
                max = Math.max(max, dp[i][j]);
            }
        }
        return max * max;
    }
    private boolean check(char[][] matrix, int i, int j, int k, int l){
        for (int row = i; row <= j; row++){
            for (int col = k; col <= l; col++){
                if (matrix[row][col] == '0') return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String[] matrixs = {"0001", "1101", "1111", "0111", "0111"};
        char[][] matrix = new char[matrixs.length][matrixs[0].length()];
        for (int i = 0; i < matrix.length; i++){
            matrix[i] = matrixs[i].toCharArray();
        }
        int res = new Solution221().maximalSquare(matrix);
        System.out.println(res);
    }
}
