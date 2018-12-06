package LeetCode.DP;

public class expression {
    public double largestexpression(double[] array) {
//        if (array == null || array.length == 0) {
//            return 0;
//        }
//        double[][] dp = new double[array.length][array.length];
//        for (int i = dp.length - 1; i >= 0; i--) {
//            for (int j = 0; j < dp[0].length; j++) {
//                if (i == j) {
//                    dp[i][j] = array[i];
//                } else {
//                    for (int k = i; k < j; k++) {
//                        dp[i][j] = Math.max(dp[i][j], dp[i][k] + dp[k + 1][j]);
//                        dp[i][j] = Math.max(dp[i][j], dp[i][k] * dp[k + 1][j]);
//                    }
//                }
//            }
//        }
//        return dp[0][array.length - 1];

        if (array == null || array.length == 0) {
            return 0;
        }
        double[][] dpmax = new double[array.length][array.length];
        double[][] dpmin = new double[array.length][array.length];
        for (int i = dpmax.length - 1; i >= 0; i--) {
            for (int j = 0; j < dpmax[0].length; j++) {
                if (i == j) {
                    dpmax[i][j] = array[i];
                    dpmin[i][j] = array[i];
                } else {
                    for (int k = i; k < j; k++) {
                        dpmax[i][j] = Math.max(dpmax[i][j], dpmax[i][k] + dpmax[k + 1][j]);
                        dpmax[i][j] = Math.max(dpmax[i][j], dpmax[i][k] * dpmax[k + 1][j]);
                        dpmax[i][j] = Math.max(dpmax[i][j], dpmin[i][k] * dpmin[k + 1][j]);
                        dpmin[i][j] = Math.min(dpmin[i][j], dpmin[i][k] + dpmin[k + 1][j]);
                        dpmin[i][j] = Math.min(dpmin[i][j], dpmax[i][k] * dpmin[k + 1][j]);
                        dpmin[i][j] = Math.min(dpmin[i][j], dpmin[i][k] * dpmax[k + 1][j]);
                    }
                }
            }
        }
        return dpmax[0][array.length - 1];
    }
}
