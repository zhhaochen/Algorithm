package Amazon;

public class Solution1011 {
    //把数组分为 D 块，求每块的和的最大值的最小值
    public int shipWithinDays(int[] weights, int D) {
        // left 为数组中的最大值
        int left = Integer.MIN_VALUE;
        // right 为数组的和
        int right = 0;
        for (int weight : weights){
            left = Math.max(left, weight);
            right += weight;
        }
        while (left <= right){
            // 假定的最小值
            int mid = left + (right - left) / 2;
            int day = 1; // 需要的天数
            int cur = 0;
            for (int weight : weights){
                // 划分给下一天
                if (cur + weight > mid){
                    day++;
                    cur = 0;
                }
                cur += weight;
            }
            // 如果当前 mid 可以满足，说明 mid 可能过大或者正好，直接 mid - 1继续检测
            if (day <= D) right = mid - 1;
            else left = mid + 1;
        }
        return left;
    }
}
