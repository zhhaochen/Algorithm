package DailyChallenge;

import java.util.Map;

public class Solution1846 {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        int n = arr.length;
        // 计数排序
        int[] cnt = new int[n + 1];
        // 计数
        for (int num : arr) cnt[Math.min(num, n)]++;
        int miss = 0;
        for (int i = 1; i <= n; i++){
            if (cnt[i] == 0) miss++;
            // cnt[i]多出来的能否填充之前的部分，因为只能减小值
            else miss -= Math.min(cnt[i] - 1, miss);
        }
        return n - miss;
    }
}
