package Backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 2020.09.26
 * N-Queens
 * The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.
 * 皇后彼此不能相互攻击，也就是说：任何两个皇后都不能处于同一条横行、纵行或斜线上。
 */
public class Solution51 {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        // 初始化空棋盘
        List<String> track = new ArrayList<>();
        char[] tmp = new char[n];
        for (int i = 0; i < n; i++){
            tmp[i] = '.';
        }
        for (int i = 0; i < n; i++){
            track.add(new String(tmp));
        }
        solveNQueens(0, n, res, track);
        return res;
    }

    public void solveNQueens(int row, int n, List<List<String>> res, List<String> track) {
        if (row >= n) {
            res.add(new ArrayList<>(track));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!isValid(track, row, i, n)){
                continue;
            }
            // 如果当前合法，设置为皇后
            char[] tmp = track.get(row).toCharArray();
            tmp[i] = 'Q';
            track.set(row, new String(tmp));
            // 递归下一行
            solveNQueens(row + 1, n, res, track);
            // 撤销当前结果
            tmp[i] = '.';
            track.set(row, new String(tmp));
        }
    }

    public boolean isValid(List<String> track, int row, int col, int n) {
        // 检查同一列
        for (int i = 0; i < row; i++) {
            char[] colRes = track.get(i).toCharArray();
            if (colRes[col] == 'Q') {
                return false;
            }
        }
        // 检查同一行
        char[] rowRes = track.get(row).toCharArray();
        for (int i = 0; i < col; i++) {
            if (rowRes[i] == 'Q'){
                return false;
            }
        }
        // 检查左上方
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--){
            char[] tmp = track.get(i).toCharArray();
            if (tmp[j] == 'Q'){
                return false;
            }
        }
        // 检查右上方
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++){
            char[] tmp = track.get(i).toCharArray();
            if (tmp[j] == 'Q'){
                return false;
            }
        }
        return true;
    }
}
