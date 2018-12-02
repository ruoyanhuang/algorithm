package Tree;

import entity.TreeNode;

public class invertTree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode reverse = new TreeNode(root.key);
        reverse.left = invertTree(root.right);
        reverse.right = invertTree(root.left);
        return reverse;
    }
}
