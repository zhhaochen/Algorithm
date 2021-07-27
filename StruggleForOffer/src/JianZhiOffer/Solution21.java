package JianZhiOffer;

public class Solution21 {
    public int[] exchange(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right){
            while (left < right && (nums[left] & 1) == 1) { left++; }
            while (left < right && (nums[right] & 1) == 0) { right--;}
            if (left < right) {
                swap(nums, left, right);
            }
        }
        return nums;
    }

    void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
