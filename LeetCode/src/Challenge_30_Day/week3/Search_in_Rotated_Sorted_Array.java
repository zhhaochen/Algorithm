package Challenge_30_Day.week3;

/**
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 * You may assume no duplicate exists in the array.无重复的，就简单了很多
 * Your algorithm's runtime complexity must be in the order of O(log n).
 */
public class Search_in_Rotated_Sorted_Array {
    public static void main(String[] args) {
        int[] nums = new int[]{4,5,6,7,0,1,2};
        System.out.println(search(nums, 0));
    }
    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        while (left<=right){
            int mid = (left+right)/2;
            if (nums[mid] == target){
                return mid;
            }
            if (nums[left]<nums[right]){ //说明在一个递增的序列中
                if (nums[mid]>target){
                    right = mid-1;
                }else {
                    left = mid+1;
                }
            }else {  //说明这个部分存在旋转
                if (nums[mid] >= nums[right]){ //mid在大的部分
                    if (nums[mid] > target && nums[left] <= target){
                        right = mid-1;
                    }else {
                        left = mid +1;
                    }
                }else {//mid在小的部分
                    if (nums[mid] < target && nums[right] >= target){
                        left = mid +1;
                    }else {
                        right = mid -1;
                    }
                }
            }
        }
        return -1;
    }
    public static int search2(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        while (left<=right){
            int mid = (left+right)/2;
            if (nums[mid] == target){
                return mid;
            }
            if (nums[mid] < nums[right]){ //说明mid在旋转序列中的小序列中
                if (nums[mid] < target && nums[right] >= target){ //如果在小序列的右半部分，就是要先找限制最多的
                    left = mid+1;
                }else {
                    right = mid-1;
                }
            }else { //说明处于一个正常递增或者mid处于旋转的大序列中
                if(nums[left] <= target && nums[mid] > target){ //在大序列的左半部分
                    right = mid - 1;
                }else {
                    left = mid + 1;
                }
            }
        }
        return -1;
    }
}
