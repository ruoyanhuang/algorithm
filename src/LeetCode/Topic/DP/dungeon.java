package LeetCode.Topic.DP;

public class dungeon {
    public int calculateMinimumHP(int[][] dungeon) {
        if (dungeon == null || dungeon.length == 0 || dungeon[0].length == 0) {
            return 0;
        }
        int[][] dp = new int[dungeon.length][dungeon[0].length];
        int[][] hp = new int[dungeon.length][dungeon[0].length];
        dp[0][0] = dungeon[0][0] > 0 ? 1 : 1 - dungeon[0][0];
        hp[0][0] = dungeon[0][0] > 0 ? dungeon[0][0] : 1;
        for (int i = 0; i < dungeon.length; i++) {
            for (int j = 0; j < dungeon[0].length; j++) {
                if (i > 0 && j == 0) {
                    if (hp[i - 1][j] + dungeon[i][j] > 0) {
                        hp[i][j] = hp[i - 1][j] + dungeon[i][j];
                        dp[i][j] = dp[i - 1][j];
                    } else {
                        hp[i][j] = 1;
                        dp[i][j] = dp[i - 1][j] + 1 - (hp[i - 1][j] + dungeon[i][j]);
                    }
                } else if (i == 0 && j > 0) {
                    if (hp[i][j - 1]  + dungeon[i][j] > 0) {
                        hp[i][j] = hp[i][j - 1] + dungeon[i][j];
                        dp[i][j] = dp[i][j - 1];
                    } else {
                        hp[i][j] = 1;
                        dp[i][j] = dp[i][j - 1] + 1 - (dp[i][j - 1]  + dungeon[i][j]);
                    }
                } else if (i > 0 && j > 0) {
                    int hp1 = 0;
                    int dp1 = 0;
                    int hp2 = 0;
                    int dp2 = 0;
                    //case1: take up path
                    if (hp[i - 1][j] + dungeon[i][j] > 0) {
                        hp1 = hp[i - 1][j] + dungeon[i][j];
                        dp1 = dp[i - 1][j];
                    } else {
                        hp1 = 1;
                        dp1 = dp[i - 1][j] + 1 - (hp[i - 1][j] + dungeon[i][j]);
                    }
                    //case2: take left path
                    if (hp[i][j - 1] + dungeon[i][j] > 0) {
                        hp2 = hp[i][j - 1] + dungeon[i][j];
                        dp2 = dp[i][j - 1];
                    } else {
                        hp2 = 1;
                        dp2 = dp[i][j - 1] + 1 - (hp[i - 1][j] + dungeon[i][j]);
                    }
                    //compare the best path
                    if (dp1 < dp2) {
                        hp[i][j] = hp1;
                        dp[i][j] = dp1;
                    } else {
                        hp[i][j] = hp2;
                        dp[i][j] = dp2;
                    }
                }
            }
        }
        return dp[dungeon.length - 1][dungeon[0].length - 1];
    }
}
