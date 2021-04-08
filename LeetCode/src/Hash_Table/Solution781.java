package Hash_Table;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Solution781 {
    public int numRabbits(int[] answers) {
        Map<Integer, Integer> map = new HashMap<>();
        // 首先把所有相等的放在一起
        for (int answer : answers){
            map.put(answer, map.getOrDefault(answer, 0) + 1);
        }
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        int res = 0;
        for (Map.Entry<Integer, Integer> entry : entries){
            // 需要的人数，比如如果有2个与自己一样的，则需要3个分一组
            int need = entry.getKey() + 1;
            int have = entry.getValue();
            res += have;
            // 分组缺人
            if (have % need != 0) res += (need - have % need);
        }
        return res;
    }
}
