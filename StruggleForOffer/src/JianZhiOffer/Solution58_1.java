package JianZhiOffer;

public class Solution58_1 {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        s = s.trim();
        int right = s.length() - 1, left = right;
        while (left >= 0){
            while (left >= 0 && s.charAt(left) != ' ') left--;
            for (int i = left + 1; i <= right; i++) sb.append(s.charAt(i));
            sb.append(' ');
            while (left >= 0 && s.charAt(left) == ' ') left--;
            right = left;
        }
        return sb.toString().trim();
    }
}
