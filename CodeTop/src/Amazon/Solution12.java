package Amazon;

import java.util.HashMap;
import java.util.Map;

public class Solution12 {
    public String intToRoman(int num) {
        int[] number = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
        String[] roman = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
        int index = number.length - 1;
        StringBuilder sb =  new StringBuilder();
        while (num != 0 || index >= 0){
            if (num >= number[index]){
                int count = num / index;
                for (int i = 0; i < count; i++) sb.append(roman[index]);
            }
            num %= number[index];
            index--;
        }
        return sb.toString();
    }
}
