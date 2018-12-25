package LeetCode.Topic.DP;

public class numWays {
    public int numWays(int n, int k) {
        if (n == 0 || k == 0) {
            return 0;
        }
        int[] num = new int[n];
        int[] repeatnum = new int[n];
        num[0] = k;
        repeatnum[0] = 0;
        for (int i = 1; i < n; i++) {
            num[i] = (num[i - 1] - repeatnum[i - 1]) * k + repeatnum[i - 1] * (k - 1);
            repeatnum[i] = num[i - 1] - repeatnum[i - 1];
        }
        return num[n - 1];
    }
}
