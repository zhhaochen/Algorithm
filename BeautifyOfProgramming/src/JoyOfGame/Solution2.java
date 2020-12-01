package JoyOfGame;

/**
 * 中国象棋将帅问题
 * 棋盘上只有将和帅，将帅不能在同一列，输出所有合法位置
 */
public class Solution2 {
    public void chess(){
        for (int i = 1; i <= 9; i++){
            for (int j = 1; j <= 9; j++){
                if (i % 3 != j % 3){
                    System.out.printf("A = %s, B =  %s \n", i, j);
                }
            }
        }
    }
}
