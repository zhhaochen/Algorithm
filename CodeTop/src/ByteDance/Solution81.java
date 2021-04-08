package ByteDance;

public class Solution81 {
    public boolean search(int[] nums, int target) {
        int left = 0, right = nums.length-1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] == target) return true;
            // 先判断是在哪个递增区间
            if (nums[mid] == nums[left] && nums[mid] == nums[right]){
                left++;
                right--;
            }
            else if (nums[left] <= nums[mid]){
                // 有序部分
                if (nums[left] <= target && target < nums[mid]) right = mid-1;
                else left = mid + 1;
            }
            else {
                // 有序部分
                if (nums[right] >= target && target > nums[mid]) left = mid + 1;
                else right = mid - 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1, 0, 1, 1, 1};
        new Solution81().search(nums, 0);
    }
}
