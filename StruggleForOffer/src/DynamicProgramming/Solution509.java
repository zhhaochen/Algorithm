package DynamicProgramming;

public class Solution509 {
    public int fib(int n) {
        if(n < 2) return n;
        int pre = 0, cur = 1;
        for(int i = 2; i <= n; i++){
            cur += pre;
            pre = cur - pre;
        }
        return cur;
    }
}
