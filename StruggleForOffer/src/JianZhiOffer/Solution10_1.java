package JianZhiOffer;

public class Solution10_1 {
    public int fib(int n) {
        if (n == 0) return 0;
        if (n <= 2) return 1;
        int pre = 1, cur = 1;
        for (int i = 3; i <= n; i++){
            int tmp = cur;
            cur = (pre + cur) % 1000000007;
            pre = tmp;
        }
        return cur;
    }
}
