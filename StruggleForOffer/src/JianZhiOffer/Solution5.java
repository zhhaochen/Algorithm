package JianZhiOffer;

public class Solution5 {
    public String replaceSpace(String s) {
        char[] chars = s.toCharArray();
        int count = 0;
        for (char c : chars){
            if (c == ' ') count++;
        }
        char[] res = new char[chars.length + 2 * count];
        int index = 0;
        for (char c : chars){
            if (c == ' '){
                res[index++] = '%';
                res[index++] = '2';
                res[index++] = '0';
            }else res[index++] = c;
        }
        return new String(res);
    }
}
