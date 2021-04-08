package Hot100;

import java.util.*;

public class Solution49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (String str : strs) {
            char[] tmp = str.toCharArray();
            Arrays.sort(tmp);
            String s = new String(tmp);
            if (map.containsKey(s)){
                res.get(map.get(s)).add(str);
            }else {
                List<String> list = new ArrayList<>();
                list.add(str);
                res.add(list);
                map.put(s, res.size() - 1);
            }
        }
        return res;
    }

}
