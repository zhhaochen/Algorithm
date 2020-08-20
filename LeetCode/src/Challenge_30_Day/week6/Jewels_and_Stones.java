package Challenge_30_Day.week6;

import java.util.HashMap;
import java.util.Map;

public class Jewels_and_Stones {
    public int numJewelsInStones(String J, String S) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < J.length(); i++) {
            map.put(J.charAt(i), 0);
        }
        int count = 0;
        for (int i = 0; i < S.length(); i++) {
            if (map.get(S.charAt(i)) != null){
                count++;
            }
        }
        return count;
    }
}
