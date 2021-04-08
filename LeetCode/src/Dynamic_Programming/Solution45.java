package Dynamic_Programming;

import java.util.LinkedList;
import java.util.Queue;

public class Solution45 {
    // 层序遍历法
    public int jump(int[] nums) {
        if (nums.length == 1) return 0;
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visit = new boolean[nums.length];
        queue.offer(0);
        int res = 0;
        visit[0] = true;
        while (!queue.isEmpty()){
            // 当前这一步有多少种跳法
            int size = queue.size();
            for (int i = 0; i < size; i++){
                // 当前这一步跳到了 cur
                int cur = queue.poll();
                if (cur == nums.length - 1) return res;
                // 把当前能访问的放入下一层
                for (int j = 1; j <= nums[cur]; j++){
                    if (cur + j >= nums.length - 1) return res + 1;
                    if (!visit[cur + j]){
                        queue.offer(cur + j);
                        visit[cur + j] = true;
                    }
                }
            }
            res++;
        }
        return 0;
    }

    // 贪心法
    public int jump2(int[] nums) {
        int end = 0;
        int max = nums[0];
        int step = 0;
        // 不访问最后一个元素，
        // 这是因为在访问最后一个元素之前，我们的边界一定大于等于最后一个位置，
        // 否则就无法跳到最后一个位置了
        for (int i = 0; i < nums.length - 1; i++){
            max = Math.max(max, nums[i] + i);
            if (i == end){
                end = max;
                step++;
            }
        }
        return step;
    }
}
