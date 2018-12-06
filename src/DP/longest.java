package DP;

public class longest {
    public String longest(String source, String target) {
        if (source.length() == 0 || target.length() == 0) {
            return null;
        }
        int[][] dp = new int[source.length() + 1][target.length() + 1];
        for (int i = 1; i < source.length(); i++) {
            for (int j = 1; j < target.length(); j++) {
                if (source.charAt(i - 1) == target.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        //return dp[source.length()][target.length()];
        int row = source.length();
        int col = target.length();
        StringBuilder sb = new StringBuilder();
        while (row >= 1 && col >= 1) {
            if (source.charAt(row - 1) == target.charAt(col - 1)) {
                sb.append(source.charAt(row - 1));
                row--;
                col--;
            } else {
                if (dp[row - 1][col] > dp[row][col - 1]) {
                    row--;
                } else {
                    col--;
                }
            }
        }
        return sb.reverse().toString();
    }
}
