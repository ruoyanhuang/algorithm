package LeetCode.Topic.DFS;

import entity.TreeNode;

public class houseRobberIII {
    public int rob(TreeNode root) {
        return dfs(root, true);
    }

    private int dfs(TreeNode root, boolean canVisit) {
        if (root == null) {
            return 0;
        }
        int left = dfs(root.left, true);
        int right = dfs(root.right, true);
        int rootAndLeft = dfs(root.left, false);
        int rootAndRight = dfs(root.right, false);
        if (!canVisit) {
            return left + right;
        } else {
            return  Math.max(root.val + rootAndLeft + rootAndRight, left + right);
        }
    }
}
