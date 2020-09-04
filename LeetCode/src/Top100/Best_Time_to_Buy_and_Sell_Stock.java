package Top100;

/**
 * 2020.09.04
 * 买卖股票问题，只允许买卖一次，求最大收益率
 */
public class Best_Time_to_Buy_and_Sell_Stock {
    public int maxProfit(int[] prices){
        int profit = 0;
        int len = prices.length;
        if (len == 0 || len == 1){
            return profit;
        }
        int min = prices[0];
        for (int i = 1; i < len; i++) {
            // 更新收益
            if (prices[i] - min > profit){
                profit = prices[i] - min;
            }
            // 更新最小值
            if (prices[i] < min){
                min = prices[i];
            }
        }
        return profit;
    }
}
