package LeetCode.Amazon;

import entity.TreeNode;

public class diameter {
    public int diameterOfBinaryTree(TreeNode root) {
        int[] max = new int[]{1};
        recursion(root, max);
        return max[0] - 1;
    }

    public int recursion(TreeNode root, int[] max) {
        if (root == null) {
            return 0;
        }
        int left = recursion(root.left, max);
        int right = recursion(root.right, max);
        max[0] = Math.max(max[0], left + right + 1);
        return Math.max(left, right) + 1;
    }
}
