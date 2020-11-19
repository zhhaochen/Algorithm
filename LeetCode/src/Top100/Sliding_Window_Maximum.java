package Top100;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 2020.11.19
 * You are given an array of integers nums,
 * there is a sliding window of size k which is moving from the very left of the array to the very right.
 * You can only see the k numbers in the window.
 * Each time the sliding window moves right by one position.
 * Return the max sliding window.
 * Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
 * Output: [3,3,5,5,6,7]
 * Explanation:
 * Window position                Max
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 */
public class Sliding_Window_Maximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> {return o2 - o1;});
        // 记录窗口内所有值出现次数
        Map<Integer, Integer> map = new HashMap<>();
        int[] res = new int[nums.length - k + 1];
        for (int i = 0; i < k; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            queue.offer(nums[i]);
        }
        int index = 0;
        res[index++] = queue.peek();
        for (int i = k; i < nums.length; i++){
            // 从窗口中移除上一个
            map.put(nums[i-k], map.get(nums[i-k]) - 1);
            // 将当前的加入
            queue.offer(nums[i]);
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            // 确定栈顶元素是否包含在窗口中
            while (map.get(queue.peek()) == 0){
                queue.poll();
            }
            res[index++] = queue.peek();
        }
        return res;
    }
}
