package LeetCode.Topic.DFS;

import entity.TreeNode;

public class validateBST {
    public boolean isValidBST(TreeNode root) {
        long leftBound = (long) Integer.MIN_VALUE - 1;
        long rightBound = (long) Integer.MAX_VALUE + 1;
        return validBST(root, leftBound, rightBound);
    }

    private boolean validBST(TreeNode root, long leftBound, long rightBound) {
        if (root == null) {
            return true;
        } else if (root.val <= leftBound || root.val >= rightBound) {
            return false;
        } else {
            return validBST(root.left, leftBound, root.val) && validBST(root.right, root.val, rightBound);
        }
    }
}
