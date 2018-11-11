package Tree;

public class symmetric {
    public class TreeNode {
        public int key;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(int key) {
            this.key = key;
        }
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return sym(root.left, root.right);
    }

    public boolean sym(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        } else if (left != null && right == null || left == null && right != null) {
            return false;
        } else if (left.key != right.key) {
            return false;
        }
        return sym(left.left, right.right) && sym(left.right, right.left);
    }
}
