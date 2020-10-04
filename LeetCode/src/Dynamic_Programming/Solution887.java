package Dynamic_Programming;

import java.util.HashMap;
import java.util.Map;

/**
 * 2020.10.04
 * Super Egg Drop
 * K 个鸡蛋和一栋从 1 到 N共有 N 层楼的建筑。
 * 1 <= K <= 100
 * 1 <= N <= 10000
 */
public class Solution887 {
    public int superEggDrop(int K, int N) {
        return dp(K, N);
    }

    Map<Integer, Integer> memo = new HashMap<>();

    public int dp(int K, int N){
        if (memo.containsKey(N * 100 + K)){
            return memo.get(N * 100 + K);
        }
        int ans;
        if (K == 1) {
            ans = N;
        }else if (N == 0) {
            ans = 0;
        }else{
            // 遍历从1到N的楼层
            int lo = 1, hi = N;
            // 这个条件保证 lo 与 hi之间最多相差1
            while (lo + 1 < hi){
                int x = (lo + hi) / 2;
                // 假设鸡蛋碎了，从剩下x - 1层楼选，是x的递增函数
                int t1 = dp(K - 1, x - 1);
                // 假设鸡蛋没碎，从剩下N - x层楼选，是x的递减函数
                int t2 = dp(K, N - x);
                if (t1 < t2){
                    // 真实交点在x右边
                    lo = x;
                }else if (t1 > t2){
                    // 真实交点在x左边
                    hi = x;
                }else{
                    // 真实交点就是x
                    lo = hi = x;
                }
            }
            ans = 1 + Math.min(Math.max(dp(K - 1, lo - 1), dp(K, N - lo)), Math.max(dp(K-1, hi-1), dp(K, N - hi)));
        }
        memo.put(N * 100 + K, ans);
        return ans;
    }
}
