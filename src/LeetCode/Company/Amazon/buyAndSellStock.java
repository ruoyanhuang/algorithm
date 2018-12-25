package LeetCode.Company.Amazon;

public class buyAndSellStock {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int sell = 0;
        int buy = prices[0];
        for (int i = 1; i < prices.length; i++) {
            buy = Math.min(buy, prices[i]);
            if (prices[i] - buy > sell) {
                sell = prices[i] - buy;
            }
        }
        return sell;
    }
}
