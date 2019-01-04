package LeetCode.Topic.DFS;

import entity.TreeNode;

public class sumRootToLeafNumbers {
    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int[] totalSum = new int[]{0};
        dfs(root, 0, totalSum);
        return totalSum[0];
    }

    private void dfs(TreeNode root, int pathSum, int[] totalSum) {
        pathSum = pathSum * 10 + root.val;
        if (root.left == null && root.right == null) {
            totalSum[0] += pathSum;
            return;
        }
        if (root.left != null) {
            dfs(root.left, pathSum, totalSum);
        }
        if (root.right != null) {
            dfs(root.right, pathSum, totalSum);
        }
    }
}
