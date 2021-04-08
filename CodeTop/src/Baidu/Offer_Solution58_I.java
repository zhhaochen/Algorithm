package Baidu;

public class Offer_Solution58_I {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        // 去掉前置后置空格
        s = s.trim();
        // 从后向前
        int right = s.length();
        int left = right - 1;
        while (left >= 0){
            if (s.charAt(left) != ' ') left--;
            else{
                sb.append(s.substring(left + 1, right));
                sb.append(' ');
                while (left >= 0 && s.charAt(left) ==' ') left--;
                right = left + 1;
            }
        }
        // 最后加上一个开头
        sb.append(s.substring(0, right));
        return sb.toString();
    }
}
