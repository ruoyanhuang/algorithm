package LeetCode.Company.FaceBook;

public class decodeWays {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }
        int t = Integer.parseInt(s.substring(0,2));
        int[] dp = new int[s.length()];
        dp[0] = 1;
        if (t <= 26 && t >= 1 && t % 10 != 0) {
            dp[1] = 2;
        } else if (s.charAt(0) - '0' > 2 && s.charAt(1) == '0') {
            return 0;
        } else {
            dp[1] = 1;
        }
        for (int i = 2; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                if (s.charAt(i - 1) - '0' > 2 || s.charAt(i - 1) - '0' < 1) {
                    return 0;
                } else {
                    dp[i] = dp[i - 2];                  // xxxxx 20
                }
            } else {
                int m = s.charAt(i - 1) - '0';
                int n = s.charAt(i) - '0';
                int j = 10 * m + n;
                if (j < 10 || j > 26) {
                    dp[i] = dp[i - 1];                  // xxxxx3 1
                } else {
                    dp[i] = dp[i - 1] + dp[i - 2];      // xxxxx2 1 or xxxx 21
                }
            }
        }
        return dp[dp.length - 1];
    }
}
