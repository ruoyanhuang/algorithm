package LeetCode.Company.Amazon;

import entity.TreeNode;

public class serializeBST {
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        postOrder(root, sb);
        return sb.toString();
    }

    public void postOrder(TreeNode root, StringBuilder sb) {
        if (root == null) {
            return;
        }
        postOrder(root.left, sb);
        postOrder(root.right, sb);
        sb.append(root.val);
        sb.append(",");
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) {
            return null;
        }
        String[] str = data.split(",");
        int[] index = new int[]{str.length - 1};
        return helper(str, index, Integer.MIN_VALUE);
    }

    public TreeNode helper(String[] str, int[] index, int min) {
        if (index[0] < 0 || Integer.parseInt(str[index[0]]) < min) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(str[index[0]]));
        index[0]--;
        root.right = helper(str, index, root.val);
        root.left = helper(str, index, min);
        return root;
    }
}
