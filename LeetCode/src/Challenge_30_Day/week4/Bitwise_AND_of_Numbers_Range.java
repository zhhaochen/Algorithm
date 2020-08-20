package Challenge_30_Day.week4;

public class Bitwise_AND_of_Numbers_Range {
    public static void main(String[] args) {
        System.out.println(rangeBitwiseAnd(5, 8));
    }
    public static int rangeBitwiseAnd(int m, int n) {
        int count = 1;
        while (m != n){
            m /=2;
            n/=2;
            count *= 2;
        }
        return m*count;
    }
}
