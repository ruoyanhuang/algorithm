package LeetCode.Amazon;

public class buyAndSellStock2 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int sell = 0;
        for (int i = 1; i < prices.length; i++) {
            int max = Math.max(0, prices[i] - prices[i - 1]);
            sell += max;
        }
        return sell;
    }
}
