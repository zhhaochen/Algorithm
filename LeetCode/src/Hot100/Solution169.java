package Hot100;

public class Solution169 {
    public int majorityElement(int[] nums) {
        // 投票算法
        int res = 0, count = 0;
        for (int num : nums){
            if (count == 0) res = num;
            if (res == num) count++;
            else count--;
        }
        return res;
    }
}
