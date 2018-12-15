package DP;

public class editDistance1 {
    public int editDistance(String one, String two) {
        if (one == null || one.length() == 0) {
            return two.length();
        } else if (two == null || two.length() == 0) {
            return one.length();
        }
        int[][] dp = new int[one.length() + 1][two.length() + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j <dp[0].length; j++) {
                if (j == 0) {
                    dp[i][j] = i;
                } else if (i == 0) {
                    dp[i][j] = j;
                } else if (one.charAt(i - 1) == two.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i][j - 1] + 1, dp[i - 1][j] + 1);
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1] + 1);
                }
            }
        }
        return dp[one.length()][two.length()];
    }
}
