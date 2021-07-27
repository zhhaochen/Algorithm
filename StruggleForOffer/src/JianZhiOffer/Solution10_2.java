package JianZhiOffer;

public class Solution10_2 {
    public int numWays(int n) {
        if (n <= 1) return 1;
        int pre = 1, cur = 2;
        for (int i = 3; i <= n; i++){
            int tmp = cur;
            cur = (pre + cur) % 1000000007;
            pre = tmp;
        }
        return cur;
    }
}
