/**
 * 斐波那契数列
 */
public class Solution10_1 {
    public static void main(String[] args) {
        System.out.println(Fibonacci2(1));
    }
    //递归做法，简单但是效率低
    public long Fibonacci(int n){
        if (n<=0)
            return 0;
        if (n==1)
            return 1;
        return Fibonacci(n-2) + Fibonacci(n-1);
    }
    //循环做法
    public static long Fibonacci2(int n){
        if (n<=0)
            return 0;
        int pre = 0;
        int pre2 = 1;
        int tump;
        for (int i=1; i<n; i++){
            tump = pre2;
            pre2 = pre+pre2;
            pre = tump;
        }
        return pre2;
    }
}

