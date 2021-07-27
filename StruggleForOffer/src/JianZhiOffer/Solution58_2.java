package JianZhiOffer;

public class Solution58_2 {
    public String reverseLeftWords(String s, int n) {
        n %= s.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++){
            sb.append(s.charAt((i + n) % s.length()));
        }
        return sb.toString();
    }
}
