package JianZhi_Offer;

/**
 * 2019.11.4
 * 跳台阶
 *
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 * 本质是一个排列组合问题
 */

public class Solution8 {

    public static void main(String[] args) {
        System.out.println(JumpFloor(29));
    }

    /**
     * 做法2
     * 当target = 1时，直接跳1阶台阶
     * 当target = 2时，可以跳一个2或者两个1
     * 则target = n时，相当于 f(n) = f(n-1) + f(n-2)，即对应最后一步跳1或者跳2的情况
     */
    private static int JumpFloor_(int target){
        if (target == 0)
            return 0;
        if(target == 1)
            return 1;
        if (target==2)
            return 2;
        int pre = 1;
        int result = 2;
        for (int i = 3; i<=target;i++){
            int tmp = result;
            result += pre;
            pre = tmp;
        }
        return result;
    }

    // 做法1，排列组合做法
    private static int JumpFloor(int target) {
        if (target==0){
            return 0;
        }else if (target == 1){
            return 1;
        }
        int count = 0;
        int n = target; //刚开始全跳1的情况
        int m = 0;
        for (int i = 0; i<=target/2; i++){ //注意是<=而不是<，因为第一次是全1的情况，不属于这个次数
            count += C_n_m(n+m, m);
            m++;
            n -= 2;
        }
        return count;
    }
    //排列组合问题，当算出台阶数共有n个1和2组成，2的个数为m个时
    private static int C_n_m(int n, int m){
        // C_n_m = n!/(m! * (n-m)!)
        if (n == 0){
            return 0;
        }else {
            // 注意这里要设为long类型，否则当m增大时，除法之前的a和b会过大而溢出，最终得到错误结果
            long a = 1;
            long b = 1;
            for (int i = 1; i<=m; i++, n--){
                a *= n;
                b *= i;
            }
            return (int)(a/b);
        }
    }
}
