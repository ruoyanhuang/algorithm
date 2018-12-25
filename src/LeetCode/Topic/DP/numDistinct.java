package LeetCode.Topic.DP;

public class numDistinct {
    public int numDistinct(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) {
            return 0;
        }
//        int[][] dp = new int[s.length() + 1][t.length() + 1];      // dp[i][j] means number of matches until S[i] and T[j]
//        for (int i = 0; i < s.length() + 1; i++) {
//            dp[i][0] = 1;
//        }
//        for (int i = 1; i < s.length() + 1; i++) {
//            for (int j = 1; j < t.length() + 1; j++) {
//                if (s.charAt(i - 1) != t.charAt(j - 1)) {
//                    dp[i][j] = dp[i - 1][j];
//                } else {
//                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
//                }
//            }
//        }
//        return dp[s.length()][t.length()];
        int[][] dp = new int[2][t.length()];
        dp[0][0] = 1;
        dp[1][0] = 1;
        for (int i = 0; i < s.length()+ 1; i++) {
            for (int j = 0; j < t.length(); j++) {
                if (s.charAt(i - 1) != t.charAt(j - 1)) {
                    dp[1][j] = dp[0][j];
                    dp[0][j - 1] = dp[1][j -1];
                } else {
                    dp[1][j] = dp[0][j] + dp[0][j - 1];
                    dp[0][j - 1] = dp[1][j -1];
                }
            }
            dp[0][t.length()] = dp[1][t.length()];
        }
        return dp[1][s.length()];
    }
}
