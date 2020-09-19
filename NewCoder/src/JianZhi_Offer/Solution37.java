package JianZhi_Offer;

/**
 * 统计一个数字在数组中出现的次数
 */
public class Solution37 {
    public static void main(String[] args) {
        int[] array = new int[]{1, 1, 3, 3, 3, 3, 4, 5};
//        int res = getIndexFromArray(array, 2);
        int res = GetNumberOfK(array, 2);
        System.out.println(res);
    }

    public static int GetNumberOfK(int[] array, int k) {
        int index1 = getIndexFromArray(array, k);
        // 注意这里要减一，方便后面比较
        int index2 = getIndexFromArray(array, k + 1) - 1;
        // 假设这个数不存在，则索引2必然小于索引1
        if (index2 >= index1) {
            return index2 - index1 + 1;
        }
        return 0;
    }

    // 查找目标在数组中的第一个位置，假设不存在会输出最后一个比它小的位置索引 + 1
    // 如{1, 3, 3, 3, 3, 4, 5}，target=6，输出7
    private static int getIndexFromArray(int[] array, int target) {
        int low = 0;
        int high = array.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (array[mid] >= target) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return high;
    }
}
