package Tree;

import entity.TreeNode;

public class diameter {
    public int diameter(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.right == null) {
            return diameter(root.left);
        } else if (root.left == null) {
            return diameter(root.right);
        } else {
            return Math.max(Math.max(diameter(root.left), diameter(root.right)), height(root.left) + height(root.right) + 1);
        }
    }

    public int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(height(root.left), height(root.right)) + 1;
    }
}
