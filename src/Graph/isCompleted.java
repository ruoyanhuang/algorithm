package Graph;

import entity.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class isCompleted {
    public boolean isCompleted(TreeNode root) {
        if (root == null) {
            return true;
        }
        boolean lastFull = false;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left == null && node.right != null) {
                return false;
            }
            if (lastFull == true && (node.left != null || node.right != null)) {
                return false;
            }
            if (node.left == null || node.right == null) {
                lastFull = true;
            }
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        return true;
    }
}
