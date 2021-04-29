package Amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution368 {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        // 记录当前值为结尾的子集的长度
        int[] dp = new int[nums.length];
        // 可以记录下标
        int[] memo = new int[nums.length];
        // -1表示当前节点是开头
        dp[0] = 1; memo[0] = -1;
        int index = 0;
        for (int i = 1; i < nums.length; i++){
            dp[i] = 1; memo[i] = -1;
            for (int j = i - 1; j >=0; j--){
                if (nums[j] != 0 && nums[i] % nums[j] == 0){
                    if (dp[j] + 1 > dp[i]){
                        dp[i] = dp[j] + 1;
                        memo[i] = j; // 记录前一个
                    }
                }
            }
            index = dp[i] > dp[index] ? i : index;
        }
        List<Integer> list = new ArrayList<>();
        int len = dp[index];
        for (int i = 0; i < len; i++){
            list.add(0, nums[index]);
            index = memo[index];
        }
        return list;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<Integer> list = new Solution368().largestDivisibleSubset(nums);
        System.out.println(list);
    }
}
