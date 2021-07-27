package JianZhiOffer;

public class Solution50 {
    public char firstUniqChar(String s) {
        int[] count = new int[26];
        for (char c : s.toCharArray()) count[c - 'a']++;
        char res = ' ';
        for (char c : s.toCharArray()){
            if (count[c - 'a'] == 1){
                res = c;
                break;
            }
        }
        return res;
    }
}
