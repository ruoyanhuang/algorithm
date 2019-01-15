package Recursion;

import entity.TreeNode;

public class maximumPathSumBinaryTreeII {
    public int maxPathSum(TreeNode root) {
        int[] globalmax = new int[]{root.val};
        recursion(root, globalmax);
        return globalmax[0];
    }

    private int recursion(TreeNode root, int[] globalmax) {
        if (root == null) {
            return 0;
        }
        int leftSum = recursion(root.left, globalmax);
        int rightSum = recursion(root.right, globalmax);
        globalmax[0] = Math.max(globalmax[0], leftSum + rightSum + root.val);
        int curSum = Math.max(leftSum, rightSum) + root.val;
        return curSum > 0 ? curSum : 0;
    }
}
