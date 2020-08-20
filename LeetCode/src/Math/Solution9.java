package Math;

/**
 * 2020.4.17
 * Palindrome Number
 *
 * Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.
 * Input: -121
 * Output: false
 * Input: 121
 * Output: true
 */
public class Solution9 {
    public static void main(String[] args) {
        System.out.println(isPalindrome(123221));
    }

    //思路，用题7的反转数字判别是否相同即可
    public static boolean isPalindrome(int x) {
        if (x < 0) { //只有正数可以被判别
            return false;
        }
        int rev = 0;
        int copy = x;
        while (x != 0) {
            int pop = x % 10;
            x = x / 10;
            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) {
                return false; //越界必错
            }
            rev = rev * 10 + pop;
        }
        return rev == copy;
    }
}
