/**
 *
 */
public class Solution11_2 {
    public static void main(String[] args) {
        int[] array = new int[]{1, 0, 1, 1, 1}; //注意此特例
        int[] array2 = new int[]{2, 3, 0, 1, 2};
        int[] array3 = new int[]{3, 4, 5, 6, 1, 1};
        System.out.println(new Solution11_2().minNumberInRotateArray(array));
    }

    public int minNumberInRotateArray(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int low = 0;
        int high = array.length - 1;
        while (low < high) {
            //当最低与小于最高时，说明正常递增，直接返回
            if (array[low] < array[high]) {
                break;
            }
            int mid = (low + high) / 2;
            // 此时说明不是正常递增，是有旋转的
            // 如果是 [1, 0, 1, 1, 1]和[1, 1, 1, 0, 1]这种情况，如何判断在左还是右？
             if (array[mid] == array[low] && array[mid] == array[high]) {//当三个值相等时，只能顺序判断，这个要首先进行判断，否则会影响下两个判断
                int min = array[low];
                for (int i = low + 1; i <= high; i++) {
                    if (min > array[i]) {
                        min = array[i];
                    }
                }
                return min;
            }
             // 暂时不考虑有相等的地方，假设旋转数组是递增的数组时，第一个递增即旋转过去的后半部分，第二个则是正常增长的部分
             else if (array[mid] >= array[low]) { //说明mid在第一个递增数组
                low = mid + 1; //+1是为了保证最后能low=high否则如果[2, 1]则死循环
            }
            else if (array[mid] <= array[high]) { //说明mid在第二个递增数组里
                high = mid;
            }
            //因为经过了第一步判断，low处的值不可能比high处小，所以mid与high相等时，low也必相等
        }
        return array[low];
    }
}
