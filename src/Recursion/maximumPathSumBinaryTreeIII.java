package Recursion;

import entity.TreeNode;

public class maximumPathSumBinaryTreeIII {
    public int maxPathSum(TreeNode root) {
        int[] globalmax = new int[]{root.val};
        recursion(root, 0, globalmax);
        return globalmax[0];
    }

    private void recursion(TreeNode root, int prefix, int[] globalmax) {
        if (root == null) {
            return;
        }
        if (prefix > 0) {
            prefix += root.val;
        } else {
            prefix = root.val;
        }
        globalmax[0] = Math.max(globalmax[0], prefix);
        recursion(root.left, prefix, globalmax);
        recursion(root.right, prefix, globalmax);
    }
}
