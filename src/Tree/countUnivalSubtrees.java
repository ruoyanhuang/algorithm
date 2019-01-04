package Tree;

import entity.TreeNode;

public class countUnivalSubtrees {
    public int countUnivalSubtrees(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int count = isUnival(root) ? 1 : 0;
        return count + countUnivalSubtrees(root.left) + countUnivalSubtrees(root.right);
    }

    public boolean isUnival(TreeNode root) {
        if (root == null) {
            return true;
        } if (root.left != null && root.val != root.left.val || root.right != null && root.val != root.right.val) {
            return false;
        }
        return isUnival(root.left) && isUnival(root.right);
    }
}
