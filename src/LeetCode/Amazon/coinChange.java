package LeetCode.Amazon;

public class coinChange {
    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0 || amount <= 0) {
            return -1;
        }
        int[][] dp = new int[coins.length + 1][amount + 1]; //dp[i][j]: min # of coins 0,1,...i to sum amount j
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (i == 0 && j > 0) {
                    dp[i][j] = -1;
                } else if (j == 0) {
                    dp[i][j] = 0;
                } else {
                    if (i > 0 && dp[i - 1][j] == -1 && (amount < coins[i] || dp[i][amount - coins[i]] == -1)) {
                        dp[i][j] = -1;
                    } else if (amount < coins[i]) {
                        dp[i][j] = dp[i - 1][amount];
                    } else {
                        dp[i][j] = Math.min(dp[i - 1][amount], dp[i - 1][amount - coins[i]] + 1);
                    }
                }
            }
        }
        return dp[coins.length][amount];
    }
}
