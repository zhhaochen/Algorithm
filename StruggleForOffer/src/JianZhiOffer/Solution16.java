package JianZhiOffer;

public class Solution16 {
    public double myPow(double x, int n) {
        double res = 1.0;
        // 注意 n 为int负数最小数的绝对值越界
        long a = n;
        a = Math.abs(a);
        for (; a > 0; a /= 2){
            if (a % 2 == 1) res *= x;
            x *= x;
        }
        return n >= 0 ? res : 1 / res;
    }
}
