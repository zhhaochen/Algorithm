public class Solution44 {
    public int findNthDigit(int n) {
        if (n < 10) return n;
        // 范围内的开始值
        long start = 1;
        // 范围内的位数
        long digit = 1;
        // 范围内的数字数
        long count = 9;
        while (n > count){
            n -= count;
            digit++;
            start *= 10;
            count = digit * start * 9;
        }
        // 目标数字或目标的前一个数字
        start += (n / digit) - 1;
        n %= digit;
        if (n != 0){
            start++;
            return (start + "").charAt(n - 1) - '0';
        }else{
            return (int)start % 10;
        }
    }

    public static void main(String[] args) {
        int res = new Solution44().findNthDigit(11);
        System.out.println(res);
    }
}
