package Tree;

public class tweaked {
    public class TreeNode {
        public int key;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(int key) {
            this.key = key;
        }
    }

    public boolean isTweakedIdentical(TreeNode one, TreeNode two) {
        if (one == null && two == null) {
            return true;
        } else if (one != null && two == null || one == null && two != null) {
            return false;
        } else if (one.key != two.key) {
            return false;
        }

        return isTweakedIdentical(one.left, two.left) && isTweakedIdentical(one.right, two.right) || isTweakedIdentical(one.left, two.right) && isTweakedIdentical(one.right, two.left);
    }
}
