package JianZhiOffer;

public class Solution14_1 {
    public int cuttingRope(int n) {
        if (n <= 3) return n - 1;
        int count_3 = n / 3;
        n %= 3;
        int count_2 = n / 2;
        if (n % 2 != 0){
            count_2 += 2;
            count_3--;
        }
        return (int) (Math.pow(3, count_3) * Math.pow(2, count_2));
    }
}
