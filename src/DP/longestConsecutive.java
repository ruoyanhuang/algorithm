package DP;

public class longestConsecutive {
    public int longest(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int[] dp = new int[array.length];
        dp[0] = array[0];
        int globalmax = dp[0];
        for (int i = 1; i < dp.length; i++) {
            if (array[i] == 1) {
                dp[i] = dp[i - 1] + 1;
            } else {
                dp[i] = 0;
            }
            globalmax = Math.max(globalmax, dp[i]);
        }
        return globalmax;
    }
}
