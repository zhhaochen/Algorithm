/**
 * 2020.3.1
 * 矩阵中的路径
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
 * 路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。
 * 如果一条路径经过了矩阵中的某一个格子，则该路径不能再进入该格子。
 *
 * 重点：回溯法 P89
 * 回溯法应该用栈实现？递归？
 *
 * 1、功能测试：多行多列中存在或不存在
 * 2、边界值测试：矩阵只有一行或一列；矩阵和路径中所有的字母都是相同的
 * 3、特殊输入测试：输入为空
 */
public class Solution12 {
    public static void main(String[] args) {
        char[] matrix = new char[]{'a', 'b', 't', 'g',
                'c', 'f', 'c', 's',
                'j', 'd', 'e', 'h'};
        char[] str = new char[]{'a', 'b', 'f', 'b'};
        boolean b = new Solution12().hasPath(matrix, 12, 1, str);
        System.out.println(b);
    }

    // 矩阵直接被打平了
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        if (str == null || rows < 1 || cols < 1 || matrix == null) {
            return false;
        }
        boolean hasPath = false;
        boolean[] visited = new boolean[rows * cols];
        for (int index1=0; index1<rows*cols; index1++){
            hasPath = hasPathCore(matrix, rows, cols, str, index1, 0, visited);
            if (hasPath){
                return true;
            }
        }
        return false;
    }

    public boolean hasPathCore(char[] matrix, int rows, int cols, char[] str,
                               int index1, int index2, boolean[] visted) {
        //所有的已经检查完
        if (index2 == str.length) {
            return true;
        }
        //越界时
        if (index1<0||index1>=rows*cols){
            return false;
        }
        boolean hasPath = false;
        //检验当前matrix[index1]是否为str[index2]对应的
        //相等且没有被访问过
        if (matrix[index1] == str[index2] && !visted[index1]) {
            index2++;
            visted[index1] = true;
            //当前是的情况下，判断上下左右有没有
            hasPath = hasPathCore(matrix, rows, cols, str, index1+1, index2, visted)
                    || hasPathCore(matrix, rows, cols, str, index1-1, index2, visted)
                    || hasPathCore(matrix, rows, cols, str, index1 + cols, index2, visted)
                    || hasPathCore(matrix, rows, cols, str, index1 - cols, index2, visted);
            //如果没有，则回溯，只要把当前的置为false
            if (!hasPath){
                visted[index1] = false;
            }
        }
        return hasPath;
    }
}
