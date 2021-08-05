package DynamicProgramming;

public class Solution55 {
    public boolean canJump(int[] nums) {
        int index = 0;
        int max = nums[0];
        while (index <= max && index < nums.length){
            max = Math.max(nums[index] + index, max);
            if (index == max) break;
            index++;
        }
        return index >= nums.length - 1;
    }
}
