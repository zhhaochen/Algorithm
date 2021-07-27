package ByteDance;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution554 {
    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer, Integer> map = new HashMap<>();
        for (List<Integer> cur : wall){
            int sum = 0;
            int n = cur.size();
            // 除了最右边缘的
            for (int i = 0; i < n - 1; i++){
                sum += cur.get(i);
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }
        // 找到最多的空隙
        int max = 0;
        for (Map.Entry<Integer, Integer> entry: map.entrySet()){
            max = Math.max(max, entry.getValue());
        }
        return wall.size() - max;
    }
    // 如果 width过大，会内存溢出
    public int leastBricks_bad(List<List<Integer>> wall) {
        // 墙的宽度
        int width = 0;
        for (int w : wall.get(0)) width += w;
        // 如果不可能存在砖缝
        if (width == 1) return wall.size();
        // 墙的高度
        int height = wall.size();
        int[][] dp = new int[height][width-1];
        // 对于每一层砖
        for (int i = 0; i < height; i++){
            // 当前层
            List<Integer> wall_cur = wall.get(i);
            // 记录空隙位置
            int cur = wall_cur.get(0);
            int index = 1;
            for (int j = 0; j < width - 1; j++){
                if (j + 1 == cur){
                    if (i == 0) dp[i][j] = 0;
                    else {
                        dp[i][j] = dp[i-1][j];
                        if (index < wall_cur.size()) cur += wall_cur.get(index);
                        index++;
                    }
                }else {
                    if (i == 0) dp[i][j] = 1;
                    else dp[i][j] = dp[i-1][j] + 1;
                }
            }
        }
        // 看最后一层
        int min = height;
        for (int num : dp[height-1]) min = Math.min(min, num);
        return min;
    }
}
