package Review1;

import entity.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

public class checkIfBinaryTreeIsCompleted {
    public boolean isCompleted(TreeNode root) {
        if (root == null) {
            return true;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        boolean lastParent = false;
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (!lastParent && (cur.left != null || cur.right != null)) {
                return false;
            }
            if (cur.left == null && cur.right != null) {            //        2
                return false;                                       //       /  \
            }                                                       //    null   1
            if (cur.left == null || cur.right == null) {
                lastParent = true;
            }
            if (cur.left != null) {
                queue.offer(cur.left);
            }
            if (cur.right != null) {
                queue.offer(cur.right);
            }
        }
        return true;
    }
}
