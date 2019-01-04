package Tree;

import entity.TreeNode;

public class isIdentical {
    public boolean isIdentical(TreeNode one, TreeNode two) {
        if (one == null && two == null) {
            return true;
        } else if (one == null || two == null || one.val != two.val) {
            return false;
        }
        return isIdentical(one.left, two.left) && isIdentical(one.right, two.right);
    }
}
