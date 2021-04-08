public class Solution58_I {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        char[] chars = s.toCharArray();
        int left = 0, right = chars.length - 1;
        // 去除先导空格
        while (left <= right && chars[left] == ' ') left++;
        while (left <= right && chars[right] == ' ') right--;
        if (left <= right){
            int i = right, j = right;
            while (i >= left){
                while (i >= left && chars[i] !=' ') i--;
                sb.append(s.substring(i + 1, j + 1));
                sb.append(' ');
                while (i >= left && chars[i] == ' ') i--;
                j = i;
            }
        }
        if (sb.length() > 0) sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}
