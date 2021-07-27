package JianZhiOffer;

public class Solution14_2 {
    public int cuttingRope(int n) {
        if (n <= 3) return n - 1;
        long res = 1, x = 3;
        int b = n % 3, mod = 1000000007;
        // 注意这里，减一开始
        for (int i = n / 3 - 1; i > 0; i /= 2){
            /**
             *  输入 n = 36，i = 11，此时要计算 3 ^ 11
             *  第一轮，i % 2 == 1 res = 3 ^ 1, 还有 5 个 x = 3 ^ 2 => i = 5
             *  第二轮，i % 2 == 1 res = 3 ^ 3, 还有 2 个 x = 3 ^ 4 => i = 2
             *  第三轮，i % 2 == 0 res = 3 ^ 3, 剩余 1 个 x = 3 ^ 8 => i = 1
             *  第四轮，i % 2 == 1 res = 3 ^ 11, 剩余 0 个 x = 3 ^ 16 => i = 0
             *  所以 res 记录的就是两两组合时，剩余的乘上去
              */
            if(i % 2 == 1) res = (res * x) % mod; // x 就是两两组合时剩下的
            x = (x * x) % mod;  // 两两组合
        }
        if (b == 0) return (int)(res * 3 % mod); // 可以整除 3
        if (b == 1) return (int)(res * 4 % mod); // 最后留了个 1，将1+3 拆分成 2 + 2
        return (int) (res * 6 % mod); // 最后留了个 2，直接乘 6
    }
}