package JianZhi_Offer;

/**
 * 从1 到 n 中 1 出现的次数
 */
public class Solution31 {
    // 来自编程之美，过于抽象难以理解，不说人话
    public int NumberOf1Between1AndN_Solution(int n) {
        int cnt = 0;
        for (int m = 1; m <= n; m *= 10) {
            int a = n / m, b = n % m;
            cnt += (a + 8) / 10 * m + (a % 10 == 1 ? b + 1 : 0);
        }
        return cnt;
    }

    // 更容易理解的方法
    public int NumberOf1Between1AndN_Solution2(int n) {
        if (n < 1)
            return 0;
        int count = 0;
        int base = 1;
        int round = n;
        while (round > 0) {
            // 取当前低位，为了计算1在这一位上出现了多少次
            int weight = round % 10;
            // 高位决定了低位出现的次数
            round /= 10;
            //根据公式
            count += round * base;
            // 如果这一位等于1，则需要计算weight后面有多少，+1是为了算上0的情况
            if (weight == 1)
                count += (n % base) + 1;
            // 如果这一位大于1，说明上面的情况已经计算上了，只需要加上后面的几位全部在weight=1时的情况
            else if (weight > 1)
                count += base;
            base *= 10;
        }
        return count;
    }
}
