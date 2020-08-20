package array;

public class TestBinarySearch {
    public static void main(String[] args) {

        //二分查找适用于有序数组
        int[] array = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int target = 8;

        int begin = 0;
        int end = array.length-1;
        int mid = (begin + end) / 2;

        int index = -1;

        while (true){
            if (begin > end){
                break;
            }

            if (array[mid] == target){
                index = mid;
                break;
            }else {
                if (array[mid] < target){
                    begin = mid + 1;
                }else
                    end = mid - 1;
                mid = (begin + end) / 2;
            }
        }
        System.out.println(index + 1);
    }
}
