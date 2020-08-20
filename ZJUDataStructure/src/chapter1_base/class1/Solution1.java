package chapter1_base.class1;

//多项式 f = a0 + a1x + a2x^2 + ... + anx^n

//提取公因式 f = a0 + x(a1 + x(a2 + x(a3 + x(...(an-1 + an*x)))))
public class Solution1 {

    public static void main(String[] args) {

    }

    private static double multi_pow(double x, double[] a){
        int n = a.length - 1;
        double p = a[n];
        for (int i = n; i>0; i--) {
            p = a[n-1] + p*x;
        }
        return p;
    }
}
