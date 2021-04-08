package Baidu;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class Solution347 {
    public int[] topKFrequent(int[] nums, int k) {
        int[] res = new int[k];
        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> {
            return map.get(o2) - map.get(o1);
        });
        for (int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (int key : map.keySet()) queue.offer(key);
        int index = 0;
        while (index < k && !queue.isEmpty()) res[index++] = queue.poll();
        return res;
    }
}
