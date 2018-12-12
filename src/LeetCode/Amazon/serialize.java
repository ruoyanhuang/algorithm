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
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if (cur.left == null) {
                    sb.append("null,");
                } else {
                    sb.append(cur.left.key);
                    sb.append(',');
                    queue.offer(cur.left);
                }
                if (cur.right == null) {
                    sb.append("null,");
                } else {
                    sb.append(cur.right.key);
                    sb.append(',');
                    queue.offer(cur.right);
                }
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) {
            return null;
        }
        String[] str = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(str[0]));
        recursion(str, 0, root);
        return root;
    }

    public void recursion(String[] str, int index, TreeNode root) {
        if (root == null) {
            return;
        }
        if (index + 1 < str.length) {

        }
    }
}
