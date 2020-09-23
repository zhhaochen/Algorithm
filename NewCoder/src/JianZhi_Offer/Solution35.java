package JianZhi_Offer;

/**
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 * 输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。 即输出P%1000000007
 */
public class Solution35 {
    public static void main(String[] args) {
        int[] array = new int[]{7, 5, 6, 4};
        InversePairs(array);
    }
    // 归并排序的思路
    public static int InversePairs(int [] array) {
        if(array== null || array.length <= 0){
            return 0;
        }
        int len = array.length;
        return mergeSort(array, 0, len-1);
    }
    public static int mergeSort(int [] array, int start, int end){
        // 当只有一个值时，当前的子数组归并结束，返回上一级
        if(start == end)
            return 0;
        int mid = (start + end) / 2;
        // 划分左右两个子数组，得到左右子数组的逆序对数
        int left_count = mergeSort(array, start, mid);
        int right_count = mergeSort(array, mid + 1, end);
        int i = mid, j = end;
        // 辅助数组
        int [] copy = new int[end - start + 1];
        // 数组的最后一个位置
        int copy_index = end - start;
        int count = 0;
        // 两个子数组从尾开始比较，因为已经对子数组排过序，此时指向的是最大的
        while(i >= start && j >= mid + 1){
            // 如果左边的比右边大，因为指向的都是最大的，所以右边子数组有多少就有多少逆序对
            if(array[i] > array[j]){
                // 与i有关的已经结束，把指向的放入
                copy[copy_index--] = array[i--];
                // 此处是 j - mid
                count += j - mid;
                if(count > 1000000007){
                    count %= 1000000007;
                }
            }else{
                // 否则，说明j指向的左边子数组没有比它大的，j指向的放入
                copy[copy_index--] = array[j--];
            }
        }
        // 把剩余的放入
        while(i >= start){
            copy[copy_index--] = array[i--];
        }
        while(j >= mid + 1){
            copy[copy_index--] = array[j--];
        }
        i = 0;
        // 通过辅助数组，合并这两个子数组，用于和另一边的进行比较，这样也不会重复
        while(start <= end) {
            array[start++] = copy[i++];
        }
        // 最后将结果加起来
        return (left_count+right_count+count)%1000000007;
    }
}
