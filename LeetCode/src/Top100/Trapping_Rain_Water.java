package Top100;

/**
 * 2020.11.18
 * Given n non-negative integers representing an elevation map where the width of each bar is 1,
 * compute how much water it can trap after raining.
 * 计算降水量，给的是一个地形高度
 */
public class Trapping_Rain_Water {
    public int trap(int[] height) {
        int len = height.length;
        // dp[i]表示height[i]左右最大值的较小值
        int[] dp = new int[len];
        int mx = 0;
        int res = 0;
        for (int i = 0; i < len; i++){
            dp[i] = mx;
            mx = Math.max(mx, height[i]);
        }
        mx = 0;
        for (int i = len -1; i >=0; i--){
            // 从右边开始找，最大值与当前的左边最大值比较取较小值
            dp[i] = Math.min(mx, dp[i]);
            mx = Math.max(mx, height[i]);
            if (dp[i] > height[i]){
                res += (dp[i] - height[i]);
            }
        }
        return res;
    }
}
