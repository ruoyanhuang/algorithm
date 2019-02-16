package LeetCode.Topic.Tree;

import entity.TreeNode;

public class countUnivalueSubtrees {
    public int univalSubtrees(TreeNode root) {
        int[] num = new int[1];
        count(root, num);
        return num[0];
    }

    private int count(TreeNode root, int[] num) {
        if (root == null) {
            return Integer.MAX_VALUE;
        }
        int left = count(root.left, num);
        int right = count(root.right, num);
        if ((left == root.val || left == Integer.MAX_VALUE) && (right == root.val || right == Integer.MAX_VALUE)) {
            num[0]++;
            return root.val;
        } else {
            return Integer.MIN_VALUE;
        }
    }
}
