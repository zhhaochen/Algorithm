package Top100;

/**
 * Given an array of non-negative integers nums, you are initially positioned at the first index of the array.
 * Each element in the array represents your maximum jump length at that position.
 * Your goal is to reach the last index in the minimum number of jumps.
 * You can assume that you can always reach the last index.
 * Input: nums = [2,3,1,1,4]
 * Output: 2
 * Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to the last index.
 */
public class Jump_Game_II {
    public int jump(int[] nums) {
        // i 记录从cur起跳的索引
        int res = 0, n = nums.length, i = 0, cur = 0;
        while (cur < n - 1) {
            ++res;
            // 记录上一次能跳到的最远范围
            int pre = cur;
            // 在当前能跳到的范围内，即 i 到 cur 之间
            // 为了同时与上一步比较，避免从上一跳到达最远距离加上下一跳小于其中某一跳
            for (; i <= pre; ++i) {
                // 找下一个能跳更远范围的，i代表范围内的坐标，i + nums[i]代表从i起跳的最远距离
                cur = Math.max(cur, i + nums[i]);
            }
            if (pre == cur) return -1; // May not need this
        }
        return res;
    }
}
