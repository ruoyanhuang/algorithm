package DP;

public class largestSubarraySum {
    public int largestSum(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int[] dp = new int[array.length];
        dp[0] = array[0];
        int globalmax = dp[0];
        for (int i = 1; i < dp.length; i++) {
            if (dp[i - 1] <= 0) {
                dp[i] = array[i];
            } else {
                dp[i] = dp[i - 1] + array[i];
            }
            globalmax = Math.max(globalmax, dp[i]);
        }
        return globalmax;
    }
}
