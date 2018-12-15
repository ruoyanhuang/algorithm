package DP;

import java.util.Arrays;

public class largestSquare1 {
    public int largest(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int[][] dp = new int[matrix.length][matrix[0].length];
        int globalmax = 0;
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = matrix[i][j] == 1 ? 1 : 0;
                } else {
                    if (matrix[i][j] == 0) {
                        dp[i][j] = 0;
                    } else if (dp[i - 1][j - 1] == 0 || dp[i - 1][j] == 0 || dp[i][j - 1] == 0) {
                        dp[i][j] = matrix[i][j] == 1 ? 1 : 0;
                    } else {
                        dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]);
                        dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1]) + 1;
                    }
                }
                globalmax = Math.max(globalmax, dp[i][j]);
            }
        }
        for (int i = 0; i < dp.length; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }
        return globalmax;
    }
}
