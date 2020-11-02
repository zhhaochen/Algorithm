package Top100;

/**
 * 2020.11.02
 * Given a 2D board and a word, find if the word exists in the grid.
 * The word can be constructed from letters of sequentially adjacent cells,
 * where "adjacent" cells are horizontally or vertically neighboring.
 * The same letter cell may not be used more than once.
 * Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * Output: true
 */

public class Word_Search {
    public boolean exist(char[][] board, String word) {
        char[] word_char = word.toCharArray();
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[0].length; j++){
                if (exist(board, word_char, i, j, 0)){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean exist(char[][] board, char[] word_char, int row, int col, int index){
        // 到头了，找到了一个
        if (index >= word_char.length ){
            return true;
        }
        // 范围错误或者已经访问过
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || board[row][col] == '*'){
            return false;
        }
        if (board[row][col] != word_char[index]){
            return false;
        }else {
            char tmp = board[row][col];
            board[row][col] = '*';
            boolean up = exist(board, word_char, row-1, col, index+1);
            boolean down = exist(board, word_char, row+1, col, index+1);
            boolean left = exist(board, word_char, row, col-1, index+1);
            boolean right = exist(board, word_char, row, col+1, index+1);
            if (up || down || left || right){
                // 如果成功了就不用管恢复，直接返回
                // 这样写为了提高速度
                return true;
            }else {
                board[row][col] = tmp;
                return false;
            }
        }
    }
}
