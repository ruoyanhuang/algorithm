package LeetCode.Company.Amazon;

import entity.TreeNode;

public class constructBST {
    public int construct(int[] array, int x, int y) {
        if (array == null || array.length == 0) {
            return -1;
        }
        TreeNode root = new TreeNode(array[0]);
        for (int i = 1; i < array.length; i++) {
            insert(root, array[i]);
        }
        TreeNode a = new TreeNode(x);
        TreeNode b = new TreeNode(y);
        boolean[] contain = new boolean[2];
        bothInBST(root, a, b, contain);
        if (!contain[0] || !contain[1]) {
            return -1;
        }
        return distance(root, a, b);
    }

    private TreeNode insert(TreeNode root, int target) {
        if (root == null) {
            return new TreeNode(target);
        }
        if (target < root.val) {
            root.left = insert(root.left, target);
        } else if (target > root.val) {
            root.right = insert(root.right, target);
        }
        return root;
    }

    private void bothInBST(TreeNode root, TreeNode a, TreeNode b, boolean[] contain) {
        if (root == null) {
            return;
        }
        if (root == a) {
            contain[0] = true;
        }
        if (root == b) {
            contain[1] = true;
        }
        bothInBST(root.left, a, b, contain);
        bothInBST(root.right, a, b, contain);
    }

    private boolean contains(TreeNode root, TreeNode target) {
        if (root == null) {
            return false;
        }
        if (root == target) {
            return true;
        }
        return contains(root.left, target) || contains(root.right, target);
    }

    private int depth(TreeNode root, TreeNode target) {
        if (root == null) {
            return -1;
        }
        if (root == target) {
            return 0;
        }
        int left = depth(root.left, target);
        int right = depth(root.right, target);
        if (left >= 0) {
            return left + 1;
        } else if (right >= 0) {
            return right + 1;
        } else {
            return -1;
        }
    }

    private int distance(TreeNode root, TreeNode a, TreeNode b) {
        if (root == null) {
            return -1;
        }
        if (root == a) {
            if (contains(a, b)) {
                return depth(a, b);
            } else {
                return 0;
            }
        }
        if (root == b) {
            if (contains(b, a)) {
                return depth(b, a);
            } else {
                return 0;
            }
        }
        int left = distance(root.left, a, b);
        int right = distance(root.right, a, b);
        if (left >= 0 && right >= 0) {
            return left + right + 1;
        } else if (left >= 0) {
            return left + 1;
        } else if (right >= 0) {
            return right + 1;
        } else {
            return -1;
        }
    }
}
