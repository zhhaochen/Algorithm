package Tencent;

import java.util.Arrays;

public class Solution169 {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    // 投票算法
    public int majorityElement2(int[] nums) {
        int count = 0;
        int cur = nums[0];
        for (int num : nums){
            if (num == cur) count++;
            else if (count == 0){
                cur = num;
                count++;
            }
            else count--;
        }
        return cur;
    }
}
