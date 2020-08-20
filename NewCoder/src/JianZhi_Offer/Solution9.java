package JianZhi_Offer;

/**
 * 2019.11.9
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 */
public class Solution9 {
    /**
     * 类比简单跳台阶
     * target=1, 1
     * target=2, 2
     * f(n) = 1 + f(n-1) + f(n-2) + ... + f(1)，1代表直接跳n阶的跳法，可以直接加法计算
     * 或f(n-1) = 1 + f(n-2) + ... + f(1)
     * f(n) - f(n-1) = f(n-1) => f(n) = 2f(n-1)，等比数列
     */
    public int JumpFloorII(int target) {
        if (target > 0)
            return (int)Math.pow(2, target-1);
        return 0;
    }
}
