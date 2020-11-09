package Top100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 2020.11.9
 * A string S of lowercase English letters is given.
 * We want to partition this string into as many parts as possible so that each letter appears in at most one part,
 * and return a list of integers representing the size of these parts.
 *
 * Input: S = "ababcbacadefegdehijhklij"
 * Output: [9,7,8]
 * Explanation:
 * The partition is "ababcbaca", "defegde", "hijhklij".
 * This is a partition so that each letter appears in at most one part.
 * A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits S into less parts.
 */
public class Partition_Labels {
    public List<Integer> partitionLabels(String S) {
        List<Integer> res = new ArrayList<>();
        char[] chars = S.toCharArray();
        if (chars.length == 0){
            return res;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < chars.length; i++){
            // 更新位置
            map.put(chars[i], i);
        }
        int start = 0;
        int last = 0;
        for (int i = start; i <= last; i++){
            if (i >= chars.length){
                break;
            }
            if (last < map.get(chars[i])){
                last = map.get(chars[i]);
            }
            if (i == last){
                res.add(last - start + 1);
                last++;
                start = last;
            }
        }
        return res;
    }
}
