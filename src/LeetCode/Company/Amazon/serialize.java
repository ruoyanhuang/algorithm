package LeetCode.Company.Amazon;

import entity.TreeNode;

public class serialize {
    public String serialize(TreeNode root) {
        if (root == null) {
            return new String();
        }
        StringBuilder sb = new StringBuilder();
        ser(root, sb);
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    public void ser(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("null,");
            return;
        }
        sb.append(root.val);
        sb.append(",");
        ser(root.left, sb);
        ser(root.right, sb);
    }

    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) {
            return null;
        }
        String[] str = data.split(",");
        int[] index = new int[]{0};
        return recursion(str, index);
    }

    public TreeNode recursion(String[] str, int[] index) {
        if (str[index[0]].equals("null") || index[0] == str.length) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(str[index[0]]));
        index[0] = index[0] + 1;
        root.left = recursion(str, index);
        index[0] = index[0] + 1;
        root.right = recursion(str, index);
        return root;
    }
}
