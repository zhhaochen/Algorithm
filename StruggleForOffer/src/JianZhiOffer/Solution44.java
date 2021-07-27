package JianZhiOffer;

public class Solution44 {
    public int findNthDigit(int n) {
        if (n < 10) return n;
        int digit = 1; // 当前一共有多少位
        long start = 1; // 当前位数下的开头
        long count = 9; // 当前位数 - 1 后位最大值
        while (n > count){
            n -= count;
            start *= 10;
            digit++;
            count = 9 * start * digit;
        }
        // 从 start 开始，每 digit 个算一个数，n 从 1开始算下标
        start += (n - 1) / digit;
        n  = (n - 1) % digit;
        return (("" + start).charAt(n) - '0');
    }
}
