package DP;

public class maxProduct {
    public int maxProduct(int length) {
        if (length < 2) {
            return 0;
        }
        int[] dp = new int[length - 1]; // dp[i]: max product end at i
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i < dp.length; i++) {
            int localmax = 0;
            for (int j = 0; j < i; j++) {
                localmax = Math.max(localmax, Math.max(j, dp[j]) * (i - j));
            }
            dp[i] = localmax;
        }
        return dp[dp.length - 1];
    }
}
