/**
 * 二维数组中的查找
 * 给定一个二维数组，每一行从左到右递增，每一列从上到下递增
 * 给定一个整数，判断是否存在这个整数
 */
public class Solution4 {
    public static void main(String[] args) {
        int[][] data = new int[][]{{1, 2, 8, 9},
                                   {2, 4, 9, 12},
                                   {4, 7, 10, 13},
                                   {6, 8, 11, 15}};
        int target = 0;
        System.out.println(isExist(data, target));
    }
    private static boolean isExist(int[][] data, int target){
        if (data==null)
            return false;
        int row = data.length - 1;
        int col = 0;
        while (row>=0 && col<data[0].length){
            if (target>data[row][col]){
                col++;
            }else if (target < data[row][col]){
                row--;
            }else
                return true;
        }
        return false;
    }
}
