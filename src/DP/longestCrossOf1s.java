package DP;

import java.util.Arrays;

public class longestCrossOf1s {
    public int largest(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int[][][] dp = new int[matrix.length][matrix[0].length][4];
        int globalmax = 0;
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (matrix[i][j] == 0) {
                    dp[i][j][0] = 0;                    //from up to down
                    dp[i][j][1] = 0;                    //from left to right
                } else {
                    if (i == 0) {
                        dp[i][j][0] = 1;
                    } else {
                        dp[i][j][0] = dp[i - 1][j][0] + 1;
                    }
                    if (j == 0) {
                        dp[i][j][1] = 1;
                    } else {
                        dp[i][j][1] = dp[i][j - 1][1] + 1;
                    }
                }
            }
        }
        for (int i = dp.length - 1; i >= 0; i--) {
            for (int j = dp[0].length - 1; j >= 0; j--) {
                if (matrix[i][j] == 0) {
                    dp[i][j][2] = 0;                    //from down to up
                    dp[i][j][3] = 0;                    //from right to left
                } else {
                    if (i == dp.length - 1) {
                        dp[i][j][2] = 1;
                    } else {
                        dp[i][j][2] = dp[i + 1][j][2] + 1;
                    }
                    if (j == dp[0].length - 1) {
                        dp[i][j][3] = 1;
                    } else {
                        dp[i][j][3] = dp[i][j + 1][3] + 1;
                    }
                }
            }
        }
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                int localmin = Math.min(dp[i][j][0], dp[i][j][1]);
                localmin = Math.min(localmin, dp[i][j][2]);
                localmin = Math.min(localmin, dp[i][j][3]);
                globalmax = Math.max(globalmax, localmin);
            }
        }
        return globalmax;
    }
}
