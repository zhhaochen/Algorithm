package JianZhi_Offer;

import java.util.HashMap;
import java.util.Map;

/**
 * 在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置,
 * 如果没有则返回 -1（需要区分大小写）.（从0开始计数）
 */
public class Solution34 {
    // 牛客网标记了这是较难的难度，还以为有什么别的办法
    public int FirstNotRepeatingChar(String str) {
        if (str == null || str.length() == 0){
            return -1;
        }
        char[] chars = str.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < chars.length; i++){
            map.put(chars[i], map.getOrDefault(chars[i], 0)  + 1);
        }
        for (int i = 0; i < chars.length; i++){
            if (map.get(chars[i]) == 1){
                return i;
            }
        }
        return -1;
    }
}
