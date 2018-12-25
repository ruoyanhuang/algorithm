package LeetCode.Company.Amazon;

public class jumpGameII {
    public int jump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return 1;
        }
        int[] dp = new int[nums.length]; //dp[i]: minimum step to reach end
        dp[nums.length - 1] = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            int localmin;
            if (nums[i] >= nums.length - i) {
                localmin = 1;
            } else {
                localmin = Integer.MAX_VALUE;
                for (int j = i + nums[i]; j > i; j++) {
                    localmin = Math.min(localmin, dp[j] + 1);
                }
            }
        }
        return dp[0];
    }
}
