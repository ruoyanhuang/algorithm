package LeetCode.Topic.DFS;

public class targetSum {
    public int findTargetSumWays(int[] nums, int S) {
        int[] count = new int[]{0};
        dfs(nums, S, 0, 0, count);
        return count[0];
    }

    private void dfs(int[] nums, int S, int level, int sum, int[] count) {
        if (level == nums.length) {
            if (S == sum) {
                count[0]++;
            }
            return;
        }
        dfs(nums, S, level + 1, sum + nums[level], count);
        dfs(nums, S, level + 1, sum - nums[level], count);
    }
}
