package DP;

public class longestCommon {
    public String longestCommon(String source, String target) {
        if (source.length() == 0 || target.length() == 0) {
            return "";
        }
        int[][] dp = new int[source.length() + 1][target.length() + 1];
        int globalmax = 0;
        int end = 0;
        for (int i = 1; i < source.length() + 1; i++) {
            for (int j = 1; j < target.length() + 1; j++) {
                if (source.charAt(i - 1) == target.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                if (dp[i][j] > globalmax) {
                    globalmax = dp[i][j];
                    end = i - 1;
                }
            }
        }
        return source.substring(end - globalmax + 1, end + 1);
    }
}
