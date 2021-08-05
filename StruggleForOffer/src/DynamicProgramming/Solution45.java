package DynamicProgramming;

public class Solution45 {
    public int jump(int[] nums) {
        int pre = 0;
        int end = 0;
        int step = 0;
        for (int i = 0; i < nums.length - 1; i++){
            // 更新下一轮最大的
            end = Math.max(nums[i] + i, end);
            if (i == pre){
                pre = end;
                step++;
            }
        }
        return step;
    }
}
