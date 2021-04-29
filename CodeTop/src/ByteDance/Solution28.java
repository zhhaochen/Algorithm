package ByteDance;

public class Solution28 {
    public int strStr(String haystack, String needle) {
        int len = needle.length();
        if (len == 0) return len;
        if (len > haystack.length()) return -1;
        for (int i = 0; i < haystack.length() - len + 1; i++){
            String tmp = haystack.substring(i, i + len);
            if (tmp.equals(needle)) return i;
        }
        return -1;
    }
}
