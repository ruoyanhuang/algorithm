package LeetCode.DP;

public class longestBinarySearch {
    public int longest(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int[] dp = new int[array.length];
        dp[0] = 1;
        int[] binary = new int[array.length];
        int globalmax = 0;
        for (int i = 1; i < array.length; i++) {
            int curmax = 0;
            for (int j = 0; j < i; j++) {
                if (array[i] > array[j]) {
                    curmax = Math.max(curmax, dp[j]);
                }
            }
            dp[i] = curmax + 1;
            globalmax = Math.max(globalmax, dp[i]);
        }
        return globalmax;
    }
}
