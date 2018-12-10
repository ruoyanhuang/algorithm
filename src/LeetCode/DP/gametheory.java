package LeetCode.DP;

public class gametheory {
    public int greedystrategy(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int[][] dp = new int[array.length][array.length];
        for (int i = array.length - 1; i >= 0; i--) {
            for (int j = 0; j < array.length; j++) {
                if (j - i <= 1 && j - i >= 0) {
                    dp[i][j] = Math.max(array[i], array[j]);
                } else if (j > i) {
//                        if (array[i + 1] >= array[j]) {
//                            dp[i][j] = Math.max(dp[i][j], array[i] + dp[i + 2][j]);
//                        } else {
//                            dp[i][j] = Math.max(dp[i][j], array[i] + dp[i + 1][j - 1]);
//                        }
                        int max1 = Math.min(dp[i + 2][j], dp[i + 1][j - 1]) + array[i];
//                        if (array[i] > array[j - 1]) {
//                            dp[i][j] = Math.max(dp[i][j], array[j] + dp[i + 1][j - 1]);
//                        } else {
//                            dp[i][j] = Math.max(dp[i][j], array[j] + dp[i][j - 2]);
//                        }
                        int max2 = Math.min(dp[i + 1][j - 1], dp[i][j - 2]) + array[j];
                        dp[i][j] = Math.max(max1, max2);
                }
            }
        }
        return dp[0][array.length - 1];
    }
}
