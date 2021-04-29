package ByteDance;

import java.util.*;

public class Solution403 {
    public boolean canCross(int[] stones) {
        // 先确定从第一块石头能不能跳到第二块
        if (stones[1] != 1) return false;
        // 先用map记录每块石头在的位置
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < stones.length; i++) map.put(stones[i], i);
        HashSet<Integer> set = new HashSet<>();
        List<Integer>[] dp = new List[stones.length];
        dp[1] = new ArrayList<>(); dp[1].add(1);
        for (int i = 0; i < stones.length; i++){
            // 获取到达当前需要的步数
            List<Integer> tmp = dp[i];
            if (tmp == null) continue; // 注意这里只是跳过，因为中间可以有石头没跳上
            // 保证不重复
            for (int step : tmp){
                if (step > 1) set.add(step - 1);
                set.add(step);
                set.add(step + 1);
            }
            for (int next : set){
                if (map.containsKey(stones[i] + next)){
                    int index = map.get(stones[i] + next);
                    if (dp[index] == null) dp[index] = new ArrayList<>();
                    // 上一步花了多少跳过来的
                    dp[index].add(next);
                }
            }
            set.clear(); // 清空
        }
        return dp[stones.length - 1] != null;
    }

    public boolean canCross2(int[] stones) {
        int n = stones.length;
        // 先用map记录每块石头在的位置
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < stones.length; i++) map.put(stones[i], i);
        // dp[i][j] 表示能否跳j步到达第i个节点
        boolean[][] dp = new boolean[n][n];
        dp[0][0] = true;
        for (int i = 0; i < n - 1; i++){
            for (int j = 0; j < n; j++){
                // 如果可以跳到
                if (dp[i][j]){
                    if (j - 1 > 0 && map.containsKey(stones[i] + j - 1)) dp[map.get(stones[i] + j - 1)][j-1] = true;
                    if (j > 0 && map.containsKey(stones[i] + j)) dp[map.get(stones[i] + j)][j] = true;
                    if (map.containsKey(stones[i] + j + 1)) dp[map.get(stones[i] + j + 1)][j+1] = true;
                }
            }
        }
        for (int i = 0; i < n; i++) if (dp[n-1][i]) return true;
        return false;
    }

    public static void main(String[] args) {
        int[] stones = {0,1,3,5,6,8,12,17};
        boolean res = new Solution403().canCross2(stones);
    }
}
