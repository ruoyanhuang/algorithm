package Tree;

public class balanced {
    public class TreeNode {
        public int key;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(int key) {
            this.key = key;
        }
    }

    public int findHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(findHeight(root.left), findHeight(root.right)) + 1;
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        int leftheight = findHeight(root.left);
        int rightheight = findHeight(root.right);
        if (Math.abs(leftheight - rightheight) > 1) {
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }
}
