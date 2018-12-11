package DP;

public class canJump {
    public boolean canJump(int[] array) {
        if (array.length == 1 && array[0] == 0) {
            return true;
        }
        boolean[] dp = new boolean[array.length];
        dp[0] = array[0] != 0;
        for (int i = 1; i < array.length; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && array[j] >= (i - j)) {
                    dp[i] = true;
                }
            }
        }
        return dp[array.length - 1];
    }
}
