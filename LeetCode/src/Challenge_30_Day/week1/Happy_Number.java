package Challenge_30_Day.week1;

/**
 * A happy number is a number defined by the following process:
 * Starting with any positive integer, replace the number by the sum of the squares of its digits,
 * and repeat the process until the number equals 1 (where it will stay),
 * or it loops endlessly in a cycle which does not include 1.
 * Those numbers for which this process ends in 1 are happy numbers.
 * Input: 19
 * Output: true
 * Explanation:
 * 1^2 + 9^2 = 82
 * 8^2 + 2^2 = 68
 * 6^2 + 8^2 = 100
 * 1^2 + 0^2 + 0^2 = 1
 */
public class Happy_Number {
    public static void main(String[] args) {
        System.out.println(isHappy(32));
    }
    public static boolean isHappy(int n) {
        int copy = n;
        while (copy!=1){
            String input = copy+"";
            copy = 0;
            for (int i=0; i<input.length(); i++){
                int  intNum = input.charAt(i) - '0';
                copy += intNum*intNum;
            }
            if (copy==n || copy==4){ //TODO 非快乐数有一个特点，循环中必定有4
                return false;
            }
        }
        return true;
    }
}
