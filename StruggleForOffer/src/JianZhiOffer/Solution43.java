package JianZhiOffer;

public class Solution43 {
    public int countDigitOne(int n) {
        int res = 0;
        int high = n / 10, low = 0, cur = n % 10;
        int dight = 1;
        while (high != 0 || cur != 0){
            if (cur == 0) res += high * dight;
            else if (cur == 1) res += high * dight + low + 1;
            else res += (high + 1) * dight;
            low += cur * dight;
            cur = high % 10;
            high /= 10;
            dight *= 10;
        }
        return res;
    }
}
