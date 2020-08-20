/**
 * 8个2x1的小矩形去覆盖一个2x8的矩形，共有多少种方法
 */
public class Solution10_3 {
    public int MethodNumber(int n){
        if (n == 1)
            return 1;
        if (n == 2)
            return 2;
        return MethodNumber(n-1) + MethodNumber(n-2);
    }
}
