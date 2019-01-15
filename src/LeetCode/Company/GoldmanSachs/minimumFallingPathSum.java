//package LeetCode.Company.GoldmanSachs;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class minimumFallingPathSum {
//    private static final int[] directions = new int[]{-1, 0, 1};
//
//    public int minFallingPathSum(int[][] A) {
//        int[][] dp = new int[A.length][A[0].length];
//        int globalMin = Integer.MAX_VALUE;
//        for (int i = 0; i < dp.length; i++) {
//            for (int j = 0; j < dp[0].length; j++) {
//                if (i == 0) {
//                    dp[i][j] = A[i][j];
//                } else {
//                    int localmin = Integer.MAX_VALUE;
//                    for (int direction : directions) {
//                        int c = j + direction;
//                        if (!isOutOfBound(c, A[0].length)) {
//                            localmin = Math.min(localmin, dp[i - 1][c]);
//                        }
//                    }
//                    dp[i][j] = localmin + A[i][j];
//                }
//            }
//        }
//        for (int k = 0; k < A[0].length; k++) {
//            globalMin = Math.min(globalMin, dp[A.length - 1][k]);
//        }
//        List<Integer> aaa = new ArrayList<>();
//        aaa.remove()
//        return globalMin;
//    }
//
//    private boolean isOutOfBound(int x, int row) {
//        return x < 0 || x >= row;
//    }
//
//}
