package LeetCode.Company.Amazon;

public class palindrome {
    public String longestPalindrome(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }
        int[][] dp = new int[s.length()][s.length()];
        int max = 1;
        int start = 0;
        int end = 0;
        for (int j = 0; j < s.length(); j++) {
            for (int i = 0; i <= j; i++) {
                if (i == j) {
                    dp[i][j] = 1;
                } else if (j == i + 1) {
                    dp[i][j] = s.charAt(i) == s.charAt(j) ? 2 : 0;
                } else if (i < j) {
                    if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1] > 0) {
                        dp[i][j] = dp[i + 1][j - 1] + 2;
                    } else {
                        dp[i][j] = 0;
                    }
                }
                if (max < dp[i][j]) {
                    max = dp[i][j];
                    start = i;
                    end = j;
                }
            }
        }
        return s.substring(start, end + 1);
    }
}
