package Hot100;

import java.util.*;

public class Solution347 {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> {
            return map.get(o1) - map.get(o2);
        });
        for (int num : nums) map.put(num, map.getOrDefault(num, 0) + 1);
        Set<Integer> set = map.keySet();
        for (int key : set){
            if (queue.size() < k || map.get(queue.peek()) < map.get(key)) queue.offer(key);
            if (queue.size() > k) queue.poll();
        }
        int[] res = new int[k];
        while (!queue.isEmpty()) res[k--] = queue.poll();
        return res;
    }
}
