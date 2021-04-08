package Tencent;

public class Solution8 {
    public int myAtoi(String s) {
        char[] chars = s.toCharArray();
        boolean flag = true;
        int index = 0;
        int res = 0;
        while (index < chars.length && chars[index] == ' ') index++;
        if (index < chars.length && (chars[index] =='+' || chars[index] == '-')){
            flag = chars[index++] == '+';
        }
        while (index < chars.length && chars[index] >= '0' && chars[index] <= '9'){
            int cur = chars[index++] - '0';
            if (flag && (res > Integer.MAX_VALUE / 10 || res == Integer.MAX_VALUE / 10 && cur > 7)) return Integer.MAX_VALUE;
            if (!flag && (res > Integer.MAX_VALUE / 10 || res == Integer.MAX_VALUE / 10 && cur > 8)) return Integer.MIN_VALUE;
            res = res * 10 + cur;
        }
        return flag ? res : -res;
    }
}
