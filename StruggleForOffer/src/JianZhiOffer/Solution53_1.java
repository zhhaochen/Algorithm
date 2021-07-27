package JianZhiOffer;

public class Solution53_1 {
    public int search(int[] nums, int target) {
        return helper(nums, target + 1) - helper(nums, target);
    }
    private int helper(int[] nums, int target){
        int left = 0, right = nums.length - 1;
        while (left <= right){
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) left = mid + 1;
            else if (nums[mid] > target) right = mid - 1;
            else right--;
        }
        return left;
    }
}
