package Tree;

import entity.TreeNode;

public class isBST {

    public boolean isBST(TreeNode root) {
        int left = Integer.MIN_VALUE;
        int right = Integer.MAX_VALUE;
        return bst(root, left, right);
    }

    public boolean bst(TreeNode root, int left, int right) {
        if (root == null) {
            return true;
        }
        if (root.val < left || root.val > right) {
            return false;
        }
        return bst(root.left, left, root.val) && bst(root.right, root.val, right);
    }
//    public int fib(int k) {
//        int a = 0;
//        int b = 1;
//        if (k <= 0) {
//            return a;
//        }
//        while (k > 1) {
//            int tmp = b;
//            b = a + b;
//            a = tmp;
//            k--;
//        }
//        return b;
//    }
}
