package Challenge_30_Day.May.week1;

import java.util.*;

/**
 * Given an array of strings, group anagrams together.
 * Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * Output:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 */
public class Group_Anagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>(); //key是排序后得字符串
        for (String str: strs){
            //1、将字符串重新排序
            char[] arrayCh=str.toCharArray();
            Arrays.sort(arrayCh);
            String sortedStr=new String(arrayCh);
            //2、map中查询是否存在，不存在则重建
            List<String> list = map.get(sortedStr);
            if (list == null){
                list = new ArrayList<>();
            }
            list.add(str);
            map.put(sortedStr, list);
        }
        res = new ArrayList<>(map.values());
        return res;
    }
}
