package DynamicProgramming;

public class Solution53 {
    public int maxSubArray(int[] nums) {
        int pre = nums[0], cur = nums[0];
        int max = pre;
        for(int i = 1; i < nums.length; i++){
            if(pre < 0) cur = nums[i];
            else cur = pre + nums[i];
            max = Math.max(cur, max);
            pre = cur;
        }
        return max;
    }
}
