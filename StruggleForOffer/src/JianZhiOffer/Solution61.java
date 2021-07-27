package JianZhiOffer;

import java.util.Arrays;

public class Solution61 {
    public boolean isStraight(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        for (int i = 0; i < 4; i++){
            if (nums[i] == 0) count++;
            else if (nums[i] == nums[i + 1]) return false;
        }
        return nums[4] - nums[count] < 5;
    }
}
