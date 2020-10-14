package Top100;

public class Jump_Game {
    public boolean canJump(int[] nums) {
        int n = nums.length, reach = 0;
        for (int i = 0; i < n; ++i) {
            // 当前坐标大于 reach 或者 reach 已经抵达最后一个位置则跳出循环
            // reach 代表能到达的最远距离，i > reach代表在reach之前的所有跳都没有超过reach
            if (i > reach || reach >= n - 1) break;
            // 进一步求能到达的最远距离reach
            reach = Math.max(reach, i + nums[i]);
        }
        return reach >= n - 1;
    }
}
