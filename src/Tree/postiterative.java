package Tree;

import entity.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class postiterative {
    public List<Integer> postOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        stack.offerFirst(root);
        TreeNode prev = null;
        while (!stack.isEmpty()) {
            TreeNode cur = stack.peekFirst();
            if (prev == null || cur == prev.left || cur == prev.right) {
                if (cur.left != null) {
                    stack.offerFirst(cur.left);
                } else if (cur.right != null) {
                    stack.offerFirst(cur.right);
                } else {
                    res.add(cur.val);
                    stack.pollFirst();
                }
            } else if (prev == cur.left) {
                if (cur.right != null) {
                    stack.offerFirst(cur.right);
                } else {
                    res.add(cur.val);
                    stack.pollFirst();
                }
            } else {
                res.add(cur.val);
                stack.pollFirst();
            }
            prev = cur;
        }
        return res;
    }
}
