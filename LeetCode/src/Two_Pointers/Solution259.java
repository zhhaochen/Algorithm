package Two_Pointers;

import java.util.Arrays;

public class Solution259 {
    public int threeSumSmaller(int[] nums, int target){
        int res = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++){
            int start = i + 1;
            int end = nums.length - 1;
            while(start < end){
                int sum = nums[i] + nums[start] + nums[end];
                if (sum >= target) end--;
                    // 当前和小于target时
                else{
                    // 此时start++也有可能小于，end--必定小于，所以先统计一下个数，然后++
                    res += (end - start);
                    start++;
                }
            }
        }
        return res;
    }
}