package LeetCode.Topic.DFS;

import entity.TreeNode;

public class pathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        return findPathSum(root, 0, sum);
    }

    private boolean findPathSum(TreeNode root, int pathValue, int sum) {
        if (root.left == null && root.right == null) {
            if (pathValue + root.val == sum) {
                return true;
            } else {
                return false;
            }
        }
        pathValue += root.val;
        if (root.left == null) {
            return findPathSum(root.right, pathValue, sum);
        } else if (root.right == null) {
            return findPathSum(root.left, pathValue, sum);
        } else {
            return findPathSum(root.left, pathValue, sum) || findPathSum(root.right, pathValue, sum);
        }
    }
}
