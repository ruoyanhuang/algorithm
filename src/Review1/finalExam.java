package Review1;

public class finalExam {
    public int minCut(int target) {
        int[] dp = new int[target +1];
        dp[0] = 0;
        for (int i = 1; i < dp.length; i++) {
            int localMin = Integer.MAX_VALUE;
            for (int j = 0; j < i; j++) {
                if ((j == 0 || dp[j] > 0) && isSquare(i - j)) {
                    localMin = Math.min(localMin, dp[j] + 1);
                }
            }
            dp[i] = localMin;
        }
        return dp[target];
    }

    private boolean isSquare(int target) {
        int squareRoot = (int)Math.sqrt(target);
        return target == squareRoot * squareRoot;
    }
}
