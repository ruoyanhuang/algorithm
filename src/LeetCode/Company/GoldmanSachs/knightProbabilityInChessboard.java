package LeetCode.Company.GoldmanSachs;

public class knightProbabilityInChessboard {
    private static final int[][] directions = new int[][]{{1,2},{2,1},{2,-1},{1,-2},{-1,-2},{-2,-1},{-2,1},{-1,2}};

    public double knightProbability(int N, int K, int r, int c) {
        double[][][] dp = new double[N][N][K + 1];
        dp[r][c][0] = 1;
        for (int k = 1; k <= K; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    for (int[] direction : directions) {
                        int row = i + direction[0];
                        int col = j + direction[1];
                        if (!isOutOfBound(row, col, N, N)) {
                            dp[i][j][k] += dp[row][col][k - 1] * 0.125;
                        }
                    }
                }
            }
        }
        double res = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                res += dp[i][j][K];
            }
        }
        return res;
    }

    private boolean isOutOfBound(int x, int y, int row, int col) {
        return x < 0 || x >= row || y < 0 || y >= col;
    }
}
