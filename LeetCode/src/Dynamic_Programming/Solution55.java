package Dynamic_Programming;

public class Solution55 {
    public boolean canJump(int[] nums) {
        // 记录能跳到的最远位置
        int max = nums[0];
        for (int i = 1; i <= max && i < nums.length; i++){
            max = Math.max(max, i + nums[i]);
        }
        return max >= nums.length - 1;
    }
}
