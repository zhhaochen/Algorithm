package DynamicProgramming;

public class Solution70 {
    public int climbStairs(int n) {
        if(n < 4) return n;
        int pre = 1, cur = 2;
        for(int i = 3; i <= n; i++){
            cur += pre;
            pre = cur - pre;
        }
        return cur;
    }
}
