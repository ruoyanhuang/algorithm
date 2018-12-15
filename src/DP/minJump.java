package DP;

public class minJump {
    public int minjump(int[] array) {
        if (array == null || array.length == 0) {
            return -1;
        }
        int[] dp = new int[array.length];
        dp[0] = 0;
        for (int i = 1; i < dp.length; i++) {
            int localmin = Integer.MAX_VALUE;
            for (int j = 0; j < i; j++) {
                if (dp[j] > 0 && i - j <= array[j]) {
                    localmin = Math.min(localmin, dp[j] + 1);
                }
            }
            if (localmin <Integer.MAX_VALUE) {
                dp[i] = localmin;
            } else {
                dp[i] = -1;
            }
        }
        return dp[array.length - 1];
    }
}
