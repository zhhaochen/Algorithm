package Challenge_30_Day.week6;

import java.util.HashMap;
import java.util.Map;

public class First_Unique_Character_in_a_String {
    public static void main(String[] args) {
        String s = "tsessgaga";
    }
    public int firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) != null){
                int count = map.get(s.charAt(i));
                map.put(s.charAt(i), count+1);
            }else {
                map.put(s.charAt(i), 1);
            }
        }
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)).equals(1)){
                return i;
            }
        }
        return -1;
    }
}
