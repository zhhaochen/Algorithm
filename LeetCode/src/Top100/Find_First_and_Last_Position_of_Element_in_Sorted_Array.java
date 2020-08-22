package Top100;

/**
 * Given an array of integers nums sorted in ascending order,
 * find the starting and ending position of a given target value.
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * If the target is not found in the array, return [-1, -1].
 */
public class Find_First_and_Last_Position_of_Element_in_Sorted_Array {
    // 二分查找
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[]{-1, -1};
        int len = nums.length;
        if (len == 0){
            return res;
        }
        int start = 0;
        int end = len-1;
        while (start <= end){
            if (nums[start] == target && nums[end] == target){
                res[0] = start;
                res[1] = end;
                break;
            }
            int mid = start + (end -  start) / 2;
            if (nums[mid] < target){
                start = mid + 1;
            }else if(nums[mid] > target){
                end = mid -1;
            }else {
                // 如果相等，左右判断移动1位
                if (nums[start] != target){
                    start++;
                }
                if (nums[end] != target){
                    end--;
                }
            }
        }
        return res;
    }
}
