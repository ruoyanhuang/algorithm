package LeetCode.Topic.DFS;

import entity.TreeNode;

public class binaryTreeMaximumPathSum {
    public int maxPathSum(TreeNode root) {
        int[] max = new int[]{0, Integer.MIN_VALUE};
        boolean[] hasPositive = new boolean[]{false};
        findPath(root, max, hasPositive);
        return hasPositive[0] ? max[0] : max[1];
    }

    private int findPath(TreeNode root, int[] max, boolean[] hasPositive) {
        if (root == null) {
            return 0;
        }
        if (root.val >= 0) {
            hasPositive[0] = true;
        } else {
            max[1] = Math.max(max[1], root.val);
        }
        int left = findPath(root.left, max, hasPositive);
        int right = findPath(root.right, max, hasPositive);
        if (left + right + root.val > 0 && left + right + root.val > max[0]) {
            max[0] = left + right + root.val;
        }
        return Math.max(left, right) + root.val > 0 ? Math.max(left, right) + root.val : 0;
    }
}
