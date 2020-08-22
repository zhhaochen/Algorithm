package Challenge_30_Day.May.week6;
/**
 * Given a positive integer, output its complement number.
 * The complement strategy is to flip the bits of its binary representation.
 */
public class Number_Complement {
    public static void main(String[] args) {
        System.out.println(findComplement(7));
    }
    public static int findComplement(int num) {
        int count= 2;
        int copy = num;
        while (num > 1){
            count *= 2;
            num = num >> 1;
        }
        return  count-1-copy;
    }
}
