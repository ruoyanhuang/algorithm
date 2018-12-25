package LeetCode.Company.Amazon;

public class coinChange {
    public int coinChange(int[] coins, int amount) {
//        if (coins == null || coins.length == 0 || amount < 0) {
//            return -1;
//        }
//        int[][] dp = new int[coins.length + 1][amount + 1]; //dp[i][j]: min # of coins 0,1,...i to sum amount j
//        for (int i = 0; i < dp.length; i++) {
//            for (int j = 0; j < dp[0].length; j++) {
//                if (j == 0) {
//                    dp[i][j] = 0;
//                } else if (i == 0) {
//                    dp[i][j] = -1;
//                } else {
//                    if (dp[i - 1][j] == -1 && (j < coins[i - 1] || dp[i][j - coins[i - 1]] == -1)) {
//                        dp[i][j] = -1;
//                    } else if (dp[i - 1][j] == -1) {
//                        dp[i][j] = dp[i][j - coins[i - 1]] + 1;
//                    } else {
//                        if (j < coins[i - 1] || dp[i][j - coins[i - 1]] == -1) {
//                            dp[i][j] = dp[i - 1][j];
//                        } else {
//                            dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - coins[i - 1]] + 1);
//                        }
//                    }
//                }
//            }
//        }
//        for (int i = 0; i < dp.length; i++) {
//            System.out.println(Arrays.toString(dp[i]));
//        }
//        return dp[coins.length][amount];
        if (coins == null || coins.length == 0 || amount < 0) {
            return -1;
        }
        int[] globalmin = new int[]{Integer.MAX_VALUE};
        dfs(coins, amount, 0, globalmin, 0);
        return globalmin[0] == Integer.MAX_VALUE ? -1 : globalmin[0];
    }

    public void dfs(int[] coins, int amount, int level, int[] globalmin, int localmin) {
        if (level == coins.length) {
            if (amount == 0) {
                globalmin[0] = Math.min(globalmin[0], localmin);
            }
            return;
        }
        for (int i = 0; i <= amount / coins[level]; i++) {
            dfs(coins, amount - i * coins[level], level + 1, globalmin, localmin + i);
        }
    }
}
