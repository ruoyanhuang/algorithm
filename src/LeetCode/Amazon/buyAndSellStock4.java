package LeetCode.Amazon;

public class buyAndSellStock4 {
    public int maxProfit(int k, int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int[][] dp = new int[prices.length][k + 1];
        for (int j = 0; j <= k; j++) {
            int tmax = -prices[0];
            for (int i = 0; i < dp.length; i++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else {
                    for (int l = 0; l < i; l++) {
                        dp[i][j] = Math.max(prices[i] + tmax, prices[i] - prices[l] + dp[l][j - 1]);
                        tmax = Math.max(tmax, prices[i] - dp[i][j - 1]);
                    }
                }
            }
        }
        return dp[prices.length - 1][k];
    }
}
