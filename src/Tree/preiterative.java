package Tree;

import entity.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class preiterative {
    public List<Integer> preOrder(TreeNode root) {
        if (root == null) {
            return null;
        }
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        stack.offerFirst(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pollFirst();
            res.add(node.key);
            if (node.right != null) {
                stack.offerFirst(node.right);
            }
            if (node.left != null) {
                stack.offerFirst(node.left);
            }
        }
        return res;
    }
}
