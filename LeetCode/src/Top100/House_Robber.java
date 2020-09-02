package Top100;

/**
 * 2020.09.02
 * 一系列房子有不同的钱，不能抢劫相邻房子，求最大抢劫金额
 * 动态规划
 */
public class House_Robber {
    // 解法1：dp数组
    public int rob(int[] nums) {
        int len = nums.length;
        if (len == 1){
            return nums[0];
        }
        if (len == 0){
            return 0;
        }
        // dp[i] 表示 [0, i] 区间可以抢夺的最大值
        int[] dp = new int[len];
        //抢和不抢两种互斥的选择，不抢即为 dp[i-1]，抢即为 dp[i-2] + nums[i]，比较求大值
        dp[0] = nums[0];
        dp[1] = Math.max(dp[0], dp[0] + nums[1]);
        for (int i = 2; i<len; i++){
            dp[i] = Math.max(dp[i-2] + nums[i], dp[i-1]);
        }
        return dp[len-1];
    }
    // 解法2：区分抢偶数与抢奇数
    public int rob2(int[] nums){
        int robEven = 0;
        int robOdd = 0;
        int len = nums.length;
        for (int i = 0; i<len; i++){
            if (i % 2 == 0){
                robEven += nums[i];
                robEven = Math.max(robEven + nums[i], robOdd);
            }else{
                robOdd = Math.max(robEven, robOdd + nums[i]);
            }
        }
        return Math.max(robEven, robOdd);
    }
    // 解法3：区分抢与不抢
    public int rob3(int[] nums){
        int rob = 0;
        int notRob = 0;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            int preRob = rob;
            int preNotRob = notRob;
            // 抢的更新必然是前一个不抢 + 当前的
            rob = preNotRob + nums[i];
            // 不抢的更新即前一个抢或不抢的较大值
            notRob = Math.max(preRob, preNotRob);
        }
        return Math.max(rob, notRob);
    }
}
