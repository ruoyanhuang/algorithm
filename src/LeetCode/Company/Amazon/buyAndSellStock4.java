package LeetCode.Company.Amazon;

public class buyAndSellStock4 {
    public int maxProfit(int k, int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        if (k >= prices.length / 2) {
            return quickSolve(prices);
        }
        int[][] dp = new int[prices.length][k + 1];
        for (int i = 1; i < dp.length; i++) {
            int tmax = -prices[0];
            for (int j = 1; j <= k; j++) {
                dp[i][j] = Math.max(prices[i] + tmax, dp[i - 1][j]);
                tmax = Math.max(tmax, dp[i - 1][j - 1] - prices[i]);
            }
        }
        return dp[prices.length - 1][k];
    }

    private int quickSolve(int[] prices) {
        int len = prices.length;
        int profit = 0;
        for (int i = 1; i < len; i++) {
            if (prices[i] > prices[i - 1]) {
                profit += prices[i] - prices[i - 1];
            }
        }
        return profit;
    }
}
