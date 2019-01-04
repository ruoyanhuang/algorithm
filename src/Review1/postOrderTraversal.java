package Review1;

import entity.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class postOrderTraversal {
    public List<Integer> postOrder(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        TreeNode prev = null;
        while (!stack.isEmpty() || prev == null) {
            TreeNode cur = stack.peek();
            if (prev == null || prev.left == cur || prev.right == cur) {
                if (cur.left != null) {
                    stack.push(cur.left);
                } else if (cur.right != null) {
                    stack.push(cur.right);
                } else {
                    res.add(cur.val);
                    stack.pop();
                }
            } else if (prev == cur.left) {
                if (cur.right != null) {
                    stack.push(cur.right);
                } else {
                    res.add(cur.val);
                    stack.pop();
                }
            } else {
                res.add(cur.val);
                stack.pop();
            }
        }
        return res;
    }
}
