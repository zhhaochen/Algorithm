package JianZhiOffer;

public class Solution63 {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int min = Integer.MAX_VALUE;
        for (int price : prices){
            min = Math.min(min, price);
            profit = Math.max(price - min, profit);
        }
        return profit;
    }
}
