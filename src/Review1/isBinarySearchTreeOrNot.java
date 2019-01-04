package Review1;

import entity.TreeNode;

public class isBinarySearchTreeOrNot {
    public boolean isBST(TreeNode root) {
        int left = Integer.MIN_VALUE;
        int right = Integer.MAX_VALUE;
        return binarySearchTree(root, left, right);
    }

    private boolean binarySearchTree(TreeNode root, int left, int right) {
        if (root == null) {
            return true;
        } else if (root.val <= left || root.val >= right) {
            return false;
        } else {
            return binarySearchTree(root.left, left, root.val) && binarySearchTree(root.right, root.val, right);
        }
    }
}
