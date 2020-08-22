package Challenge_30_Day.May.week8;

import java.util.*;

public class Find_All_Anagrams_in_a_String {
    public static void main(String[] args) {
        String s = "abc";
        String p = "abc";
        System.out.println(s==p);

    }
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> index = new ArrayList<>();
        int len_s = s.length();
        int len_p = p.length();
        if (len_s < len_p){
            return index;
        }
        //首先对p进行排序，并将每个字母存入到一个hashmap中
        Map<Character, Integer> map = new HashMap<>();
        char[] chars = p.toCharArray();
        Arrays.sort(chars);
        p = new String(chars);
        for (int i = 0; i < len_p; i++) {
            map.putIfAbsent(chars[i], 0);
        }
        //对s进行检测
        for (int i = 0; i < (len_s - len_p + 1); i++) {
            if (map.get(s.charAt(i)) != null){
                String sub = s.substring(i, i + len_p);
                char[] sub_chars = sub.toCharArray();
                Arrays.sort(sub_chars);
                if (new String(sub_chars).equals(p)){
                    index.add(i);
                }
            }
        }
        return index;
    }
}
