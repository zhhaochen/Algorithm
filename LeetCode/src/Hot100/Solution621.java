package Hot100;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Solution621 {
    public int leastInterval(char[] tasks, int n) {
        if (n == 0) return tasks.length;
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        for (char task : tasks){
            map.put(task, map.getOrDefault(task, 0) + 1);
            max = Math.max(max, map.get(task));
        }
        // 拥有最多执行次数的任务的数目
        Set<Map.Entry<Character, Integer>> entries = map.entrySet();
        int maxCount = 0;
        for (Map.Entry<Character, Integer> entry : entries){
            if (entry.getValue() == max) maxCount++;
        }
        return Math.max((max - 1) * (n + 1) + maxCount, tasks.length);
    }
}
