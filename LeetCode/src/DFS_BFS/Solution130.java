package DFS_BFS;

/**
 * 2020.4.17
 * Surrounded Regions
 * Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.
 * A region is captured by flipping all 'O's into 'X's in that surrounded region.
 * INPUT
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 * OUTPUT:
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 * 注意：与边界上的O相连的O也不能变成X
 */
public class Solution130 {
    public void solve(char[][] board) {
        //先从边界进行dfs，将所有边界上的O和与边界上O相连的O变为A
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                if((i==0 || i==board.length-1 ||j==0||j==board[0].length-1)&&board[i][j]=='O'){
                    dfs(board, i, j);
                }
            }
        }
        //把剩下的根据分类进行变换
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length;j++){
                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }else if (board[i][j] == 'A'){
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void dfs(char[][] board, int i, int j){
        if(i<0 || j<0 || i>=board.length || j>=board[0].length || board[i][j] != 'O'){
            return;
        }
        board[i][j] = 'A';
        dfs(board, i-1, j);
        dfs(board, i+1, j);
        dfs(board, i, j-1);
        dfs(board, i, j+1);
    }
}
