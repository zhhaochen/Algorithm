package Top100;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 2020.10.19
 * Given a non-empty array of integers, return the k most frequent elements.
 * Input: nums = [1,1,1,2,2,3], k = 2
 * Output: [1,2]
 * 假定k一定是合法的
 */
public class Top_K_Frequent_Elements {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) ->{return map.get(a) - map.get(b);});
        int index = 0;
        for (Integer key : map.keySet()){
            if (index < k){
                queue.add(key);
                index++;
            }else {
                if (map.get(key) > map.get(queue.peek())){
                    queue.poll();
                    queue.add(key);
                }
            }
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++){
            res[i] = queue.poll();
        }
        return res;
    }
}
