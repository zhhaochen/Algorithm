package Hot100;

public class Solution309 {
    public int maxProfit(int[] prices) {
        // 两种操作的不同利润
        int[] in = new int[prices.length + 1]; // 第i天手里有股票
        int[] out = new int[prices.length + 1]; // 第i天手里没有股票
        in[0] = Integer.MIN_VALUE; out[0] = 0;
        in[1] = -prices[0]; out[1] = 0;
        for (int i = 2; i < prices.length + 1; i++){
            // 今天手里没有，要么昨天有今天卖掉，要么是昨天就没有
            out[i] = Math.max(in[i-1] + prices[i-1], out[i-1]);
            // 今天手里有，要么是昨天手里就有，要么是昨天没有且没有操作，今天买入
            // 如果昨天没有且没有操作，意味着是前天就没有
            in[i] = Math.max(in[i-1], out[i-2] - prices[i-1]);
        }
        return out[prices.length];
    }
}
