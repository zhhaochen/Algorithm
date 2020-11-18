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

    // 双指针方法，只需要遍历一遍
    public int trap2(int[] height) {
        int len = height.length;
        int left = 0;
        int right = len-1;
        int mx = 0;
        int res = 0;
        while(left < right){
            mx = Math.min(height[left], height[right]);
            if(mx == height[left]){
                left++;
                while(left < right && height[left] < mx){
                    res += (mx - height[left++]);
                }
            }else{
                right--;
                while(left < right && height[right] < mx){
                    res += (mx - height[right--]);
                }
            }
        }
        return res;
    }
}
