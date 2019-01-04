package LeetCode.Topic.DFS;

import entity.TreeNode;

public class recoverBST {
    TreeNode leftBound = null;
    TreeNode rightBound = null;
    TreeNode prev = new TreeNode(Integer.MIN_VALUE);

    public void recoverTree(TreeNode root) {
        inOrder(root);
        int tmp = leftBound.val;
        leftBound.val = rightBound.val;
        rightBound.val = tmp;
    }

    public void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        if (leftBound == null && prev.val > root.val) {
            leftBound = prev;
        }
        if (leftBound != null && prev.val > root.val) {
            rightBound = root;
        }
        prev = root;
        inOrder(root.right);
    }
}
