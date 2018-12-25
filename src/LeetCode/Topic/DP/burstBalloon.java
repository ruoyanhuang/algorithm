package LeetCode.Topic.DP;

public class burstBalloon {
    public int maxCoins(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] newnums = new int[nums.length + 2];
        newnums[0] = 1;
        newnums[newnums.length - 1] = 1;
        for (int i = 0; i < nums.length; i++) {
            newnums[i + 1] = nums[i];
        }
        int dp[][] = new int[newnums.length][newnums.length];
        for (int i = dp.length - 1; i >= 0; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (i >= j - 1) {
                    dp[i][j] = 0;
                } else {
                    int max = 0;
                    for (int k = i + 1; k < j; k++) {
                        int cur = newnums[i] * newnums[k] * newnums[j] + dp[i][k] + dp[k][j];
                        max = Math.max(max, cur);
                    }
                    dp[i][j] = max;
                }
            }
        }
        return dp[0][newnums.length - 1];
    }
}
