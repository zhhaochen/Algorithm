package Array;

/**
 * 2020.4.19
 * Plus One
 * Given a non-empty array of digits representing a non-negative integer, plus one to the integer.
 * The digits are stored such that the most significant digit is at the head of the list, and each element in the array contain a single digit.
 * You may assume the integer does not contain any leading zero, except the number 0 itself.
 * Input: [1,2,3]
 * Output: [1,2,4]
 * Explanation: The array represents the integer 123.
 */
public class Solution66 {
    //复杂实现
    public int[] plusOne(int[] digits) {
        int c=1;
        for(int i=digits.length-1; i>=0; i--){
            int tmp = (digits[i]+c)/10;
            digits[i] = (digits[i]+c)%10;
            c = tmp;
        }
        if(c!=0){
            int[] new_digits = new int[digits.length+1];
            new_digits[0] = c;
            for(int i=1; i<new_digits.length; i++){
                new_digits[i] = digits[i-1];
            }
            return new_digits;
        }
        return digits;
    }
    //简单实现，不需要上面那么复杂一个个看
    public int[] plusOne2(int[] digits) {
        int n = digits.length;
        for(int i=n-1; i>=0; i--){
            if (digits[i]<9){
                digits[i]++; //因为只是最后加1，所以没有进位时直接返回即可，到了这里意味着低位会进位到这里
                return digits;
            }
            digits[i] = 0; //进位最多是1，所以直接为0
        }
        if (digits[0]==0){ //意味着输入全是9
            int[] res = new int[n+1];
            res[0] = 1;
            return res;
        }
        return digits;
    }
}
