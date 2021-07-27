package JianZhiOffer;

public class Solution12 {
    public boolean exist(char[][] board, String word) {
        boolean[][] visit = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[0].length; j++){
                boolean res = backtrack(board, visit, i, j, word, 0);
                if (res) return true;
            }
        }
        return false;
    }

    public boolean backtrack(char[][] board, boolean[][] visit, int i, int j, String word, int index){
        // 先判断是否到头
        if(index >= word.length()) return true;
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) return false;
        boolean res = false;
        if (board[i][j] == word.charAt(index) && !visit[i][j]){
            visit[i][j] = true;
            res = backtrack(board, visit, i + 1, j, word, index + 1) ||
                    backtrack(board, visit, i, j + 1, word, index + 1) ||
                    backtrack(board, visit, i - 1, j, word, index + 1) ||
                    backtrack(board, visit, i, j - 1, word, index + 1);
            visit[i][j] = false;
        }
        return res;
    }

    public static void main(String[] args) {
        char[][] board = {{'A', 'B', 'C', 'E'},
                            {'S', 'F', 'C', 'S'},
                            {'A', 'D', 'E', 'E'}};
        String word = "ABCCED";
        boolean res = new Solution12().exist(board, word);
        System.out.println(res);
    }
}
