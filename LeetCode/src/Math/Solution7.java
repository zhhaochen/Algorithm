package Math;

/**
 * 2020.4.7
 * Reverse Integer
 *
 * Given a 32-bit signed integer, reverse digits of an integer.
 * Input: 120
 * Output: 21
 *
 * Input: -123
 * Output: -321
 * 范围： [−2^31,  2^31 − 1]  =》 [-2147483648,2147483647]
 */
public class Solution7 {
    public static void main(String[] args) {
        System.out.println(reverse(-123));
    }

    public static int reverse(int x) {
        //我写的就是一堆垃圾，还是官方牛皮
        long result = 0;
        int flag = x>0 ? 1 : -1;
        x = Math.abs(x);
        int len = (x+"").length();
        for (int i = len-1; i>=0; i--){ //中间这部分写的过于垃圾
            int tmp = (int)Math.pow(10,i);
            result += (x/tmp)*Math.pow(10, len-i-1);
            x = x%(tmp);
        }
        result = flag*result;
        //但是用long来扩大范围进行比较的思想是好的
        if (result>Integer.MAX_VALUE || result<Integer.MIN_VALUE){
            return 0;
        }else {
            return (int)result;
        }
    }

    public int reverse2(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) {return 0;}
            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) {return 0;}
            rev = rev * 10 + pop;
        }
        return rev;
    }
}
