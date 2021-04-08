package Amazon;

import java.util.*;

public class Solution332 {
    public List<String> findItinerary(List<List<String>> tickets) {
        // 映射
        int index = 0;
        Map<String, Integer> map = new HashMap<>();
        for (List<String> ticket : tickets){
            if (!map.containsKey(ticket.get(0))) map.put(ticket.get(0), index++);
            if (!map.containsKey(ticket.get(1))) map.put(ticket.get(1), index++);
        }
        // 入度
        int[] degree = new int[index];
        for (List<String> ticket : tickets){
            int from = map.get(ticket.get(0));
            int to = map.get(ticket.get(1));
            degree[to]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(map.get("JFK"));
        return null;
    }
}
