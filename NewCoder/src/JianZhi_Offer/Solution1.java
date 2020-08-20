package JianZhi_Offer;

/**
 * 2019.11.5
 * 在一个二维数组中（每个一维数组的长度相同），
 * 每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */
public class Solution1 {
    public boolean Find(int target, int[][] array) {
        int len1 = array.length;
        int len2 = array[0].length;
        int row = len1 - 1;
        int column = 0;
        while (row >= 0 && column < len2) {
            if (array[row][column] == target) {
                return true;
            } else {
                if (array[row][column] < target)
                    column++;
                else
                    row--;
            }
        }
        return false;
    }
}
