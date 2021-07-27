package JianZhiOffer;

public class Solution57 {
    public int[] twoSum(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left < right){
            int tmp = nums[left] + nums[right];
            if (tmp == target) break;
            else if (tmp > target) right--;
            else left++;
        }
        return new int[]{nums[left], nums[right]};
    }
}
