public class Solution67 {
    public int strToInt(String str) {
        char[] chars = str.toCharArray();
        int index = 0;
        while (index < chars.length && chars[index] == ' ') index++;
        int flag = 1;
        if (index < chars.length && (chars[index] == '-' || chars[index] == '+')){
            flag = chars[index++] == '-' ? -1 : 1;
        }
        long cur = 0;
        // 防止越界 最后一位应该是 8 或者 7，所以直接判断 8
        int max = Integer.MAX_VALUE / 10;
        while (index < chars.length && chars[index] >= '0' && chars[index] <= '9'){
            int tmp = chars[index] - '0';
            if (cur > max || (cur == max && tmp >= 8)) return flag == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            cur = cur * 10 + tmp;
            index++;
        }
        return flag * (int) cur;
    }
}
