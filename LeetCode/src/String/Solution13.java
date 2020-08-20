package String;

import java.util.HashMap;
import java.util.Map;

/**
 * 2020.4.15
 * Roman to Integer
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
 * Symbol      Value
 * I           1
 * V           5
 * X           10
 * L           50
 * C           100
 * D           500
 * M           1000
 * Input: "MCMXCIV"
 * Output: 1994
 * Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 */
public class Solution13 {
    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int len = s.length();
        int result = 0;
        for (int i=0; i<len; i++){
            int val = map.get(s.charAt(i));
            if (i == len - 1 || map.get(s.charAt(i+1)) <= val){
                result += val;
            }else {
                result -= val;
            }
        }
        return result;
    }
}
