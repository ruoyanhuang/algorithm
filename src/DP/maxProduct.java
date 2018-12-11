package DP;

public class maxProduct {
    public int maxProduct(int length) {
        int[] dp = new int[length - 1];
        dp[0] = length - 1;
        int globalmax = 0;
        for (int i = 1; i < dp.length; i++) {
            int localmax = i;
            for (int j = 0; j < i; j++) {
                localmax = Math.max(localmax, dp[j] * (i - j));
            }
            dp[i] = localmax * (length - i);
            globalmax = Math.max(globalmax, dp[i]);
        }
        return globalmax;
    }
}
