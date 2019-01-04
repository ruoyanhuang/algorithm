package LeetCode.Topic.DFS;

import entity.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

public class findBottomLeftTreeValue {
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            TreeNode first = queue.peek();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            if (queue.isEmpty()) {
                return first.val;
            }
        }
        return -1;
    }
}
