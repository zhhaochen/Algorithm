package JianZhiOffer;

public class Solution67 {
    public int strToInt(String str) {
        str = str.trim();
        if (str.length() == 0) return 0;
        int flag = 0, index = 0;
        int res = 0;
        int MAX = Integer.MAX_VALUE / 10;
        if (str.charAt(0) =='-' || str.charAt(0) =='+'){
            if (str.charAt(0) == '-') flag = 1;
            index++;
        }
        while (index < str.length() && str.charAt(index) >= '0' && str.charAt(index) <= '9'){
            int tmp = str.charAt(index++) - '0';
            if (res > MAX) return flag == 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            if (res == MAX){
                if (flag == 0 && tmp >= 7) return Integer.MAX_VALUE;
                else if (flag == 1 && tmp >= 8) return Integer.MIN_VALUE;
            }
            res = res * 10 + tmp;
        }
        return flag == 0 ? res : -res;
    }
}
