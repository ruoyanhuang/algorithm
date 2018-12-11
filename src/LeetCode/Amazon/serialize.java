package LeetCode.Amazon;

import entity.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

public class serialize {
    public String serialize(TreeNode root) {
        if (root == null) {
            return new String();
        }
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        sb.append(root.key);
        sb.append(',');
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (root.left == null) {
                sb.append("null,");
            } else {
                sb.append(root.left.key);
                sb.append(',');
                queue.offer(root.left);
            }
            if (root.right == null) {
                sb.append("null,");
            } else {
                sb.append(root.right.key);
                sb.append(',');
                queue.offer(root.right);
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) {
            return null;
        }
        TreeNode root = new TreeNode(data.charAt(0));
        recursion(data, 0, root);
        return root;
    }

    public void recursion(String data, int index, TreeNode root) {
        if (index >= data.length()) {
            return;
        }
        if (2 * index + 1 < data.length()) {
            root.left = new TreeNode(data.charAt(2 * index + 1));
            recursion(data, 2 * index + 1, root.left);
        }
        if (2 * index + 2 < data.length()) {
            root.right = new TreeNode(data.charAt(2 * index + 2));
            recursion(data, 2 * index + 2, root.right);
        }
    }
}
