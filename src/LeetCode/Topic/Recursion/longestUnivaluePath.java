package LeetCode.Topic.Recursion;

import entity.TreeNode;

public class longestUnivaluePath {
    public int longestUnivaluePath(TreeNode root) {
        int[] max = new int[]{0};
        longestPath(root, max);
        return max[0];
    }

    private int longestPath(TreeNode root, int[] max) {
        if (root == null) {
            return 0;
        }
        int left = longestPath(root.left, max);
        int right = longestPath(root.right, max);
        int curleft = 0;
        int curright = 0;
        if (root.left != null && root.val == root.left.val) {
            curleft += left + 1;
        }
        if (root.right != null && root.val == root.right.val) {
            curright += right + 1;
        }
        max[0] = Math.max(max[0], curleft + curright);
        return Math.max(curleft, curright);
    }
}
