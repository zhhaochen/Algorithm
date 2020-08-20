package JianZhi_Offer;

/**
 * 对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。
 * 例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。
 */
public class Solution43 {
    public String LeftRotateString(String str,int n) {
        int len = str.length();
        if(len == 0){
            return "";
        }
        n = n % len;
        return str.substring(n, len) + str.substring(0, n);
    }
}
