package JianZhi_Offer;

public class Solution12 {
    // 暴力求解法
    public double Power(double base, int exponent) {
        if (exponent == 0)
            return 1;
        if (base == 0)
            return 0;
        int n = Math.abs(exponent);
        double result = 1;
        for (int i = 0; i<n; i++){
            result = result*base;
        }
        if (exponent < 0)
            return 1/result;
        return result;
    }
    // 快速求幂法
    public double Power_(double base, int exponent){
        int n = Math.abs(exponent);
        double result = 1;
        while (n!=0){
            if (n % 2 == 1){
                result *= base;
            }
            base *= base;
            n /= 2;
        }
        if (exponent < 0)
            return 1/result;
        return result;
    }
}
