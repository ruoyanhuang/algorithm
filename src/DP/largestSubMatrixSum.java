package DP;

import java.util.Arrays;

public class largestSubMatrixSum {
    public int largest(int[][] matrix) {
        int[][] prefix = new int[matrix.length][matrix[0].length];
        prefix[0][0] = matrix[0][0];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (i == 0 && j > 0) {
                    prefix[i][j] = prefix[i][j - 1] + matrix[i][j];
                } else if (j == 0 && i > 0) {
                    prefix[i][j] = prefix[i - 1][j] + matrix[i][j];
                } else if (i > 0 && j > 0) {
                    prefix[i][j] = prefix[i - 1][j] + prefix[i][j - 1] - prefix[i - 1][j - 1] + matrix[i][j];
                }
            }
        }
        int globalmax = matrix[0][0];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j <= i; j++) {
                int[] pre = new int[matrix[0].length];
                if (j == 0) {
                    pre[0] = prefix[i][0];
                } else {
                    pre[0] = prefix[i][0] - prefix[j - 1][0];
                }
                for (int k = 1; k < matrix[0].length; k++) {
                    if (j == 0) {
                        pre[k] = prefix[i][k] - prefix[i][k - 1];
                    } else {
                        pre[k] = prefix[i][k] - prefix[i][k - 1] - prefix[j - 1][k] + prefix[j - 1][k - 1];
                    }
                }
                int[] dp = new int[matrix[0].length];
                dp[0] = pre[0];
                for (int k = 1; k < matrix[0].length; k++) {
                    if (dp[k - 1] <= 0) {
                        dp[k] = pre[k];
                    } else {
                        dp[k] = pre[k] + dp[k - 1];
                    }
                    globalmax = Math.max(globalmax, dp[k]);
                }
            }
        }
        return globalmax;
    }
}
